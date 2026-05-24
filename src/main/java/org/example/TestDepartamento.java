package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class TestDepartamento {
    private Departamento depto;
    private Empleado emp1;

    @BeforeEach
    void setup() {
        depto = new Departamento("Informática");
        emp1 = new Empleado("67", "Juan", "Pérez", "jperez@gmail.com");
    }

    @Test
    @DisplayName("Test: Añadir empleado y contar cantidad correcta")
    void testAnadirEmpleadoAumentaCantidad() throws ParticipanteNuloException {
        depto.añadirEmpleado(emp1);
        assertEquals(1, depto.obtenerCantidadEmpleados());
    }

    @Test
    @DisplayName("Test: Añadir empleado nulo lanza excepción")
    void testAnadirEmpleadoNuloLanzaExcepcion() {
        assertThrows(ParticipanteNuloException.class, () -> {
            depto.añadirEmpleado(null);
        });
    }
}
