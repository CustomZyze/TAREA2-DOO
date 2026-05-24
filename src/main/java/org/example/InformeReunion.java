package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Clase encargada de generar un reporte (archivo de texto) con todos los
 * detalles relevantes de una reunión finalizada.
 */
public class InformeReunion {

    /**
     * Genera un archivo de texto que contiene el informe de la reunión,
     * incluyendo fechas, tiempos previstos y reales, y registro completo de las asistencias,
     * ausencias y retrasos.
     * * Si pasa un error al crear el archivo o al calcular los tiempos, se captura la
     * excepción y se imprime un mensaje de error en la consola.
     *
     * @param reunion       El objeto Reunion del cual se extraerán los datos para el informe.
     * @param nombreArchivo El nombre (y ruta opcional) del archivo de texto a crear (ej. "informe.txt").
     */
     public void generarInforme (Reunion reunion , String nombreArchivo){
        try{
            PrintWriter writer = new PrintWriter(new FileWriter((nombreArchivo)));
            writer.println("INFORME DE REUNION");
            writer.println("==================");
            writer.println();

            writer.println("Fecha: " + reunion.getFecha());
            writer.println("Hora prevista: " + reunion.getHoraPrevista());
            writer.println("Duracion prevista: " + reunion.getDuracionPrevista());

            writer.println();
            writer.println("Inicio real: " + reunion.getHoraInicio());
            writer.println("Fin real: " + reunion.getHoraFin());
            writer.println("Duracion real: " + reunion.calcularTiempoReal() + " horas");

            writer.println();
            writer.println("ASISTENCIA");
            writer.println("----------");
            writer.println("Total asistentes: " + reunion.obtenerTotalAsistencia());
            writer.println("Porcentaje asistencia: " + reunion.obtenerPorcentajeAsistencia() + "%");

            writer.println();
            writer.println("Presentes:");
            for (Asistencia asistencia : reunion.obtenerAsistencias()) {
                writer.println("- " + asistencia);
            }

            writer.println();
            writer.println("Ausentes:");
            for (Invitacion invitacion : reunion.obtenerAusencias()) {
                writer.println("- " + invitacion);
            }

            writer.println();
            writer.println("Retrasos:");
            for (Asistencia retraso : reunion.obtenerRetrasos()) {
                writer.println("- " + retraso);
            }

            writer.close();

        } catch (IOException | ReunionException e) {
            System.out.println("Error al generar el informe: " + e.getMessage());
        }
    }
}
