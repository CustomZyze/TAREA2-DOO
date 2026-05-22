package org.example;

public class Empleado implements Invitable{
    private String id;
    private String apellido;
    private String nombre;
    private String correo;

    public Empleado (String a,String b,String c,String d){
        id = a;
        apellido = b;
        nombre = c;
        correo = d;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getApellidos() { return apellido; }
    public void setApellidos(String apellidos) { this.apellido = apellidos; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    @Override
    public  String toString(){
        return "Empleado [" + id + "]: " + nombre + " " + apellido + " " + correo;
    }

    @Override
    public void invitar() {
    }
}

