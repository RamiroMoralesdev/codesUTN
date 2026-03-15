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

    // Variables globales
    final static double entradaSalida = 0.10; // Descuento del 10%

    // Las funciones deben estar fuera del main, pero dentro de la clase

    public static void mostrarProductos(double [] productos, int indice) {
    if (indice >= productos.length) {
        return;
    }

    // Mostramos el producto actual
    System.out.println("Precio: " + productos[indice]);

    // Llamada recursiva al siguiente elemento
    mostrarProductos(productos, indice + 1);

    }

public static void calcularCostoEnvio(double pesoPaquete, String zona,double costoProducto) {
    double costoEnvio;

    if (zona.equalsIgnoreCase("Nacional")) {
        costoEnvio = 5 * pesoPaquete;
        System.out.println("El costo de envío es: " + costoEnvio);
        System.out.println("El total a pagar es: " + (costoProducto + costoEnvio));

    } else if (zona.equalsIgnoreCase("Internacional")) {
        costoEnvio = 10 * pesoPaquete; 
        System.out.println("El costo de envío es: " + costoEnvio);
        System.out.print("El total a pagar es: " + (costoProducto + costoEnvio));
    } else {
        System.out.println("Algun valor ingresado no es valido.");
    }
}


public static void actualizarStock(int stockActual, int cantidadVendida, int cantidadRecibida) {
    int nuevoStock;

    nuevoStock = stockActual + (cantidadRecibida - cantidadVendida);

    System.out.println("El nuevo stock es: " + nuevoStock);
}

public static void calcularDescuentoEspecial(double precioBase, double descuentoGlobal) {
    
    double descuentoAplicado;


    descuentoAplicado = precioBase * descuentoGlobal;

    System.out.print("El descuento aplicado es : " + descuentoAplicado);
    System.out.println("El precio final del producto es: " + (precioBase - (precioBase * descuentoGlobal)));
}

  public static double calcularPrecioFinal(double precioBase, double impuesto, double descuento) {
        
        // Convertir porcentajes a decimales
        impuesto = impuesto / 100;
        descuento = descuento / 100;

        return precioBase + (precioBase * impuesto) - (precioBase * descuento);
    }

    public static void productosModificados(double[] productos, int indice) {
    if (indice >= productos.length) {
        return;
    }

    productos[0] = 180; // Modificando el primer producto
    productos[1] = 140; // Modificando el segundo producto
    productos[2] = 280; // Modificando el tercer producto
    productos[3] = 230; // Modificando el cuarto producto
    productos[4] = 380; // Modificando el quinto producto
    productos[5] = 330; // Modificando el sexto producto

    // Mostramos el producto actual
    System.out.println("Precio: " + productos[indice]);

    // Llamada recursiva al siguiente elemento
    mostrarProductos(productos, indice + 1);

}


    public static void main(String[] args) {
       
        Scanner input = new Scanner(System.in);

       // Ejercicio 1
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

    // Ejercicio 3
    System.err.println("Ejercicio 3");
    
    System.out.println("Ingrese edad: ");
    int edad = input.nextInt();

    if (edad < 12) {
        System.out.println("Niño");
    } else if (edad >= 12 && edad < 17) {
        System.out.println("Adolescente");
    } else if (edad >= 18 && edad <= 59) {
        System.out.println("Adulto");
    } else {
        System.out.println("Adulto mayor");
    }


   // Ejercicio 4
    System.err.println("Ejercicio 4");

    System.out.println("Ingrese el primer numero");
        int primer_num2 = input.nextInt();

        System.out.println("Ingrese el segundo numero");
        int segundo_num2 = input.nextInt();

        System.out.println("Ingrese el tercer numero");
        int tercer_num2 = input.nextInt();

        if (primer_num2 > segundo_num2 && primer_num2 > tercer_num2) {
        System.out.println("El mayor es: " + primer_num2);
        } else if (segundo_num2 > primer_num2 && segundo_num2 > tercer_num2) {
        System.out.println("El mayor es: " + segundo_num2);
        } else {
        System.out.println("El mayor es: " + tercer_num2);
        }


    // Ejercicio 5
    System.err.println("Ejercicio 5");

    int num = -1; // valor inicial distinto de 0 para entrar al bucle
    int suma = 0;

    while (num != 0) {
        System.out.println("Ingrese un numero (0 para salir): ");
        num = input.nextInt();
        
        if (num != 0 && num % 2 == 0) {
            System.out.println("El numero " + num + " es par");
            suma += num; // sumamos al acumulador
            System.out.println("La suma de los numeros pares es: " + suma);
        }
    }


    

    // Ejercicio 6
    System.err.println("Ejercicio 6");

    int positivos = 0;
    int negativos = 0;
    int ceros = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.print("Ingrese el número " + i + ": ");
            int numero = input.nextInt();

            if (numero > 0) {
                positivos++;
            } else if (numero < 0) {
                negativos++;
            } else {
                ceros++;
            }
        }

        System.out.println("Positivos: " + positivos);
        System.out.println("Negativos: " + negativos);
        System.out.println("Ceros: " + ceros);

  

