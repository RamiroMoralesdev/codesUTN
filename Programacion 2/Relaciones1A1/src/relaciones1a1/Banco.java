package relaciones1a1;

public class Banco {
    private String nombre;
    private String cuit;
    TarjetaCredito tarjetaCredito; // Asociación 1 a 1 con TarjetaCredito

    public Banco(String nombre, String cuit, TarjetaCredito tarjetaCredito) {
        this.nombre = nombre;
        this.cuit = cuit;
        this.tarjetaCredito = tarjetaCredito;
    }

    public String getNombre() {
        return nombre;
    }
    public String getCuit() {
        return cuit;
    }

}
