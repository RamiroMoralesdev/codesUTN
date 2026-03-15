package dependeciauso;

public class Calculadora {
    // Dependencia de uso: recibe Impuesto como parámetro
    public void calcular(Impuesto impuesto) {
        System.out.println("Calculando impuesto de $" + impuesto.getMonto() +
                " para " + impuesto.getContribuyente().getNombre());
    }
}
