package relaciones1a1;

public class Documento {
    private String titulo;
    private String contenido;
    FirmaDigital firmaDigital;

    public Documento(String titulo, String contenido, FirmaDigital firmaDigital) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.firmaDigital = firmaDigital;
    }

    public String getTitulo() {
        return titulo;
    }
    public String getContenido() {
        return contenido;
    }
    public FirmaDigital getFirmaDigital() {
        return firmaDigital;
    }

}
