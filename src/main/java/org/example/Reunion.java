package org.example;

import java.util.Date;
import java.time.Instant;
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;
/**
 * Clase abstracta que define la estructura y el comportamiento base de una reunión.
 * Proporciona el control del ciclo de vida temporal de la sesión, la gestión de notas
 * y las firmas obligatorias para el cálculo de estadísticas de asistencia.
 */
public abstract class Reunion {

    /** Fecha calendarizada en la que se efectúa la reunión. */
    private Date fecha;
    /** Instante exacto programado para dar inicio a la sesión. */
    private Instant horaPrevista;
    /** Bloque de tiempo estimado o planificado para el desarrollo de la reunión. */
    private Duration duracionPrevista;
    /** Registro del instante real en el que el moderador dio inicio a la reunión. */
    private Instant horaInicio;
    /** Registro del instante real en el que se dio por finalizada la sesión. */
    private Instant horaFin;
    /** Clasificación temática o de área de la reunión (técnica, marketing, etc.). */
    private TipoReunion tipoReunion;
    /** Colección de apuntes o minutas tomadas de forma dinámica durante la sesión. */
    private List<Nota> notas;

    /**
     * Constructor principal de la clase abstracta Reunion.
     * Inicializa los metadatos de planificación del evento y prepara la lista de notas.
     *
     * @param fecha            Fecha calendarizada de la reunión.
     * @param horaPrevista     Instante de tiempo fijado para el inicio.
     * @param duracionPrevista Duración estimada de la sesión.
     * @param tipoReunion      Categoría o clasificación de la reunión.
     */
    public Reunion(Date fecha, Instant horaPrevista, Duration duracionPrevista, TipoReunion tipoReunion) {
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.tipoReunion = tipoReunion;
        this.notas = new ArrayList<>();
    }

    /**
     * Registra el inicio oficial de la reunión capturando el instante de tiempo actual.
     */
    public void iniciar() {
        this.horaInicio = Instant.now();
    }

    /**
     * Registra el término oficial de la reunión capturando el instante de tiempo actual.
     */
    public void finalizar() {
        this.horaFin = Instant.now();
    }

    /**
     * Calcula la duración real total de la reunión expresada en formato de horas decimales.
     * Si la reunión se encuentra en curso (no se ha cerrado), calcula el tiempo transcurrido
     * desde el inicio hasta el momento actual del sistema.
     *
     * @return El tiempo consumido en horas (float).
     * @throws ReunionException Si se invoca el método y la reunión aún no ha sido iniciada.
     */
    public float calcularTiempoReal() throws ReunionException {
        if (horaInicio == null) {
            throw new ReunionException("No se puede calcular el tiempo: la reunión aún no ha iniciado.");
        }

        Instant fin = (horaFin != null) ? horaFin : Instant.now();
        Duration real = Duration.between(horaInicio, fin);

        return real.toMinutes() / 60.0f;
    }

    /**
     * Añade un nuevo apunte o anotación al registro global de minutas de la reunión.
     *
     * @param nota Objeto de tipo Nota que contiene el contenido textual descriptivo.
     */
    public void agregarNota(Nota nota) {
        this.notas.add(nota);
    }

    /**
     * Recupera el listado con todas las notas registradas durante el transcurso de la sesión.
     *
     * @return Una lista (List) conteniendo las notas de la reunión.
     */
    public List<Nota> obtenerNotas() {
        return this.notas;
    }

    /**
     * Método abstracto para obtener el registro detallado de los participantes que asistieron.
     * Su implementación concreta dependerá del entorno (Virtual o Presencial).
     *
     * @return Lista con los registros de asistencia efectivos.
     */
    public abstract List<Asistencia> obtenerAsistencias();

    /**
     * Método abstracto para identificar y listar a aquellos convocados que no se presentaron.
     *
     * @return Lista de invitaciones cuyo destino no cuenta con un registro de asistencia.
     */
    public abstract List<Invitacion> obtenerAusencias();

    /**
     * Método abstracto para filtrar y consolidar a los participantes que se incorporaron
     * tarde respecto a la hora prevista de la sesión.
     *
     * @return Lista de objetos de asistencia clasificados como retrasos.
     */
    public abstract List<Asistencia> obtenerRetrasos();

    /**
     * Método abstracto que contabiliza la cantidad total neta de personas presentes en la sesión.
     *
     * @return Número entero con la sumatoria de asistentes.
     */
    public abstract int obtenerTotalAsistencia();

    /**
     * Método abstracto encargado de calcular la tasa porcentual de asistencia real
     * respecto a la cantidad totalizada de invitaciones cursadas.
     *
     * @return Valor flotante entre 0.0 y 100.0 que representa la efectividad de asistencia.
     */
    public abstract float obtenerPorcentajeAsistencia();

    /**
     * Retorna una representación textual simplificada de los metadatos de la reunión.
     * Evita la inclusión de colecciones directas para mitigar riesgos de recursión infinita.
     *
     * @return Cadena de texto formateada con los atributos primitivos de la sesión.
     */
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