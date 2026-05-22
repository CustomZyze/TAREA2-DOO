package org.example;
import java.time.Instant;

public class Retraso extends Asistencia {
    private Instant hora;

    public Retraso(Empleado emp, Instant hora) {
        super(emp);
        this.hora = hora;
    }
}

