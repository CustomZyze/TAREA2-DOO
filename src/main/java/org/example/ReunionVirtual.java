package org.example;

import java.util.Date;
import java.time.Instant;
import java.time.Duration;
import java.util.List;

public class ReunionVirtual extends Reunion{
    private String enlace;

    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista, String enlace){
        super(fecha, horaPrevista, duracionPrevista);
        this.enlace = enlace;
    }

    @Override
    public List<Asistencia> obtenerAsistencias() {
        return new ArrayList<>();
    }

    @Override
    public List<Invitacion> obtenerAusencias() {
        return new ArrayList<>();
    }

    @Override
    public List<Asistencia> obtenerRetrasos(){
        return new ArrayList<>();
    }

    @Override
    public int obtenerTotalAsistencia(){
        return 0;
    }

    @Override
    public float obtenerPorcentajeAsistencia(){
        return 0.0f;
    }

    public String getEnlace(){
        return enlace;
    }

    public void setEnlace(String enlace){
        this.enlace=enlace;
    }