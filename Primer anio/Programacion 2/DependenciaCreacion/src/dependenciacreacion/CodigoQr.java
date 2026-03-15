package dependenciacreacion;

public class CodigoQr {
    private String valor;
    private Usuario usuario; // Asociación unidireccional

    public CodigoQr(String valor, Usuario usuario) {
        this.valor = valor;
        this.usuario = usuario;
    }

    public String getValor() {
        return valor;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
