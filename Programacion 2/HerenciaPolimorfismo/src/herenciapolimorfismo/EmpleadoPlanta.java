package herenciapolimorfismo;

public class EmpleadoPlanta extends Empleado {
    double sueldoBase;
    double bonificacion;
    
    
    public EmpleadoPlanta(String nombre, double sueldoBase, double bonificacion) {
        super(nombre);
        this.sueldoBase = sueldoBase;
        this.bonificacion = bonificacion;
    }

    @Override
    public double calcularSueldo() {
        return sueldoBase + bonificacion;
    }
}
