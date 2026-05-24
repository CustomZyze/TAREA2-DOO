package org.example;

import java.util.Date;
import java.time.Instant;
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;

public class ReunionVirtual extends Reunion {
    private String enlace;

    private List<Asistencia> asistencias;
    private List<Invitacion> invitaciones;

    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista,TipoReunion tipoReunion, String enlace){
        super(fecha, horaPrevista, duracionPrevista, tipoReunion);
        this.enlace=enlace;
        this.asistencias=new ArrayList<>();
        this.invitaciones=new ArrayList<>();
    }

    public void registrarAsistencia(Asistencia asistencia) throws ParticipanteNuloException {
        if (asistencia == null) {
            throw new ParticipanteNuloException("No se puede registrar una asistencia nula.");
        }
        this.asistencias.add(asistencia);
    }

    public void agregarInvitacion(Invitacion invitacion) throws ParticipanteNuloException {
        if (invitacion == null) {
            throw new ParticipanteNuloException("No se puede agregar una invitación nula.");
        }
        this.invitaciones.add(invitacion);
    }

    @Override
    public List<Asistencia> obtenerAsistencias() {
        return this.asistencias;
    }

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

    @Override
    public int obtenerTotalAsistencia(){
        return this.asistencias.size();
    }

    @Override
    public float obtenerPorcentajeAsistencia(){
        if (invitaciones.isEmpty()){
            return 0.0f;
        }
        return ((float) asistencias.size()/invitaciones.size())*100.0f;
    }

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