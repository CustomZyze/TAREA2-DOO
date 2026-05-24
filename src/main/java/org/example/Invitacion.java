package org.example;

import java.time.Instant;

/**
 * Representa una invitación realizada a una persona o grupo que puede ser invitado
 * a una reunión. La invitación guarda la hora en que fue realizada y el invitado asociado,
 * el cual debe implementar la interfaz Invitable.
 */
public class Invitacion {

    /**
     * Hora en que se realiza la invitación.
     */
    private Instant hora;

    /**
     * Persona o grupo invitado a la reunión.
     */
    private Invitable invitado;


    /**
     * Crea una nueva invitación con una hora y un invitado determinado.
     * @param hora hora en que se realiza la invitación.
     * @param invitado persona o grupo que será invitado.
     */
    public Invitacion(Instant hora, Invitable invitado){
        this.hora = hora;
        this.invitado = invitado;
    }

    /**
     * Obtiene la hora en que se realizó la invitación.
     * @return hora de la invitación.
     */
    public Instant getHora(){
        return hora;
    }

    /**
     * Modifica la hora de la invitación.
     * @param hora nueva hora de la invitación.
     */
    public void setHora(Instant hora){
        this.hora = hora;
    }


    /**
     * Obtiene el invitado asociado a la invitación.
     * @return invitado de la reunión.
     */
    public Invitable getInvitado(){
        return invitado;
    }

    /**
     * Modifica el invitado asociado a la invitación.
     * @param invitado nuevo invitado de la reunión.
     */
    public void setInvitado(Invitable invitado) {
        this.invitado = invitado;
    }

    /**
     * Entrega una representación en texto de la invitación.
     * @return descripción de la invitación, incluyendo hora e invitado.
     */
    @Override
    public String toString(){
        return  "Invitacion hecha a las " + hora + " para: \n" + invitado.toString();
    }
}
