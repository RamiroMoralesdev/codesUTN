package tpcolecciones;

public class Autor {
    private String ID;
    private String nombre;
    private String nacionalidad;


public Autor(String ID, String nombre, String nacionalidad) {
    this.ID = ID;
    this.nombre = nombre;
    this.nacionalidad = nacionalidad;
}

public String getID() {
    return ID;
}

public String getNombre() {
    return nombre;
}

public String getNacionalidad() {
    return nacionalidad;
}

    @Override
    public String toString() {
        return "Informacion de Autor: " + "ID=" + ID + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + '}';
    }

}
