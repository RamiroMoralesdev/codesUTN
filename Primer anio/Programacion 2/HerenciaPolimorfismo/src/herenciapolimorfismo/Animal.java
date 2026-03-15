package herenciapolimorfismo;

public class Animal {
    
    public void hacerSonido() {
        System.out.println("El animal hace un sonido"); // Este metodo nunca se deberia mostrar si esta sobreescrito
    }

    public void describirAnimal() {
        System.out.println("Soy un animal"); // Este metodo nunca se sobreescribe 
    }


}
