package com.svalero.peliculas.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Pelicula implements Serializable {

    private String nombre;
    private String argumento;
    private String director;
    private LocalDate fechaRegistro;
    private LocalDate fechaEstreno;
    private String productora;
    private int duracion;
    private String genero;

    public Pelicula() {

    }

    public Pelicula(String nombre, String argumento, String director, LocalDate fechaEstreno, String productora,
                    int duracion, String genero) {
        this.nombre = nombre;
        this.argumento = argumento;
        this.director = director;
        this.fechaEstreno = fechaEstreno;
        this.productora = productora;
        this.duracion = duracion;
        this.genero = genero;
        fechaRegistro = LocalDate.now();
    }

    public Pelicula(String nombre, String genero) {
        this.nombre = nombre;
        this.genero = genero;
        fechaRegistro = LocalDate.now();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }
}
