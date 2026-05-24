package org.example;

/**
 * Representa el registro de asistencia de un participante a una reunión.
 */
public class Asistencia {
    /** La persona que asiste a la reunión */
    private Persona participante;

    /**
     * Crea un registro de asistencia.
     *
     * @param par El participante que va asistir
     * @throws ParticipanteNuloException Si el participante proporcionado es nulo.
     */
    public Asistencia(Persona par) throws ParticipanteNuloException{
        if (par == null) {
            throw new ParticipanteNuloException("El participante de la asistencia no puede ser null");
        }
        this.participante = par;
    }

    public Persona getParticipante(){
        return participante;
    }
    public void setParticipante(Persona par){
        this.participante = par;
    }

    /**
     * Devuelve en texto la asistencia,
     * usando la información del participante que asiste.
     *
     * @return Una cadena indicando la asistencia y los datos del participante.
     */
    @Override
    public String toString(){
        return "Asistencia: " + participante.toString();
    }
}
