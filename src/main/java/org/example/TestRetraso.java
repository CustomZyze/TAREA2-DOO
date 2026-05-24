package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class TestRetraso {

    @Test
    @DisplayName("Test: Crear retraso con hora nula lanza excepción")
    void testRetrasoConHoraNulaLanzaExcepcion() {
        Empleado emp = new Empleado("123", "Juan", "Pérez", "jperez@gmail.com");

        assertThrows(HoraInvalidaException.class, () -> {
            new Retraso(emp, null);
        });
    }
}