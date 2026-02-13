package org.yourcompany.yourproject;

/**
 * Clase que implementa el envío de notificaciones por SMS
 */
public class SmsNotificador implements Notificador {
    
    /**
     * Envía un mensaje por SMS
     * 
     * @param destino El número de teléfono de destino
     * @param mensaje El contenido del mensaje a enviar
     */
    @Override
    public void enviar(String destino, String mensaje) {
        System.out.println("Enviando SMS a: " + destino);
        System.out.println("Contenido: " + mensaje);
        System.out.println("SMS enviado exitosamente");
    }
}
