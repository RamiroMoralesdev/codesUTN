package tp4;

/**
 *
 * @author ramam
 */
public class TP4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Empleado emp1 = new Empleado("Ramiro", "Programador");
        Empleado emp2 = new Empleado(2, "Charly", "Programador",100.000);

        System.out.println(emp1.toString());
        System.out.println(emp2.toString());

        emp1.aumentarSalario(10.0); // Aumento del 10%. Usando double
        emp2.aumentarSalario(2000); // Aumento de 2000. Usando int

        System.out.println("Despues del aumento:");
        System.out.println(emp1.toString());
        System.out.println(emp2.toString());
    }
    
}
