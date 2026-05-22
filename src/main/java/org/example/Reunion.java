package org.example;

import java.util.Date;
import java.time.Instant;
import java.time.Duration;
import java.util.List;

public abstract class Reunion {

    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;

    public Reunion(Date fecha, Instant horaPrevista, Duration duracionPrevista) {
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
    }

    public void iniciar() { //
        this.horaInicio = Instant.now();
    }

    public void finalizar() { //
        this.horaFin = Instant.now();
    }

    public float calcularTiempoReal() { //
        if (horaInicio == null || horaFin == null) {
            return 0.0f;
        }
        Duration real = Duration.between(horaInicio, horaFin);
        return real.toMinutes() / 60.0f;
    }

    public abstract List<Asistencia> obtenerAsistencias();
    public abstract List<Invitacion> obtenerAusencias();
    public abstract List<Asistencia> obtenerRetrasos();
    public abstract int obtenerTotalAsistencia();
    public abstract float obtenerPorcentajeAsistencia();