package org.example;

import java.util.Date;
import java.time.Instant;
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;

/**
 * Modela una reunión remota que se realiza a través de internet usando un link de conexión.
 * Hereda el control de tiempo de la clase Reunion y gestiona sus propias listas
 * de invitados y asistentes virtuales.
 */
public class ReunionVirtual extends Reunion {
    /** El link o URL de la plataforma (Zoom, Teams, Meet, etc.) para entrar a la sesión. */
    private String enlace;
    /** Lista de las personas que efectivamente se conectaron a la reunión. */
    private List<Asistencia> asistencias;
    /** Lista de todos los usuarios o departamentos convocados. */
    private List<Invitacion> invitaciones;

    /**
     * Constructor para crear una reunión en línea.
     * Pasa los datos compartidos a la clase madre e inicializa los arreglos de datos.
     *
     * @param fecha            Día programado para el evento.
     * @param horaPrevista     Hora fija a la que debería arrancar el software.
     * @param duracionPrevista El bloque de tiempo estimado para la llamada.
     * @param tipoReunion      La categoría o tópico de la reunión.
     * @param enlace           Dirección web o código de acceso para unirse.
     */
    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista,TipoReunion tipoReunion, String enlace){
        super(fecha, horaPrevista, duracionPrevista, tipoReunion);
        this.enlace=enlace;
        this.asistencias=new ArrayList<>();
        this.invitaciones=new ArrayList<>();
    }

    /**
     * Registra un nuevo participante en la lista de conexiones exitosas.
     *
     * @param asistencia Datos del usuario que se conectó.
     * @throws ParticipanteNuloException Si el objeto de asistencia viene vacío (null).
     */
    public void registrarAsistencia(Asistencia asistencia) throws ParticipanteNuloException {
        if (asistencia == null) {
            throw new ParticipanteNuloException("No se puede registrar una asistencia nula.");
        }
        this.asistencias.add(asistencia);
    }

    /**
     * Suma un invitado a la lista de control de la reunión.
     *
     * @param invitacion Datos de la convocatoria enviada.
     * @throws ParticipanteNuloException Si se intenta cargar un objeto null.
     */
    public void agregarInvitacion(Invitacion invitacion) throws ParticipanteNuloException {
        if (invitacion == null) {
            throw new ParticipanteNuloException("No se puede agregar una invitación nula.");
        }
        this.invitaciones.add(invitacion);
    }

    /**
     * Devuelve la colección con todos los registros de los presentes en la llamada.
     *
     * @return Un List con las asistencias virtuales.
     */
    @Override
    public List<Asistencia> obtenerAsistencias() {
        return this.asistencias;
    }

    /**
     * Cruza los datos de los invitados contra los conectados para descubrir quiénes
     * no ingresaron al enlace de la sesión.
     *
     * @return Una lista con las invitaciones de las personas ausentes.
     */
    @Override
    public List<Invitacion> obtenerAusencias(){
        List<Invitacion> ausencias=new ArrayList<>();
        for (Invitacion inv : invitaciones){
            boolean asistio=false;
            for (Asistencia asis : asistencias){
                if (asis.getParticipante().equals(inv.getInvitado())){
                    asistio=true;
                    break;
                }
            }
            if (!asistio){
                ausencias.add(inv);
            }
        }
        return ausencias;
    }

    /**
     * Revisa mediante polimorfismo quiénes se unieron tarde comparando
     * si la asistencia guardada pertenece a la subclase Retraso.
     *
     * @return Lista con los participantes retrasados.
     */
    @Override
    public List<Asistencia> obtenerRetrasos(){
        List<Asistencia> retrasos = new ArrayList<>();
        for (Asistencia asis : asistencias){
            if (asis instanceof Retraso){
                retrasos.add(asis);
            }
        }
        return retrasos;
    }

    /**
     * Entrega de forma numérica el total de usuarios que entraron a la sala virtual.
     *
     * @return Cantidad de asistentes logueados.
     */
    @Override
    public int obtenerTotalAsistencia(){
        return this.asistencias.size();
    }

    /**
     * Calcula la tasa porcentual de asistencia real en base al quórum invitado.
     * Protege el programa de errores matemáticos si la lista de convocados está vacía.
     *
     * @return Porcentaje final de asistencia (float de 0.0 a 100.0).
     */
    @Override
    public float obtenerPorcentajeAsistencia(){
        if (invitaciones.isEmpty()){
            return 0.0f;
        }
        return ((float) asistencias.size()/invitaciones.size())*100.0f;
    }

    /**
     * Combina los datos temporales del evento base junto con el link de internet
     * para imprimir un resumen estructurado en la consola.
     *
     * @return Cadena de texto informativa del estado de la reunión virtual.
     */
    @Override
    public String toString(){
        return super.toString() + " -> ReunionVirtual{" +
                "enlace='" + enlace + '\'' +
                ", totalInvitados=" + invitaciones.size() +
                ", totalAsistentes=" + asistencias.size() +
                '}';
    }

    public String getEnlace(){
        return enlace;
    }
    public void setEnlace(String enlace){
        this.enlace=enlace;
    }

}