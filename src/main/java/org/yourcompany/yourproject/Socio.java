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

    public String getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getEmail() {
        return this.email;
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



    public void registrarPrestamo(Prestamo prestamo) {
        int cantidadEjemplares = prestamo.getEjemplares().length;
        
        if(cantidadEjemplares > (limiteEjemplares - ejemplaresEnPrestamo)) {
            throw new IllegalArgumentException("Supera el limite del socio");
        }
        if(multasPendientes > 0) {
            throw new IllegalArgumentException("No puede pedir si tiene una multa");
        }
        
        ejemplaresEnPrestamo += cantidadEjemplares;
        System.out.println("Se prestaron " + cantidadEjemplares + " libros al socio: " + this.getNombre());
    }
}