package org.yourcompany.yourproject;

/**
 * Clase que implementa el envío de notificaciones por correo electrónico
 */
public class EmailNotificador implements Notificador {
    
    /**
     * Envía un mensaje por correo electrónico
     * 
     * @param destino El correo electrónico de destino
     * @param mensaje El contenido del mensaje a enviar
     */
    @Override
    public void enviar(String destino, String mensaje) {
        System.out.println("Enviando EMAIL a: " + destino);
        System.out.println("Contenido: " + mensaje);
        System.out.println("Email enviado exitosamente");
    }
}
