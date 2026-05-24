package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class InformeReunion {

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
