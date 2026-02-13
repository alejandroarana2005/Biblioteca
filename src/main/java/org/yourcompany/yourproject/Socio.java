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

    public int getLimiteEjemplares() {
        return limiteEjemplares;
    }

    public int getEjemplaresEnPrestamo() {
        return ejemplaresEnPrestamo;
    }

    public double getMultasPendientes() {
        return multasPendientes;
    }

    public void agregarMulta(double monto) {
        multasPendientes += monto;
    }

    public boolean puedePedirPrestamo() {
        return (ejemplaresEnPrestamo < limiteEjemplares) && (multasPendientes == 0);
    }



    public void registrarPrestamo(int cantidad) {
        
        
        if(cantidad > (limiteEjemplares - ejemplaresEnPrestamo)) {
            throw new IllegalArgumentException("Supera el limite del socio");
        }
        if(multasPendientes > 0) {
            throw new IllegalArgumentException("No puede pedir si tiene una multa");
        }
        
        ejemplaresEnPrestamo += cantidad;
        System.out.println("Se prestaron " + cantidad + " libros al socio: " + this.darNombre());
    }
}