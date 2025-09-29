package tpcolecciones;

import java.util.ArrayList;
import java.util.List;

public class Bibloteca {
        private String nombre;
        private List<Libro> libros;

        public Bibloteca(String nombre) {
            this.nombre = nombre;
            this.libros = new ArrayList<>();
        }


    public String getNombre() {
        return nombre;
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void listarLibros() {
        for (Libro libro : libros) {
            System.out.println(libro.getTitulo());
        }
    }


    public void buscarLibroPorId(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equalsIgnoreCase(isbn)) {
                System.out.println("Libro encontrado: " + libro.getTitulo());
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }

    public void eliminarLibro(String isbn) {
        for(Libro libro : libros) {
            if(libro.getIsbn().equalsIgnoreCase(isbn)) {
                libros.remove(libro);
                System.out.println("Libro eliminado: " + libro.getTitulo());
                return;
            }
        }
    }

    public void obtenerCantidadLibros() {
        System.out.println("La cantidad de libros es: " + libros.size());
    }

    public ArrayList<Libro> filtarLibrosPorAnio(int anio) {  // Esta devolviendo el ultimo elemento que coincide. Deberia devolver todos los elementos que coinciden con el anio. Es un for each pero no se porque no me devuelve todo los elementos 
        ArrayList<Libro> librosFiltrados = new ArrayList<>();
        for(Libro libro : libros) {
            if(libro.getAnioPublicacion() == anio) {
                librosFiltrados.add(libro);
            }
        }

        for(Libro libro : librosFiltrados) {
            System.out.println(libro.getTitulo());
        }

        return librosFiltrados;
    }


    public void mostrarAutoresDisponibles() {
        for(Libro libro : libros) {
            System.out.println("Autor: " + libro.getAutor());
        }
    }

}
