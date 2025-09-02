package tpintroduccion;

import java.util.Scanner;

/**
 *
 * @author ramiromoralesdev
 */
public class Tpintroduccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        // Ejercicio 1 
        System.out.println("Hola mundo");
        
        
        // Ejercicio 2 
        String nombre = "Ramiro";
        int edad = 25;
        double altura = 1.78;
        boolean estudiante = true;

        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Altura: " + altura);
        System.out.println("Es estudiante? " + estudiante);
        
        
        // Ejercicio 3
        System.out.print("Ingresa tu nombre: ");
        String nombreEntrada = scanner.nextLine();

        System.out.print("Ingresa tu edad: ");
        int edadEntrada = scanner.nextInt();

        System.out.println("Tu nombre es " + nombreEntrada + " tenes " + edadEntrada + " años.");
        
        
        // Ejercicio 4 
        
        System.out.print("Ingresa el primer número: ");
        int num1 = scanner.nextInt();

        System.out.print("Ingresa el segundo número: ");
        int num2 = scanner.nextInt();

        System.out.println("Suma: " + (num1 + num2));
        System.out.println("Resta: " + (num1 - num2));
        System.out.println("Multiplicación: " + (num1 * num2));

        if (num2 != 0) {
            System.out.println("División: " + (num1 / num2));
        } else {
            System.out.println("No se puede dividir entre 0.");
        }
        
        
        
        // Ejercicio 5 
         System.out.println("Nombre: Juan Pérez\nEdad: 30 años\nDirección: \"Calle Falsa 123\"");
         
        
        // Ejercicio 6
        // Correccion de logica en el pdf 
        
        // Ejercicio 7
        System.out.print("Ingresa el primer número: ");
        int a = scanner.nextInt();

        System.out.print("Ingresa el segundo número: ");
        int b = scanner.nextInt();

        // División con enteros
        System.out.println("División entera: " + (a / b));

        // División con decimales
        double da = a;
        double db = b;
        System.out.println("División decimal: " + (da / db));
        
        
        // Ejercicio 8
        // Correccion de logica en el pdf. El error era usar nextInt en lugar de nextLine para leer un texto.
        
        
        // Ejercicio 9
        int x = 5;
        int z = 2;
        int resultado = x / z;
        System.out.println("Resultado: " + resultado);
        
        
        
    }
    
}
