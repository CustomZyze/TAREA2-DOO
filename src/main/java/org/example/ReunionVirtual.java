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
    public List<Invitacion> obtenerAusencias(){
        return new ArrayList<>();