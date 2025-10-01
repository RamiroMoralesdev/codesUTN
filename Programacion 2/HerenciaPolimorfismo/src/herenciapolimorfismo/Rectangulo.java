package herenciapolimorfismo;

public class Rectangulo extends Figura {
    
    private double base;
    private double altura;
    
    public Rectangulo(double base, double altura) {
        super();
        this.base = base;
        this.altura = altura;
    }

    @Override
    public void calcularArea(String nombre) {
        System.out.println("El area del " + nombre + " es: " + base * altura);
        System.out.println("Se termino de ejecutar el metodo sobreescrito de Rectangulo");
    }
    
}

