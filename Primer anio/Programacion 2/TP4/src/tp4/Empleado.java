package tp4;

/**
 *
 * @author ramam
 */
public class Empleado {
    
    int Id;
    String Nombre;
    String Puesto;
    double salario;
    static int totalEmpleados = 0;

    // Constructor que recibe todos los parametros 
    public Empleado(int Id, String Nombre, String Puesto, double salario) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Puesto = Puesto;
        this.salario = salario;
        totalEmpleados++;
    }

    // Constructor que recube solo nombre y puesto, asignando id y salario 
    public Empleado(String Nombre, String Puesto) {
        this.Id = totalEmpleados + 10;
        this.Nombre = Nombre;
        this.Puesto = Puesto;
        this.salario = 500000; // Salario por defecto
        totalEmpleados++;
    }

    // Metodo sobrecargado para que reciba un porcentaje y cantidad fija 
    public void aumentarSalario(double porcentaje) {
        if (porcentaje > 0) {
            this.salario += this.salario * (porcentaje / 100);
        }
    }

    public void aumentarSalario(int cantidadFija) {
        if (cantidadFija > 0) {
            this.salario += cantidadFija;
        }
    }

    public String toString() {
        return "Empleado{" + "Id=" + Id + ", Nombre=" + Nombre + ", Puesto=" + Puesto + ", salario=" + salario + '}';
    }

    public static int MostrarTotalEmpleados() {
        return totalEmpleados;
    }
}

