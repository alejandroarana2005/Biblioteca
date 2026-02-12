package org.yourcompany.yourproject;

public class Socio extends Usuario {
    private int limiteEjemplares;
    private int ejemplaresEnPrestamo;
    private double multasPendientes;

    public Socio(String id, String nombre, String email, int limiteEjemplares) {
        super(id, nombre, email);
        this.limiteEjemplares = limiteEjemplares;
        ejemplaresEnPrestamo = 0;
        multasPendientes = 0;
    }

    public void registrarPrestamo(int cantidad) {
        if(cantidad > (limiteEjemplares - ejemplaresEnPrestamo) ) {
            throw new IllegalArgumentException("Supera el limite del socio");
        }
        if(multasPendientes > 0) {
            throw new IllegalArgumentException("No puede pedir si tiene una multa");
        }
        System.out.println("Se prestaron " + cantidad + " libros");
    }
}