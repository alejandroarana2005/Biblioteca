package org.yourcompany.yourproject;

/**
 * Clase que representa un préstamo de libros en la biblioteca
 */
public class Prestamo {
    
    // Atributos
    private Socio socio;
    private Ejemplar[] ejemplares;
    
    /**
     * Constructor de la clase Prestamo
     * 
     * @param socio El socio que realiza el préstamo
     * @param ejemplares Arreglo de ejemplares que se prestan
     */
    public Prestamo(Socio socio, Ejemplar[] ejemplares) {
        this.socio = socio;
        this.ejemplares = ejemplares;
    }
    
    // Getters
    public Socio getSocio() {
        return socio;
    }
    
    public Ejemplar[] getEjemplares() {
        return ejemplares;
    }
    
    // Setters
    public void setSocio(Socio socio) {
        this.socio = socio;
    }
    
    public void setEjemplares(Ejemplar[] ejemplares) {
        this.ejemplares = ejemplares;
    }
}
