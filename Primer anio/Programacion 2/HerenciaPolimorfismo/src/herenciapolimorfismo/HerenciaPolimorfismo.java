/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package herenciapolimorfismo;

import java.util.ArrayList;

/**
 *
 * @author ramam
 */
public class HerenciaPolimorfismo {

    public static void main(String[] args) {
        Vehiculo v = new Auto("Ford", "Mustang", 4);
        v.mostrarInfo();

        System.out.println("Ejercicio 2");

        ArrayList<Figura> figuras = new ArrayList<>();

         figuras.add(new Circulo(7));
         figuras.add(new Rectangulo(4, 5));

        for (Figura figura : figuras) {
            figura.calcularArea(figura.getClass().getSimpleName()); // Metodo polimorfico que devuelve el area de el nombre de la clase
    
        }

        System.out.println("Ejercicio 3");

        ArrayList<Empleado> empleados = new ArrayList<>(); 
        empleados.add(new EmpleadoPlanta("Ramiro", 1000, 500));
        empleados.add(new EmpleadoTemporal("Diego", 100, 1500 ));

        for (Empleado e : empleados) {
            e.calcularSueldo();
            
            if (e instanceof EmpleadoPlanta) { // Si iterador es == EmpleadoPlanta
            EmpleadoPlanta empleadoPlanta = (EmpleadoPlanta) e;
            System.out.println("Sueldo de Empleado Planta: $" + empleadoPlanta.calcularSueldo());
        } else if (e instanceof EmpleadoTemporal) {
            EmpleadoTemporal EmpleadoTemporal = (EmpleadoTemporal) e;
            System.out.println("Sueldo de Empleado Temporal: $" + EmpleadoTemporal.calcularSueldo());

        }

    }

    System.out.println("Ejercicio 4");
    ArrayList <Animal> Animales = new ArrayList<>();

    Animales.add(new Perro());
    Animales.add(new Gato());
    Animales.add(new Vaca ());

    for (Animal a : Animales) {
        a.hacerSonido();
    }



    System.out.println("HOLA. PARA EL EJERCICIO 5 TODAVIA NO CUBRIMOS LO QUE SON INTERFACES Y GENERICS");
}

}