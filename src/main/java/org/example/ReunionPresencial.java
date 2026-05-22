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