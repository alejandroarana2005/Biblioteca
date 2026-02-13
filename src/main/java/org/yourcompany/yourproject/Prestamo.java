package org.yourcompany.yourproject;


public class Prestamo {
    
    // Atributos
    private Socio socio;
    private Ejemplar[] ejemplares;
    
    // Cosntructor

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
    
   
    public void NotificarCreación(Notificador notificador) {
        String destino = socio.getEmail();
        String mensaje = "Se ha registrado un préstamo a nombre de: " + socio.getNombre() + 
                         " con " + ejemplares.length + " ejemplares";
        notificador.enviar(destino, mensaje);
    }

}
