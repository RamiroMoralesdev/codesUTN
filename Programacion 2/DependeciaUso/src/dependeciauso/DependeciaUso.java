/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dependeciauso;

/**
 *
 * @author ramam
 */
public class DependeciaUso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Ejercicio 12
        Artista artista = new Artista("Ozzy Osbourne", "Rock");
        Cancion cancion = new Cancion("Dreamer", artista);

        Reproductor reproductor = new Reproductor();
        reproductor.reproducir(cancion);

        // Ejercicio 13

        Contribuyente contribuyente = new Contribuyente("Ana Perez", "20-12345678-9");
        Impuesto impuesto = new Impuesto(15000.50, contribuyente);

        Calculadora calc = new Calculadora();
        calc.calcular(impuesto);


    }
    
}
