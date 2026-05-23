package org.example;

public class InvExterno extends Persona {
    public InvExterno(String nombre, String apellido, String correo){
        super(nombre, apellido, correo);
    }

    @Override
    public String toString() {
        return "Invitado Externo: " + getNombre() + " " + getApellido() + " " + getCorreo();
    }

    @Override
    public void invitar() {
        System.out.println("Invitando a: " + getNombre() + " (" + getCorreo() + ")");
    }
}
