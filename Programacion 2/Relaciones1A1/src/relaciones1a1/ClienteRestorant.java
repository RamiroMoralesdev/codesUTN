package relaciones1a1;

public class ClienteRestorant {
    private String nombre;
    private String telefono;

    public ClienteRestorant(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }


    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

}
