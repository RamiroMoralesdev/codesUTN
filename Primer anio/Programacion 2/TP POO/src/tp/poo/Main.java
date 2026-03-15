/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp.poo;

/**
 *
 * @author ramiromoralesdev
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estudiante est1 = new Estudiante();

        est1.nombre = "Ramiro ";
        est1.apellido = "Morales ";
        est1.curso = "Programacion 2 ";
        est1.nota = 10;

        est1.mostrarInfo();
        
        est1.bajarNota(5);
        est1.mostrarInfo();
        
        est1.subirNota(2);
        est1.mostrarInfo();
        
        
        
        Mascota perro = new Mascota();
        
        perro.nombre = "Firulais";
        perro.especie = "Bulldog";
        perro.edad = 4;
        
        perro.mostrarInfo();
        perro.cumplirAnios();
        perro.mostrarInfo();
        
        
        Gallina g1 = new Gallina();
        Gallina g2 = new Gallina();
        
        g1.idGallina = 1001;
        g1.edad = 5;
        g1.huevosPuestos = 0;
        
        g1.envejecer(1);
        g1.ponerHuevos(5);
        g1.mostrarEstado();
        
        
        g2.idGallina = 1002;
        g2.edad = 3;
        g2.huevosPuestos = 0;
        
        g2.ponerHuevos(10);
        g2.envejecer(3);
        g2.mostrarEstado();
        
        
        NaveEspacial nave = new NaveEspacial();
        nave.nombre = "Navecita";
        nave.combustible = 50;

        nave.despegar();
        nave.avanzar(30);   // debería fallar porque no alcanza

        nave.recargarCombustible(40);
        nave.avanzar(20);   

        nave.mostrarEstado();
       
        
    }
    
    
    
}
