package herenciapolimorfismo;

public class Circulo extends Figura {
    
    private double radio;
    
    public Circulo(double radio) {
        super();
        this.radio = radio;
    }
    @Override 
       public void calcularArea(String nombre) {
        System.out.println("El area del " + nombre + " es: " + 2 * Math.PI * radio );
        System.out.println("Se termino de ejecutar el metodo sobreescrito de Circulo");
        
    }
    
}
    

