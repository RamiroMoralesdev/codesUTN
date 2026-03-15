package tpcolecciones;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Universidad {
    String nombre;
    ArrayList<Profesor> profesores;
    ArrayList<Curso> cursos;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void listarCursos() {
        for (Curso c : cursos) {
            System.out.println(c.getNombre());
        }
    }

    public void agregarProfesor(Profesor p) {
        profesores.add(p);
    }

    public void agregarCurso(Curso c) {
        cursos.add(c);
    }

    public void asignarProfesorCurso(Profesor p, Curso c) {
        c.setProfesor(p);
    }

    public void listarProfesores() {
        for (Profesor p : profesores) {
            p.mostrarInfo();
            
        }
    }


    public void buscarProfesorPorId(String id) {
        for (Profesor p : profesores) {
            if (p.getId().equalsIgnoreCase(id)) {
                System.out.println("Profesor encontrado: " + p.getNombre() + " " + p.getApellido());
                return;
            }
        }
        System.out.println("Profesor no encontrado.");
    }

    public void buscarCursoPorCodigo(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equalsIgnoreCase(codigo)) {
                System.out.println("Curso encontrado: " + c.getNombre());;
                return;
            }
        }
        System.out.println("Curso no encontrado.");
    }

    public void eliminarCurso(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equalsIgnoreCase(codigo)) {
                cursos.remove(c);
                System.out.println("Curso eliminado." + c.getNombre());
                return;
            }
        }
        System.out.println("Curso no encontrado.");
    }

    public void eliminarProfesor(String id) {
        for (Profesor p : profesores) {
            if (p.getId().equalsIgnoreCase(id)) {
                profesores.remove(p);
                System.out.println("Profesor eliminado." + p.getNombre());
                return;
            }
        }
        System.out.println("Profesor no encontrado.");
    }
}
