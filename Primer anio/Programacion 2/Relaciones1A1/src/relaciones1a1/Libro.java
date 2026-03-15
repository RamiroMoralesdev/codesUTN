package relaciones1a1;

public class Libro {
    private String titulo;
    private String isbn;
    private Editorial editorial; // Asociación bidireccional

    public Libro(String titulo, String isbn, Editorial editorial) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.editorial = editorial;
    }

    public String getTitulo() {
        return titulo;
    }


    public String getIsbn() {
        return isbn;
    }

    public Editorial getEditorial() {
        return editorial;
    }
}
