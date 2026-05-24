package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TestReunion {

    private ReunionPresencial reunion;
    private Empleado empleado1;
    private Empleado empleado2;

    @TempDir
    Path tempDir;

    @BeforeEach
    void setup() {
        empleado1 = new Empleado("E001", "Juan", "Perez", "juan@empresa.cl");
        empleado2 = new Empleado("E002", "Ana", "Lopez", "ana@empresa.cl");

        reunion = new ReunionPresencial(
                new Date(),
                Instant.parse("2026-05-23T10:00:00Z"),
                Duration.ofHours(2),
                TipoReunion.TECNICA,
                "Sala 101"
        );
    }

    @Test
    @DisplayName("Registrar asistencia aumenta el total de asistentes")
    void registrarAsistenciaAumentaTotal() throws ParticipanteNuloException {
        reunion.registrarAsistencia(new Asistencia(empleado1));

        assertEquals(1, reunion.obtenerTotalAsistencia());
    }

    @Test
    @DisplayName("Obtener ausencias muestra invitados que no asistieron")
    void obtenerAusenciasFunciona() throws ParticipanteNuloException {
        reunion.agregarInvitacion(new Invitacion(Instant.now(), empleado1));
        reunion.agregarInvitacion(new Invitacion(Instant.now(), empleado2));

        reunion.registrarAsistencia(new Asistencia(empleado1));

        assertEquals(1, reunion.obtenerAusencias().size());
        assertEquals(empleado2, reunion.obtenerAusencias().get(0).getInvitado());
    }

    @Test
    @DisplayName("Porcentaje de asistencia se calcula correctamente")
    void porcentajeAsistenciaFunciona() throws ParticipanteNuloException {
        reunion.agregarInvitacion(new Invitacion(Instant.now(), empleado1));
        reunion.agregarInvitacion(new Invitacion(Instant.now(), empleado2));

        reunion.registrarAsistencia(new Asistencia(empleado1));

        assertEquals(50.0f, reunion.obtenerPorcentajeAsistencia());
    }

    @Test
    @DisplayName("Obtener retrasos detecta asistentes atrasados")
    void obtenerRetrasosFunciona() throws ParticipanteNuloException, HoraInvalidaException {
        reunion.registrarAsistencia(new Asistencia(empleado1));
        reunion.registrarAsistencia(new Retraso(empleado2, Instant.now()));

        assertEquals(1, reunion.obtenerRetrasos().size());
    }

    @Test
    @DisplayName("No se puede registrar asistencia nula")
    void asistenciaNulaLanzaExcepcion() {
        assertThrows(ParticipanteNuloException.class, () -> {
            reunion.registrarAsistencia(null);
        });
    }

    @Test
    @DisplayName("No se puede crear retraso sin hora")
    void retrasoSinHoraLanzaExcepcion() {
        assertThrows(HoraInvalidaException.class, () -> {
            new Retraso(empleado1, null);
        });
    }

    @Test
    @DisplayName("Calcular tiempo real funciona")
    void calcularTiempoRealFunciona() throws ReunionException {
        reunion.setHoraInicio(Instant.parse("2026-05-23T10:00:00Z"));
        reunion.setHoraFin(Instant.parse("2026-05-23T12:00:00Z"));

        assertEquals(2.0f, reunion.calcularTiempoReal());
    }

    @Test
    @DisplayName("Generar informe crea archivo txt")
    void generarInformeCreaArchivo() throws Exception {
        reunion.setHoraInicio(Instant.parse("2026-05-23T10:00:00Z"));
        reunion.setHoraFin(Instant.parse("2026-05-23T11:00:00Z"));

        reunion.agregarInvitacion(new Invitacion(Instant.now(), empleado1));
        reunion.registrarAsistencia(new Asistencia(empleado1));

        InformeReunion informe = new InformeReunion();
        Path archivo = tempDir.resolve("informe.txt");

        informe.generarInforme(reunion, archivo.toString());

        assertTrue(Files.exists(archivo));

        String contenido = Files.readString(archivo);
        assertTrue(contenido.contains("INFORME DE REUNION"));
        assertTrue(contenido.contains("Total asistentes: 1"));
    }
}