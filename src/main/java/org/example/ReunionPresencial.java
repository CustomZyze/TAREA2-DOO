package org.example;

import java.util.Date;
import java.time.Instant;
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;

/**
 * Modela una reunión que se hace de forma física en una sala específica.
 * Hereda la lógica de tiempo de la clase Reunion y maneja sus propias
 * listas de asistencia e invitaciones de manera independiente.
 */
public class ReunionPresencial extends Reunion {
    /** Nombre o número de la sala física donde se junta la gente. */
    private String sala;
    /** Lista de las personas que sí llegaron a la reunión. */
    private List<Asistencia> asistencias;
    /** Lista de todas las personas que fueron convocadas legalmente. */
    private List<Invitacion> invitaciones;

    /**
     * Constructor para armar una reunión presencial.
     * Pasa los datos compartidos a la clase madre e inicializa las listas vacías.
     *
     * @param fecha            Día en que se hace la reunión.
     * @param horaPrevista     Hora a la que se supone que debería empezar.
     * @param duracionPrevista Cuánto tiempo se estima que va a durar.
     * @param tipoReunion      Categoría temática de la sesión.
     * @param sala             El lugar físico asignado.
     */
    public ReunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista,TipoReunion tipoReunion, String sala){
        super(fecha, horaPrevista, duracionPrevista, tipoReunion);
        this.sala=sala;
        this.asistencias=new ArrayList<>();
        this.invitaciones=new ArrayList<>();
    }

    /**
     * Registra a alguien que llegó a la reunión.
     *
     * @param asistencia El objeto con los datos del participante.
     * @throws ParticipanteNuloException Si intentas pasar un objeto null por error.
     */
    public void registrarAsistencia(Asistencia asistencia) throws ParticipanteNuloException {
        if (asistencia == null) {
            throw new ParticipanteNuloException("No se puede registrar una asistencia nula.");
        }
        this.asistencias.add(asistencia);
    }

    /**
     * Agrega una nueva invitación a la lista de convocados.
     *
     * @param invitacion La invitación creada para una persona o departamento.
     * @throws ParticipanteNuloException Si la invitación que pasas viene vacía (null).
     */
    public void agregarInvitacion(Invitacion invitacion) throws ParticipanteNuloException {
        if (invitacion == null) {
            throw new ParticipanteNuloException("No se puede agregar una invitación nula.");
        }
        this.invitaciones.add(invitacion);
    }

    /**
     * Devuelve la lista completa de personas que marcaron presencia.
     *
     * @return Un List con todas las asistencias registradas.
     */
    @Override
    public List<Asistencia> obtenerAsistencias(){
        return this.asistencias;
    }

    /**
     * Revisa la lista de invitados y filtra a los que dejaron el "visto",
     * es decir, aquellos que tenían invitación pero no registran asistencia.
     *
     * @return Una lista con las invitaciones de la gente que faltó.
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
     * Filtra la lista de asistencia usando polimorfismo para pillar
     * únicamente a los que llegaron después de la hora y son del tipo Retraso.
     *
     * @return Lista exclusiva con los registros de los atrasados.
     */
    @Override
    public List<Asistencia> obtenerRetrasos(){
        List<Asistencia> retrasos=new ArrayList<>();
        for (Asistencia asis : asistencias){
            if (asis instanceof Retraso){
                retrasos.add(asis);
            }
        }
        return retrasos;
    }

    /**
     * Cuenta rápido cuántas personas sí se presentaron a la sala.
     *
     * @return La cantidad total de asistentes en número entero.
     */
    @Override
    public int obtenerTotalAsistencia(){
        return this.asistencias.size();
    }

    /**
     * Saca el cálculo matemático del porcentaje de asistencia dividiendo los
     * presentes por los invitados. Evita caer en divisiones por cero si no hay nadie invitado.
     *
     * @return Un número float entre 0.0 y 100.0 con la tasa de asistencia.
     */
    @Override
    public float obtenerPorcentajeAsistencia(){
        if (invitaciones.isEmpty()){
            return 0.0f;
        }
        return ((float) asistencias.size()/invitaciones.size())*100.0f;
    }

    /**
     * Junta los datos de la clase base con los de esta sala física para
     * mostrar un resumen limpio en la consola sin romper la memoria.
     *
     * @return Cadena de texto descriptiva de la reunión en ese instante.
     */
    @Override
    public String toString(){
        return super.toString() + " -> ReunionPresencial{" +
                "sala='" + sala + '\'' +
                ", totalInvitados=" + invitaciones.size() +
                ", totalAsistentes=" + asistencias.size() +
                '}';
    }

    public String getSala(){
        return sala;
    }
    public void setSala(String sala){
        this.sala=sala;
    }
}