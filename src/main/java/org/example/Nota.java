package org.example;

public class Nota {
    private String contenido;

    public Nota(String contenido){
        this.contenido = contenido;
    }
    public String getContenido(){
        return contenido;
    }

    public void setContenido(){
        this.contenido = contenido;
    }

    @Override
    public String toString(){
        return contenido;
    }
}
