package org.example;

/**
 * Clase de empleado dentro del sistema, el cual hereda los atributos base de la clase Persona.
 * Cada empleado cuenta con una id única.
 */

public class Empleado extends Persona{
    /** Id del empleado */
    private String id;
    /**
     * Crea un nuevo Empleado con sus datos básicos;
     *
     * @param id       La id (que lo identifica en la empresa)
     * @param nombre   El nombre del empleado
     * @param apellido El apellido del empleado
     * @param correo   El correo del empleado
     */
    public Empleado (String id,String nombre,String apellido,String correo){
        super(nombre,apellido,correo);
        this.id = id;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    /**
     * Devuelve una representación en formato de texto de los datos del empleado.
     *
     * @return Una cadena de texto con el formato "Empleado [id]: nombre apellido correo".
     */
    @Override
    public  String toString(){
        return "Empleado [" + id + "]: " + getNombre() + " " + getApellido() + " " + getCorreo();
    }

    /**
     * Simula el envío de una invitación a la reunión para el empleado
     * imprimiendo los detalles del envío en consola.
     */
    @Override
    public void invitar() {
        System.out.println("Invitando a empleado"+ "[" + getId() + "]: " + getNombre() + " (" + getCorreo() + ")");
    }
}

