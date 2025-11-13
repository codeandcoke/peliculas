package com.svalero.peliculas.ui;

import com.svalero.peliculas.model.Pelicula;
import com.svalero.peliculas.util.FicheroUtil;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private List<Pelicula> listaPeliculas;
    private Scanner teclado;

    public App() {
        teclado = new Scanner(System.in);

        // Cargar los datos que haya en disco, si los hay
        if (Files.exists(Path.of("peliculas.dat"))) {
            listaPeliculas = FicheroUtil.cargarFichero("peliculas.dat");
        } else {
            listaPeliculas = new ArrayList<>();
        }
    }

    public void mostrarMenu() {
        while (true) {
            IO.println("1. Registrar pelicula");
            IO.println("2. Buscar pelicula");
            IO.println("3. Ver todas las peliculas");
            IO.println("4. Eliminar pelicula");
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
                case "4":
                    eliminarPelicula();
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
        FicheroUtil.guardarFichero(listaPeliculas, "peliculas.dat");
    }

    private void buscarPelicula() {
        IO.print("Nombre: ");
        String nombre = teclado.nextLine();
        boolean encontrada = false;
        for (Pelicula pelicula : listaPeliculas) {
            if (pelicula.getNombre().equals(nombre)) {
                encontrada = true;
                IO.println("Pelicula encontrada");
                IO.println(pelicula.getNombre());
                IO.println(pelicula.getGenero());
                IO.println(pelicula.getFechaRegistro());
                break;
            }
        }

        if (!encontrada) {
            IO.println("No existe ninguna pelicula con ese nombre");
        }
    }

    private void verTodasPeliculas() {
        for (Pelicula pelicula : listaPeliculas) {
            IO.println(pelicula.getNombre());
        }
    }

    private void eliminarPelicula() {
        IO.print("Nombre: ");
        String nombre = teclado.nextLine();
        // TODO Pedir confirmación al usuario??
        boolean eliminada = listaPeliculas.removeIf(pelicula -> pelicula.getNombre().equals(nombre));
        if (eliminada) {
            IO.println("La pelicula se ha eliminado correctamente");
        } else {
            IO.println("No existe ninguna pelicula con ese nombre");
        }

        FicheroUtil.guardarFichero(listaPeliculas, "peliculas.dat");
    }
}
