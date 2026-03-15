package relaciones1a1;

public class Propietario {
    private String nombre;
    private String dni;

    public Propietario(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }
    public String getDni() {
        return dni;
    }
}
