package dependeciauso;

public class Reproductor {
    // Dependencia de uso: recibe Cancion como parámetro
    public void reproducir(Cancion cancion) {
        System.out.println("Reproduciendo: " + cancion.getTitulo() +
                " de " + cancion.getArtista().getNombre());
    }
    
}
