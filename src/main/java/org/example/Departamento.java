package org.example;
import java.util.ArrayList;
import java.util.List;

public class Departamento{
    private String nombre;
    private List<Empleado> empleados;
    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }
}
