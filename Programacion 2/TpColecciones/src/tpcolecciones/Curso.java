package tpcolecciones;

public class Curso {
    private String codigo;
    private String nombre;
    private Profesor profesor;

    public Curso(String codigo, String nombre, Profesor profesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public String getNombre() {
        return nombre;
    }   

    public String getNombreCompleto() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    
    }

    @Override
    public String toString() {
        return "Curso{" + "codigo=" + codigo + ", nombre=" + nombre + ", profesor=" + profesor + '}';
    }
    
    

    public void mostrarInfo() {
        System.out.println("Curso: " + nombre + " con profesor " + profesor.getNombre() + " " + profesor.getApellido() );
    }
    
    
}
