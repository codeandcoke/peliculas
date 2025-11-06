package com.svalero.peliculas.ui;

import com.svalero.peliculas.model.Pelicula;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private List<Pelicula> listaPeliculas;
    private Scanner teclado;

    public App() {
        listaPeliculas = new ArrayList<>();
        teclado = new Scanner(System.in);
    }

    public void mostrarMenu() {
        while (true) {
            IO.println("1. Registrar pelicula");
            IO.println("2. Buscar pelicula");
            IO.println("3. Ver todas las peliculas");
            IO.println("x. Salir");
            IO.print("Opción: ");
            String opcion = teclado.nextLine();
            switch (opcion) {
                case "1":
                    registrarPelicula();
                    break;
                case "2":
                    buscarPelicula();
                    break;
                case "3":
                    verTodasPeliculas();
                    break;
                case "x":
                    IO.println("Saliendo de la aplicación");
                    System.exit(0);
            }
        }
    }

    private void registrarPelicula() {
        IO.print("Nombre: ");
        String nombre = teclado.nextLine();
        IO.print("Género: ");
        String genero = teclado.nextLine();
        Pelicula pelicula = new Pelicula(nombre, genero);
        listaPeliculas.add(pelicula);
        // TODO Guardar a disco
    }

    private void buscarPelicula() {

    }

    private void verTodasPeliculas() {
        for (Pelicula pelicula : listaPeliculas) {
            IO.println(pelicula.getNombre());
        }
    }
}
