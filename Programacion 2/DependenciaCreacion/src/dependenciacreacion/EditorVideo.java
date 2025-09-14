package dependenciacreacion;

public class EditorVideo {
    // Dependencia de creación: instancia Render dentro del método
    public Render exportar(String formato, Proyecto proyecto) {
        return new Render(formato, proyecto);
    }
}
