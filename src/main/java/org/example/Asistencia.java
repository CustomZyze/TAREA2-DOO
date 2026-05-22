package org.example;

public class Asistencia {
    private Persona empleado;

    public Asistencia(Persona emp){
        this.empleado = emp;
    }

    public Persona getEmpleado(){
        return empleado;
    }
    public void setEmpleado(Empleado empleado){
        this.empleado = empleado;
    }

    @Override
    public String toString(){
        return "Asistencia: " + empleado.toString();
    }
}
