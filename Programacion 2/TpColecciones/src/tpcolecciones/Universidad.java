package tpcolecciones;

import java.util.List;

public class Universidad {
    String nombre;
    List<Profesor> profesores;
    List<Curso> cursos;

    public Universidad(String nombre, List<Profesor> profesores, List<Curso> cursos) {
        this.nombre = nombre;
        this.profesores = profesores;
        this.cursos = cursos;
    }

    public String getNombre() {
        return nombre;
    }

    public void listarCursos() {
        for (Curso c : cursos) {
            c.mostrarInfo();
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
                p.mostrarInfo();
                return;
            }
        }
        System.out.println("Profesor no encontrado.");
    }

    public void buscarCursoPorCodigo(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equalsIgnoreCase(codigo)) {
                c.mostrarInfo();
                return;
            }
        }
        System.out.println("Curso no encontrado.");
    }

    public void eliminarCurso(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equalsIgnoreCase(codigo)) {
                cursos.remove(c);
                return;
            }
        }
        System.out.println("Curso no encontrado.");
    }

    public void eliminarProfesor(String id) {
        for (Profesor p : profesores) {
            if (p.getId().equalsIgnoreCase(id)) {
                profesores.remove(p);
                return;
            }
        }
        System.out.println("Profesor no encontrado.");
    }
}
