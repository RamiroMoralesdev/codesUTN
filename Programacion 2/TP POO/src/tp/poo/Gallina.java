/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.poo;

/**
 *
 * @author ramiromoralesdev
 */
public class Gallina {
    
    int idGallina;
    int edad;
    int huevosPuestos;
    
    
    void ponerHuevos(int cantidad) {
    
        huevosPuestos += cantidad;
    }
    
    void envejecer(int anios) {
        
        edad += anios;
    
    }
    
    void mostrarEstado() {
        System.out.println("Estado:  ID" + idGallina + " " + edad + " " + huevosPuestos );
    }
    
}
