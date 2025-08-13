/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication3;

import java.util.Scanner;

/**
 *
 * @author ramam
 */
public class JavaApplication3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Scanner input = new Scanner(System.in);


        

    // Ejercicio 5
    System.err.println("Ejercicio 5"); 

    
    int num = -1; // valor inicial distinto de 0 para entrar al bucle
    int suma = 0;
    
    while (num != 0) {
        System.out.println("Ingrese un numero (0 para salir): ");
        num = input.nextInt();
        
        if (num != 0 && num % 2 == 0) {
            System.out.println("El numero " + num + " es par");
            suma += num; // sumar al acumulador
            System.out.println("La suma de los numeros pares es: " + suma);
        }
    }
    

  


    
}  // Fin del main 
    
    
}
