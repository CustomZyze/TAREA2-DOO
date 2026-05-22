package org.example;

public class Empleado extends Persona{
    private String id;
    private String apellido;
    private String nombre;
    private String correo;

    public Empleado (String a,String b,String c,String d){
        super(b,c,d);
        id = a;
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

