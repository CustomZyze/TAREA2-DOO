package org.example;

public class Empleado extends Persona{
    private String id;

    public Empleado (String id,String nombre,String apellido,String correo){
        super(nombre,apellido,correo);
        this.id = id;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    @Override
    public  String toString(){
        return "Empleado [" + id + "]: " + getNombre() + " " + getApellido() + " " + getCorreo();
    }

    @Override
    public void invitar() {
        System.out.println("Invitando a empleado"+ "[" + getId() + "]: " + getNombre() + " (" + getCorreo() + ")");
    }
}

