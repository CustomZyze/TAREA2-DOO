package org.example;

import java.util.Date;
import java.time.Instant;
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;

public class ReunionPresencial extends Reunion {
    private String sala;
    private List<Asistencia> asistencias;
    private List<Invitacion> invitaciones;

    public ReunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista, String sala){
        super(fecha, horaPrevista, duracionPrevista);
        this.sala=sala;
        this.asistencias=new ArrayList<>();
        this.invitaciones=new ArrayList<>();
    }

    public void registrarAsistencia(Asistencia asistencia){
        this.asistencias.add(asistencia);
    }

    public void agregarInvitacion(Invitacion invitacion){
        this.invitaciones.add(invitacion);
    }

    @Override
    public List<Asistencia> obtenerAsistencias(){
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
        List<Asistencia> retrasos=new ArrayList<>();
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