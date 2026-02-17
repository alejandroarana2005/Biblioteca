/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

/**
 *
 * @author Unibague
 * 
 * Alejandro Arana Fernandez - 2220232039
 * Jhoan Ortiz Parra - 2220231054
 * Sergio Andres Martinez Aroca - 2220231060
 * Juan Miguel Robayo Diaz - 2220232004
 * 
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========== SISTEMA DE GESTIÓN DE BIBLIOTECA ==========\n");
        
        // Crear biblioteca
        Biblioteca biblioteca = new Biblioteca();
        
        // Pruebas de usuarios
        pruebaUsuarios(biblioteca);
        
        // Pruebas de libros y ejemplares
        Libro libro = pruebaLibrosEjemplares();
        
        // Pruebas de préstamos y notificadores
        pruebaPrestamosYNotificadores(biblioteca, libro);
        
        System.out.println("\n========== FIN DE LAS PRUEBAS ==========");
    }
    
    /**
     * Prueba la creación de bibliotecarios y socios
     */
    public static void pruebaUsuarios(Biblioteca biblioteca) {
        System.out.println("--- PRUEBA: Creación de Usuarios ---");
        
        // Crear bibliotecarios
        Bibliotecario bibliotecario1 = new Bibliotecario("1", "Pepe", "pepe@gmail.com", "Mañana");
        Bibliotecario bibliotecario2 = new Bibliotecario("2", "María", "maria@gmail.com", "Tarde");
        
        biblioteca.agregarBibliotecario(bibliotecario1);
        biblioteca.agregarBibliotecario(bibliotecario2);
        
        System.out.println("Bibliotecarios agregados:");
        for (Bibliotecario b : biblioteca.darBibliotecarios()) {
            System.out.println("  - " + b.darNombre() + " (Turno: " + b.darTurno() + ")");
        }
        
        // Crear socios
        Socio socio1 = new Socio("1", "Juan", "juan@gmail.com", 5);
        Socio socio2 = new Socio("2", "Carlos", "carlos@gmail.com", 3);
        
        biblioteca.agregarSocio(socio1);
        biblioteca.agregarSocio(socio2);
        
        System.out.println("\nSocios agregados:");
        for (Socio s : biblioteca.darSocios()) {
            System.out.println("  - " + s.darNombre() + " (Email: " + s.darEmail() + ")");
            System.out.println("    Límite de ejemplares: " + s.getLimiteEjemplares());
            System.out.println("    ¿Puede pedir prestamo? " + s.puedePedirPrestamo());
        }
        System.out.println();
    }
    
    /**
     * Prueba la creación de libros y ejemplares
     */
    public static Libro pruebaLibrosEjemplares() {
        System.out.println("--- PRUEBA: Creación de Libros y Ejemplares ---");
        
        // Crear libro
        Libro libro1 = new Libro("ISBN-001", "Cien años de soledad");
        Ejemplar ej1 = libro1.crearEjemplar("EJ-001");
        Ejemplar ej2 = libro1.crearEjemplar("EJ-002");
        Ejemplar ej3 = libro1.crearEjemplar("EJ-003");
        
        System.out.println("Libro creado: " + libro1.getTitulo());
        System.out.println("  ISBN: " + libro1.getIsbn());
        System.out.println("  Ejemplares creados:");
        for (Ejemplar e : libro1.getEjemplares()) {
            System.out.println("    - Código: " + e.getCodigo() + " (Libro: " + e.getLibro().getTitulo() + ")");
        }
        
        System.out.println();
        return libro1;
    }
    
    /**
     * Prueba préstamos y notificadores
     */
    public static void pruebaPrestamosYNotificadores(Biblioteca biblioteca, Libro libro) {
        System.out.println("--- PRUEBA: Préstamos y Notificadores ---");
        
        Socio socio = biblioteca.darSocios().get(0);
        Ejemplar[] ejemplaresAPrestados = {
            libro.getEjemplares().get(0),
            libro.getEjemplares().get(1)
        };
        
        // Crear préstamo
        Prestamo prestamo = new Prestamo(socio, ejemplaresAPrestados);
        
        System.out.println("Préstamo creado para: " + prestamo.getSocio().darNombre());
        System.out.println("Cantidad de ejemplares: " + prestamo.getEjemplares().length);
        
        // Registrar préstamo en el socio
        try {
            socio.registrarPrestamo(prestamo.getEjemplares().length);
            System.out.println("Préstamo registrado exitosamente");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al registrar préstamo: " + e.getMessage());
        }
        
        System.out.println("Ejemplares en préstamo: " + socio.getEjemplaresEnPrestamo());
        
        // Prueba de notificadores
        System.out.println("\n--- NOTIFICADORES ---");
        
        Notificador emailNotificador = new EmailNotificador();
        Notificador smsNotificador = new SmsNotificador();
        
        System.out.println("\nNotificación por Email:");
        prestamo.NotificarCreación(emailNotificador);
        
        System.out.println("\nNotificación por SMS:");
        prestamo.NotificarCreación(smsNotificador);
        
        // Prueba de multas
        System.out.println("\n--- PRUEBA: Sistema de Multas ---");
        socio.agregarMulta(15.50);
        System.out.println("Multa agregada al socio: $" + socio.getMultasPendientes());
        System.out.println("¿Puede pedir prestamo? " + socio.puedePedirPrestamo());
        
        System.out.println();
    }
}
