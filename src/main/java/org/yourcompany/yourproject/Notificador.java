package org.yourcompany.yourproject;

/**
 * Interfaz que define el comportamiento para enviar notificaciones
 */
public interface Notificador {
    
    /**
     * Envía un mensaje a un destino específico
     * 
     * @param destino El destino donde se envía el mensaje
     * @param mensaje El contenido del mensaje a enviar
     */
    void enviar(String destino, String mensaje);
}
