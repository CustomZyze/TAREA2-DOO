package org.example;


/**
 * Clase abstracta que representa a una persona dentro del sistema.
 * Una persona tiene nombre, apellido y correo electrónico. Además,
 * implementa la interfaz Invitable, por lo que puede ser invitada
 * a una reunión.
 */
public abstract class Persona implements Invitable {

    /**
     * Apellido de la persona.
     */
    private String apellido;

    /**
     * Nombre de la persona.
     */
    private String nombre;

    /**
     * Correo electrónico de la persona.
     */
    private String correo;

    /**
     * Crea una nueva persona con nombre, apellido y correo electrónico.
     * @param nombre nombre de la persona.
     * @param apellido apellido de la persona.
     * @param correo correo electrónico de la persona.
     */
    public Persona(String nombre,String apellido, String correo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    /**
     * Obtiene el nombre de la persona.
     * @return nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }


    /**
     * Modifica el nombre de la persona.
     * @param nombre nuevo nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido de la persona.
     * @return apellido de la persona.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Modifica el apellido de la persona.
     * @param apellido nuevo apellido de la persona.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el correo electrónico de la persona.
     * @return correo electrónico de la persona.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Modifica el correo electrónico de la persona.
     * @param correo nuevo correo electrónico de la persona.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
