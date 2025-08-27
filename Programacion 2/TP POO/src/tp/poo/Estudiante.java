/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.poo;

/**
 *
 * @author ramiromoralesdev
 */
public class Estudiante {
    
    String nombre;
    String apellido;
    String curso;
    int nota;
    
    
    void mostrarInfo() {
        System.out.print("Los datos del estudiante: " + nombre + apellido + curso + nota);
    }
    
    void subirNota(int puntos) {
        if (nota <= 10) {
            nota += puntos;
        } else {
            System.out.print("La nota no puede ser mayor a 10");
            System.out.print("La nota es: " + nota);
        }
        
    }
    
    void bajarNota(int puntos) {
        nota -= puntos;
    }
}
