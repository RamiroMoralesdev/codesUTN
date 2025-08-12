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
        
        System.out.println("Ingrese ano de nacimiento para determinar si es bisiesto ");
        int anioUsuario = input.nextInt();
        
        if (anioUsuario % 4 == 0 && anioUsuario % 100 != 0) {
            System.out.print("El anio " + anioUsuario + " es bisiesto");
        } else {
           System.out.print("El anio " + anioUsuario + " no es bisiesto");
        }
        
        System.out.println();
        
        
        
        // Ejercicio 2

       System.out.println("Ingrese el primer numero");
       int primer_num = input.nextInt();

       System.out.println("Ingrese el segundo numero");
       int segundo_num = input.nextInt();

       System.out.println("Ingrese el tercer numero");
       int tercer_num = input.nextInt();

       if (primer_num > segundo_num && primer_num > tercer_num) {
           System.out.println("El mayor es: " + primer_num);
       } else if (segundo_num > primer_num && segundo_num > tercer_num) {
           System.out.println("El mayor es: " + segundo_num);
       } else {
           System.out.println("El mayor es: " + tercer_num);
       }

    
}
    
}
