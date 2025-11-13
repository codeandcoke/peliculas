package com.svalero.peliculas.util;

import com.svalero.peliculas.model.Pelicula;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FicheroUtil {

    public static void guardarFichero(List<Pelicula> listaPeliculas, String nombreFichero) {
        ObjectOutputStream serializador = null;
        try {
            serializador = new ObjectOutputStream(new FileOutputStream(nombreFichero));
            serializador.writeObject(listaPeliculas);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            IO.println("Se ha producido un error al guardar al fichero");
        } finally {
            if (serializador != null)
                try {
                    serializador.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
        }
    }

    public static List<Pelicula> cargarFichero(String nombreFichero) {
        List<Pelicula> listaPeliculas = null;
        ObjectInputStream deserializador = null;
        try {
            deserializador = new ObjectInputStream(new FileInputStream(nombreFichero));
            listaPeliculas = (ArrayList<Pelicula>) deserializador.readObject();
        } catch (FileNotFoundException fnfe ) {
            IO.println("No se ha encontrado el fichero");
        } catch (ClassNotFoundException cnfe ) {
            IO.println("El formato del fichero no es el esperado");
        } catch (IOException ioe) {
            IO.println("Se ha producido un error al leer el fichero");
        } finally {
            if (deserializador != null)
                try {
                    deserializador.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
        }

        return listaPeliculas;
    }
}
