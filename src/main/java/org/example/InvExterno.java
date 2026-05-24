package org.example;

/**
 * Representa a un invitado externo a la empresa que asiste a la reunion
 * Hereda los atributos básicos de la clase Persona
 */
public class InvExterno extends Persona {
    /**
     * Crea un invitado externo con sus datos de contacto.
     *
     * @param nombre   El nombre del invitado
     * @param apellido El apellido del invitado
     * @param correo   El correo del invitado.
     */
    public InvExterno(String nombre, String apellido, String correo){
        super(nombre, apellido, correo);
    }

    /**
     * Devuelve en formato de texto los datos del invitado externo.
     *
     * @return Una cadena de texto con el formato "Invitado Externo: nombre apellido correo".
     */
    @Override
    public String toString() {
        return "Invitado Externo: " + getNombre() + " " + getApellido() + " " + getCorreo();
    }
    /**
     * Simula el enviar una invitacion a una reunion para el invitado externo,
     * imprimiendo los detalles en la consola.
     */
    @Override
    public void invitar() {
        System.out.println("Invitando a: " + getNombre() + " (" + getCorreo() + ")");
    }
}
