package manejoerrores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ManejoErrores {

    public static void main(String[] args) {

        Scanner text = new Scanner(System.in);

        //  Ejercicio 1 
        /*
        try {
            int x = 5;
            int y = 0;
            int div = x / y;
            System.out.println("El resultado es: " + div);
        } catch (ArithmeticException ae) {
            System.out.println("Error: No se puede dividir por cero.");
        } finally {
            System.out.println("Operación finalizada.");
        }
        */

        //  Ejercicio 2 
        /*
        try {
            System.out.print("Ingrese un número o texto: ");
            String textoUsuario = text.nextLine();
            int numero = Integer.parseInt(textoUsuario);
            System.out.println("El número ingresado es: " + numero);
        } catch (NumberFormatException nfe) {
            System.out.println("Error: no se puede convertir el texto ingresado en un número entero.");
        }
        */

        //  Ejercicio 3 - Lectura de TXT 
        /*
        String ruta = "Programacion 2/ManejoErrores/src/manejoerrores/archivo.txt";
        File elArchivo = new File(ruta);
        try (BufferedReader br = new BufferedReader(new FileReader(elArchivo))) {
            System.out.println(br.readLine());
        } catch (IOException ie) {
            System.out.println("Error de E/S: " + ie.getMessage());
            throw new RuntimeException("Error inesperado en el catch");
        }
        */

        //  Ejercicio 4 - Excepción personalizada 
        /*
        try {
            validarEdad(150); // ejemplo de edad inválida
        } catch (EdadInvalidaException e) {
            System.out.println("Error: " + e.getMessage());
        }
        */

        // Ejercicio 5 - try-with-resources 
        String ruta = "Programacion 2/ManejoErrores/src/manejoerrores/archivo.txt";
        leerArchivo(ruta);
    }  
   
}
