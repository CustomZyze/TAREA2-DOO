package org.example;

/**
 * Representa una nota asociada a una reunión la cual
 * permite guardar información, comentarios o
 * acuerdos importantes relacionados con una reunión.
 */
public class Nota {

    /**
     * Contenido o texto de la nota.
     */
    private String contenido;


    /**
     * Crea una nueva nota con el contenido indicado.
     * @param contenido texto o información que tendrá la nota.
     */
    public Nota(String contenido){
        this.contenido = contenido;
    }

    /**
     * Obtiene el contenido de la nota.
     * @return contenido de la nota.
     */
    public String getContenido(){
        return contenido;
    }

    /**
     * Modifica el contenido de la nota.
     * @param contenido nuevo contenido de la nota.
     */
    public void setContenido(String contenido){
        this.contenido = contenido;
    }

    /**
     * Entrega una representación en texto de la nota.
     * @return contenido de la nota.
     */
    @Override
    public String toString(){
        return contenido;
    }
}
