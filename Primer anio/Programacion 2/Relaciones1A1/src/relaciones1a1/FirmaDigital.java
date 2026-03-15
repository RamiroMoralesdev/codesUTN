package relaciones1a1;

public class FirmaDigital {
    private String codigoHash;
    private String fecha;
    private UsuarioDoc usuarioDoc;

    public FirmaDigital(String codigoHash, String fecha, UsuarioDoc usuarioDoc) {
        this.codigoHash = codigoHash;
        this.fecha = fecha;
        this.usuarioDoc = usuarioDoc;
    }

    public String getCodigoHash() {
        return codigoHash;
    }
    public String getFecha() {
        return fecha;
    }
    public UsuarioDoc getUsuarioDoc() {
        return usuarioDoc;
    }
    
}
