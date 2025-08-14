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
//  System.out.println("Ingrese ano de nacimiento para determinar si es bisiesto ");
//         int anioUsuario = input.nextInt();
        
//         if (anioUsuario % 4 == 0 && anioUsuario % 100 != 0) {
//             System.out.print("El anio " + anioUsuario + " es bisiesto");
//         } else {
//            System.out.print("El anio " + anioUsuario + " no es bisiesto");
//         }
        
//         System.out.println();
        
        
        
//         // Ejercicio 2

//        System.out.println("Ingrese el primer numero");
//        int primer_num = input.nextInt();

//        System.out.println("Ingrese el segundo numero");
//        int segundo_num = input.nextInt();

//        System.out.println("Ingrese el tercer numero");
//        int tercer_num = input.nextInt();

//        if (primer_num > segundo_num && primer_num > tercer_num) {
//            System.out.println("El mayor es: " + primer_num);
//        } else if (segundo_num > primer_num && segundo_num > tercer_num) {
//            System.out.println("El mayor es: " + segundo_num);
//        } else {
//            System.out.println("El mayor es: " + tercer_num);
//        }


// Ejercicio 3 

        System.out.println("Ingrese año de nacimiento para determinar si es bisiesto:");
        int anioUsuario = input.nextInt();
        
        if ((anioUsuario % 4 == 0 && anioUsuario % 100 != 0) || (anioUsuario % 400 == 0)) {
            System.out.println("El año " + anioUsuario + " es bisiesto");
        } else {
            System.out.println("El año " + anioUsuario + " no es bisiesto");
        }
    }
        

    // Ejercicio 4
    // System.err.println("Ejercicio 4");

    // System.out.println("Ingrese el primer numero");
    //     int primer_num = input.nextInt();

    //     System.out.println("Ingrese el segundo numero");
    //     int segundo_num = input.nextInt();

    //     System.out.println("Ingrese el tercer numero");
    //     int tercer_num = input.nextInt();

    //     if (primer_num > segundo_num && primer_num > tercer_num) {
    //     System.out.println("El mayor es: " + primer_num);
    //     } else if (segundo_num > primer_num && segundo_num > tercer_num) {
    //     System.out.println("El mayor es: " + segundo_num);
    //     } else {
    //     System.out.println("El mayor es: " + tercer_num);
    //     }

    

    // // Ejercicio 6
    // System.err.println("Ejercicio 6");

    // int positivos = 0;
    // int negativos = 0;
    // int ceros = 0;

    //     for (int i = 1; i <= 10; i++) {
    //         System.out.print("Ingrese el número " + i + ": ");
    //         int numero = input.nextInt();

    //         if (numero > 0) {
    //             positivos++;
    //         } else if (numero < 0) {
    //             negativos++;
    //         } else {
    //             ceros++;
    //         }
    //     }

    //     System.out.println("Positivos: " + positivos);
    //     System.out.println("Negativos: " + negativos);
    //     System.out.println("Ceros: " + ceros);

  

// // Ejercicio 7
//         System.err.println("Ejercicio 7");

//          int nota;

//         while (true) {
//             System.out.print("Ingrese una nota válida entre 0 y 10 (o -1 para salir): ");
//             nota = input.nextInt();

//             if (nota == -1) {
//                 System.out.println("Saliendo del programa...");
//                 break; // Salir del bucle si se ingresa -1
//             }

//             if (nota >= 0 && nota <= 10) {
//                 System.out.println("Nota guardada correctamente: " + nota);
//                 break;
//             } else {
//                 System.out.println("Nota inválida1. Debe estar entre 0 y 10.");
//             }
        
//         }

        // Ejercicio 8
        System.err.println("Ejercicio 8");
        public static double calcularPrecioFinal(double precioBase, double impuesto, double descuento) {
        
        // Convertir porcentajes a decimales
        impuesto = impuesto / 100;
        descuento = descuento / 100;

        return precioBase + (precioBase * impuesto) - (precioBase * descuento);
    }

        System.out.print("Ingrese el precio base del producto: ");
        double precioBase = input.nextDouble();

        System.out.print("Ingrese el porcentaje de impuesto: ");
        double impuesto = input.nextDouble();

        System.out.print("Ingrese el porcentaje de descuento: ");
        double descuento = input.nextDouble();

        double precioFinal = calcularPrecioFinal(precioBase, impuesto, descuento);

        System.out.print("El precio final del producto es: %.2f%n" + precioFinal);
    
}  // Fin del main 

}