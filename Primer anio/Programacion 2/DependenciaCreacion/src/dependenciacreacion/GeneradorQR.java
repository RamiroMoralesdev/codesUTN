package dependenciacreacion;

public class GeneradorQR {
    // Dependencia de creación: genera un objeto dentro del método
    public CodigoQR generar(String valor, Usuario usuario) {
        return new CodigoQR(valor, usuario);
    }
    
}
