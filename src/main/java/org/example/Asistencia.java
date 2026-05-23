package org.example;

public class Asistencia {
    private Persona participante;

    public Asistencia(Persona par){
        this.participante = par;
    }

    public Persona getParticipante(){
        return participante;
    }
    public void setParticipante(Persona par){
        this.participante = par;
    }

    @Override
    public String toString(){
        return "Asistencia: " + participante.toString();
    }
}
