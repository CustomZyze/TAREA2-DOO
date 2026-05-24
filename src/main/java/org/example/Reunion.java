package org.example;

import java.util.Date;
import java.time.Instant;
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;

public abstract class Reunion {

    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    private TipoReunion tipoReunion;
    private List<Nota> notas;

    public Reunion(Date fecha, Instant horaPrevista, Duration duracionPrevista, TipoReunion tipoReunion) {
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.tipoReunion = tipoReunion;
        this.notas = new ArrayList<>();
    }

    public void iniciar() {
        this.horaInicio = Instant.now();
    }

    public void finalizar() {
        this.horaFin = Instant.now();
    }

    public float calcularTiempoReal() {
        if (horaInicio == null) {
            return 0.0f;
        }

        Instant fin = (horaFin != null) ? horaFin : Instant.now();
        Duration real = Duration.between(horaInicio, fin);

        return real.toMinutes() / 60.0f;
    }

    public void agregarNota(Nota nota) {
        this.notas.add(nota);
    }

    public List<Nota> obtenerNotas() {
        return this.notas;
    }

    public abstract List<Asistencia> obtenerAsistencias();

    public abstract List<Invitacion> obtenerAusencias();

    public abstract List<Asistencia> obtenerRetrasos();

    public abstract int obtenerTotalAsistencia();

    public abstract float obtenerPorcentajeAsistencia();

    @Override
    public String toString() {
        return "Reunion{" +
                "fecha=" + fecha +
                ", horaPrevista=" + horaPrevista +
                ", duracionPrevista=" + duracionPrevista +
                ", horaInicio=" + horaInicio +
                ", horaFin=" + horaFin +
                ", tipoReunion=" + tipoReunion +
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
        this.horaPrevista = horaPrevista;
    }

    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }

    public void setDuracionPrevista(Duration duracionPrevista) {
        this.duracionPrevista = duracionPrevista;
    }

    public Instant getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Instant horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Instant getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Instant horaFin) {
        this.horaFin = horaFin;
    }

    public TipoReunion getTipoReunion() {
        return tipoReunion;
    }

    public void setTipoReunion(TipoReunion tipoReunion) {
        this.tipoReunion = tipoReunion;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }
}