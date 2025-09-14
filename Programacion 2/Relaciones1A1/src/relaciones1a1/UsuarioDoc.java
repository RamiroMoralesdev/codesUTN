package relaciones1a1;

public class UsuarioDoc {
    private String nombre;
    private String email;

    public UsuarioDoc(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }
}
