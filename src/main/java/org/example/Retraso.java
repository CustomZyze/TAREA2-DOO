package org.example;
import java.time.Instant;


/**
 * Representa una asistencia con retraso a una reunión la cual
 *extiende Asistencia, por lo que mantiene la información
 del participante, pero además guarda la hora en que llegó tarde.
 */
public class Retraso extends Asistencia {

    /**
     * Hora en que llegó el participante atrasado.
     */
    private Instant hora;

    /**
     * Crea un registro de retraso para un participante.
     * @param participante persona que asistió con retraso.
     * @param hora hora en que llegó el participante.
     * @throws ParticipanteNuloException si el participante es null.
     * @throws HoraInvalidaException si la hora del retraso es null.
     */
    public Retraso(Persona participante, Instant hora) throws ParticipanteNuloException, HoraInvalidaException {
        super(participante);
        if (hora == null) {
            throw new HoraInvalidaException("La hora del retraso no puede ser nula.");
        }
        this.hora = hora;
    }

    /**
     * Obtiene la hora de llegada del participante atrasado.
     * @return hora del retraso.
     */
    public Instant getHora() {
        return hora;
    }

    /**
     * Modifica la hora de llegada del participante atrasado.
     * @param hora nueva hora del retraso.
     */
    public void setHora(Instant hora) {
        this.hora = hora;
    }

    /**
     * Entrega una representación en texto del retraso.
     * @return descripción del retraso, incluyendo hora y participante.
     */
    @Override
    public String toString(){
        return "Retraso en hora [" + hora + "] de " + getParticipante().toString();
    }
}

