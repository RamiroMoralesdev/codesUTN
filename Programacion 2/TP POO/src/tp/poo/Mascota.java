/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.poo;

/**
 *
 * @author ramiromoralesdev
 */
public class Mascota {
    String nombre;
    String especie;
    int edad;
   
    void mostrarInfo() {
        System.out.println(nombre + especie + edad);
    }
    
    void cumplirAnios() {
        edad += 1;
    }
    
}
