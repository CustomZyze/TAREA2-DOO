package org.example;
import java.time.Instant;

public class Retraso extends Asistencia {
    private Instant hora;

    public Retraso(Persona participante, Instant hora) {
        super(participante);
        this.hora = hora;
    }

    public Instant getHora() {
        return hora;
    }

    public void setHora(Instant hora) {
        this.hora = hora;
    }

    @Override
    public String toString(){
        return "Retraso en hora [" + hora + "] de " + getParticipante().toString();
    }
}

