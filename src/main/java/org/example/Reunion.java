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

    public void iniciar() {
        this.horaInicio = Instant.now();
    }

    public void finalizar() {
        this.horaFin = Instant.now();
    }

    public float calcularTiempoReal() {
        if (horaInicio == null){
            return 0.0f;
        }
        Instant fin=(horaFin != null) ? horaFin : Instant.now();
        Duration real=Duration.between(horaInicio, fin);
        return real.toMinutes()/60.0f;
    }

    public abstract List<Asistencia> obtenerAsistencias();

    public abstract List<Invitacion> obtenerAusencias();

    public abstract List<Asistencia> obtenerRetrasos();

    public abstract int obtenerTotalAsistencia();

    public abstract float obtenerPorcentajeAsistencia();

    @Override
    public String toString(){
        return "Reunion{" +
                "fecha=" + fecha +
                ", horaPrevista=" + horaPrevista +
                ", duracionPrevista=" + duracionPrevista +
                ", horaInicio=" + horaInicio +
                ", horaFin=" + horaFin +
                '}';
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Instant getHoraPrevista() {
        return horaPrevista;
    }

    public void setHoraPrevista(Instant horaPrevista) {
        this.horaPrevista=horaPrevista;
    }

    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }

    public void setDuracionPrevista(Duration duracionPrevista) {
        this.duracionPrevista=duracionPrevista;
    }

    public Instant getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Instant horaInicio) {
        this.horaInicio=horaInicio;
    }

    public Instant getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Instant horaFin) {
        this.horaFin = horaFin;
    }
}