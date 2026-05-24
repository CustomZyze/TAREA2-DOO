package org.example;
import java.util.ArrayList;
import java.util.List;

/**
 * Departamento dentro de la empresa, el cual agrupa a los empleados
 * Implementa la interfaz Invitable para permitir que se invite a todo el departamento de una.
 */
public class Departamento implements Invitable{
    /** El nombre del departamento */
    private String nombre;
    /** Lista de empleados que son parte del departamento */
    private List<Empleado> empleados;
    /**
     * Crea un nuevo Departamento y establece una lista vacía de empleados
     *
     * @param nombre El nombre del departamento.
     */
    public Departamento(String nombre){
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }
    /**
     * Añade un nuevo empleado a la lista del departamento
     *
     * @param emp El objeto Empleado que se desea añadir
     * @throws ParticipanteNuloException Si se intenta añadir un empleado con valor nulo.
     */
    public void añadirEmpleado(Empleado emp) throws ParticipanteNuloException{
        if (emp == null) {
            throw new ParticipanteNuloException("No se puede añadir un Empleado null al depto.");
        }
        this.empleados.add(emp);
    }

    /**
     * Obtiene el total de empleados que pertenecen al departamento
     *
     * @return La cantidad de empleados en la lista.
     */
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

    /**
     * Devuelve en texto del departamento, incluyendo su nombre,
     * la cantidad de empleados y los datos de cada uno de ellos mediante un ciclo for.
     *
     * @return Una cadena de texto con la información detallada del departamento.
     */
    @Override
    public String toString(){
        String info = "Depto: " + nombre + "(Cant. Empleados: " + obtenerCantidadEmpleados() + ")\n";
        for (Empleado emp : empleados){
            info = info + " -" + emp.toString() + "\n";
        }
        return info;
    }

    /**
     * Simula la invitación del departamento completo a una reunión cualquiera
     * Imprime un mensaje en consola para el departamento y usa el metodo invitar
     * de cada uno de los empleados que lo componen.
     */
    @Override
    public void invitar() {
        System.out.println("Invitando a depto: " + getNombre());
        for (Empleado emp: empleados){
            emp.invitar();
        }
    }
}