// Ejercicio 7
        System.err.println("Ejercicio 7");

         int nota;

        while (true) {
            System.out.print("Ingrese una nota válida entre 0 y 10 (o -1 para salir): ");
            nota = input.nextInt();

            if (nota == -1) {
                System.out.println("Saliendo del programa...");
                break; // Salir del bucle si se ingresa -1
            }

            if (nota >= 0 && nota <= 10) {
                System.out.println("Nota guardada correctamente: " + nota);
                break;
            } else {
                System.out.println("Nota inválida1. Debe estar entre 0 y 10.");
            }
        
        }

        // Ejercicio 8
        System.err.println("Ejercicio 8");

        System.out.print("Ingrese el precio base del producto: ");
        double precioBase = input.nextDouble();

        System.out.print("Ingrese el porcentaje de impuesto: ");
        double impuesto = input.nextDouble();

        System.out.print("Ingrese el porcentaje de descuento: ");
        double descuento = input.nextDouble();

        double precioFinal = calcularPrecioFinal(precioBase, impuesto, descuento);

        System.out.print("El precio final del producto es: " + precioFinal);


    // Ejercicio 9
    System.err.println("Ejercicio 9");

    System.out.print("Ingrese el costo del producto: ");
    double costoProducto = input.nextDouble();

    System.out.print("Ingrese el peso del paquete en kg: ");
    double pesoPaquete = input.nextDouble();

    System.out.print("Ingrese la zona de envío (Nacional/Internacional): ");
    String zona = input.next();

    calcularCostoEnvio(pesoPaquete, zona, costoProducto);


    // Ejercicio 10 
    System.err.println("Ejercicio 10");

    System.out.print("Ingrese el stock actual del producto: ");
    int stockActual = input.nextInt(); // Ejemplo de stock inicial

    System.out.print("Ingrese la cantidad vendida: ");
    int cantidadVendida = input.nextInt();

    System.out.print("Ingrese la cantidad recibida: ");
    int cantidadRecibida = input.nextInt();

    actualizarStock(stockActual, cantidadVendida, cantidadRecibida);


    // Ejercicio 11
    System.err.println("Ejercicio 11");

    System.out.print("Ingrese el precio del producto: ");
            double precioProducto = input.nextDouble();

            calcularDescuentoEspecial(precioProducto, entradaSalida);


    // Ejercicio 12
            System.err.println("Ejercicio 12");

            String[] Productos = {"$200", "$150", "$300", "$250", "$400", "$350"};

            System.out.println("Precios originales: ");
            for (String producto : Productos) {
                System.out.println("Precio " + producto + " ");
            }

            // Modificando valores del array. Accediendo a cada elemento 
            Productos[0] = "$180"; 
            Productos[1] = "$140";
            Productos[2] = "$280";
            Productos[3] = "$230";
            Productos[4] = "$380";
            Productos[5] = "$330";


            System.out.println("Precios modificados: ");
            for (String producto : Productos) {
                System.out.println("Precio " + producto + " ");
            }


    // Ejercicio 13
    System.err.println("Ejercicio 13");

            double[] productos = {200, 150, 1000, 250, 800, 350};

            mostrarProductos(productos, 0);

            System.out.println("Productos modificados: ");

            productosModificados(productos, 0);



} // Cierre del main

}  // Cierre de la clase 
