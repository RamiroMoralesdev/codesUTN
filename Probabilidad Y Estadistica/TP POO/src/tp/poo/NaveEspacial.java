/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.poo;

/**
 *
 * @author ramiromoralesdev
 */
public class NaveEspacial {
    
    String nombre;
    int combustible;
     int MAX_COMBUSTIBLE = 100;

    void despegar() {
        if (combustible >= 10) {
            combustible -= 10;
            System.out.println(nombre + " ha despegado. Combustible restante: " + combustible);
        } else {
            System.out.println(nombre + " no tiene suficiente combustible para despegar.");
        }
    }

    void avanzar(int distancia) {
        int consumo = distancia * 2; // 2 unidades de combustible por km
        if (combustible >= consumo) {
            combustible -= consumo;
            System.out.println(nombre + " avanzó " + distancia + " km. Combustible restante: " + combustible);
        } else {
            System.out.println(nombre + " no tiene suficiente combustible para avanzar " + distancia + " km.");
        }
    }

    void recargarCombustible(int cantidad) {
        if (combustible + cantidad <= MAX_COMBUSTIBLE) {
            combustible += cantidad;
            System.out.println("Se recargaron " + cantidad + " Combustible actual: " + combustible);
        } else {
            combustible = MAX_COMBUSTIBLE;
            System.out.println("Se recargó al 100% ");
        }
    }

    void mostrarEstado() {
        System.out.println("Nave: " + nombre + " Combustible: " + combustible);
    }
}

    
    