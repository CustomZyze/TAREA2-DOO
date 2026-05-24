package org.example;
import java.util.ArrayList;
import java.util.List;

public class Departamento implements Invitable{
    private String nombre;
    private List<Empleado> empleados;
    public Departamento(String nombre){
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public void añadirEmpleado(Empleado emp) throws ParticipanteNuloException{
        if (emp == null) {
            throw new ParticipanteNuloException("No se puede añadir un Empleado null al depto.");
        }
        this.empleados.add(emp);
    }

    public int obtenerCantidadEmpleados(){
        return this.empleados.size();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString(){
        String info = "Depto: " + nombre + "(Cant. Empleados: " + obtenerCantidadEmpleados() + ")\n";
        for (Empleado emp : empleados){
            info = info + " -" + emp.toString() + "\n";
        }
        return info;
    }

    @Override
    public void invitar() {
        System.out.println("Invitando a depto: " + getNombre());
        for (Empleado emp: empleados){
            emp.invitar();
        }
    }
}
