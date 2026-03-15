package tpcolecciones;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
    private String id;
    private String nombre;
    private String apellido;
    private String especialidad;
    private List<Curso> cursos;

public Profesor(String id, String nombre, String apellido, String especialidad) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.especialidad = especialidad;
    this.cursos = new ArrayList<>();
}

public String getId() {
    return id;
}

public String getNombre() {
    return nombre;
}

public String getApellido() {
    return apellido;
}

public String getEspecialidad() {
    return especialidad;
}

public List<Curso> getCursos() {
    return cursos;
}

public void agregarCurso(Curso a) {
    cursos.add(a);
}

public void eliminarCurso(Curso a) {
    cursos.remove(a);
}

public void listarCursos() {
    for (Curso c : cursos) {
        System.out.println(c.getNombre());
    }
}

public void mostrarInfo() {
    System.out.println("Profesor: " + nombre + " " + apellido + " con especialidad en " + especialidad + ".");
}

@Override
public String toString() {
    return "Profesor{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", especialidad=" + especialidad + '}';
}



}