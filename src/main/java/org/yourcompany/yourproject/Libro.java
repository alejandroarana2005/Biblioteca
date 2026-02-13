package org.yourcompany.yourproject;

import java.util.ArrayList;
import java.util.List;

public class Libro {
  
    private String isbn;
    private String titulo;
    private List<Ejemplar> ejemplares;

    public Libro(String isbn, String titulo) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.ejemplares = new ArrayList<>();
    }

    public Ejemplar crearEjemplar(String codigo) {
    Ejemplar nuevo = new Ejemplar(codigo, this);
    ejemplares.add(nuevo);
    return nuevo;
}

    
    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    
    public List<Ejemplar> getEjemplares() {
        return ejemplares;
    }
}



