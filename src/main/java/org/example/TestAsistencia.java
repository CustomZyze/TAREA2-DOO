package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class TestAsistencia {

    @Test
    @DisplayName("Test: Crear asistencia con participante nulo y lanza excepción")
    void testAsistenciaConParticipanteNuloLanzaExcepcion() {
        assertThrows(ParticipanteNuloException.class, () -> {
            new Asistencia(null);
        });
    }
}