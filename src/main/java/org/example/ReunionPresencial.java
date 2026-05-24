package org.example;

import java.util.Date;
import java.time.Instant;
import java.time.Duration;
import java.util.List;

public class ReunionPresencial extends Reunion{
    private String sala;

    public ReunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista, String sala){
        super(fecha, horaPrevista, duracionPrevista);
        this.sala=sala;
    }

    @Override
    public List<Asistencia> obtenerAsistencias(){
        return new ArrayList<>();
    }

    @Override
    public List<Invitacion> obtenerAusencias(){
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

    public String getSala(){
        return sala;
    }

    public void setSala(String sala){
        this.sala = sala;
    }