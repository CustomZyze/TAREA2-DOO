package org.example;

public class Persona implements Invitable {
    private String apellido;
    private String nombre;
    private String correo;

    public Persona(String nombre,String apellido, String correo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    @Override
    public void invitar() {
    }
}
