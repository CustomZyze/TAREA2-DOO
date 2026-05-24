package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TestInforme {

    private ReunionPresencial reunion;
    private InformeReunion informe;

    @TempDir
    Path tempDir;

    @BeforeEach
    void setup() {
        reunion = new ReunionPresencial(
                new Date(),
                Instant.parse("2026-05-23T10:00:00Z"),
                Duration.ofHours(2),
                TipoReunion.TECNICA,
                "Sala 1"
        );

        reunion.setHoraInicio(Instant.parse("2026-05-23T10:00:00Z"));
        reunion.setHoraFin(Instant.parse("2026-05-23T11:30:00Z"));

        informe = new InformeReunion();
    }

    @Test
    @DisplayName("Generar informe crea archivo txt")
    void generarInforme_creaArchivoTxt() {
        Path archivo = tempDir.resolve("informe.txt");

        informe.generarInforme(reunion, archivo.toString());

        assertTrue(Files.exists(archivo));
    }

    @Test
    @DisplayName("Generar informe contiene estructura principal")
    void generarInforme_contieneEstructuraPrincipal() throws IOException {
        Path archivo = tempDir.resolve("informe_estructura.txt");

        informe.generarInforme(reunion, archivo.toString());

        String contenido = Files.readString(archivo);

        assertTrue(contenido.contains("INFORME DE REUNION"));
        assertTrue(contenido.contains("Fecha:"));
        assertTrue(contenido.contains("Hora prevista:"));
        assertTrue(contenido.contains("Duracion prevista:"));
        assertTrue(contenido.contains("Inicio real:"));
        assertTrue(contenido.contains("Fin real:"));
        assertTrue(contenido.contains("ASISTENCIA"));
        assertTrue(contenido.contains("Presentes:"));
        assertTrue(contenido.contains("Ausentes:"));
        assertTrue(contenido.contains("Retrasos:"));
    }

    @Test
    @DisplayName("Generar informe incluye presentes ausentes y retrasos")
    void generarInforme_incluyePresentesAusentesYRetrasos() throws IOException, ParticipanteNuloException, HoraInvalidaException {
        Empleado presente = new Empleado("1", "Ana", "Lopez", "ana@empresa.cl");
        Empleado ausente = new Empleado("2", "Carlos", "Perez", "carlos@empresa.cl");
        Empleado atrasado = new Empleado("3", "Maria", "Gomez", "maria@empresa.cl");

        reunion.agregarInvitacion(new Invitacion(
                Instant.parse("2026-05-23T10:00:00Z"),
                presente
        ));

        reunion.agregarInvitacion(new Invitacion(
                Instant.parse("2026-05-23T10:00:00Z"),
                ausente
        ));

        reunion.agregarInvitacion(new Invitacion(
                Instant.parse("2026-05-23T10:00:00Z"),
                atrasado
        ));

        reunion.registrarAsistencia(new Asistencia(presente));

        reunion.registrarAsistencia(new Retraso(
                atrasado,
                Instant.parse("2026-05-23T10:15:00Z")
        ));

        Path archivo = tempDir.resolve("informe_asistencia.txt");

        informe.generarInforme(reunion, archivo.toString());

        String contenido = Files.readString(archivo);

        assertTrue(contenido.contains("Ana"));
        assertTrue(contenido.contains("Carlos"));
        assertTrue(contenido.contains("Maria"));
        assertTrue(contenido.contains("10:15:00Z"));
    }

    @Test
    @DisplayName("Generar informe muestra total porcentaje y duración real")
    void generarInforme_muestraResumenNumerico() throws IOException, ParticipanteNuloException {
        Empleado empleado1 = new Empleado("1", "Ana", "Lopez", "ana@empresa.cl");
        Empleado empleado2 = new Empleado("2", "Carlos", "Perez", "carlos@empresa.cl");

        reunion.agregarInvitacion(new Invitacion(
                Instant.parse("2026-05-23T10:00:00Z"),
                empleado1
        ));

        reunion.agregarInvitacion(new Invitacion(
                Instant.parse("2026-05-23T10:00:00Z"),
                empleado2
        ));

        reunion.registrarAsistencia(new Asistencia(empleado1));

        Path archivo = tempDir.resolve("informe_resumen.txt");

        informe.generarInforme(reunion, archivo.toString());

        String contenido = Files.readString(archivo);

        assertTrue(contenido.contains("Total asistentes: 1"));
        assertTrue(contenido.contains("Porcentaje asistencia: 50.0%"));
        assertTrue(contenido.contains("Duracion real: 1.5 horas"));
    }
}