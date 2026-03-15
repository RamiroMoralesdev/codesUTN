package relaciones1a1;

public class TarjetaCredito {
    private String numero;
    private String fechaVencimiento;
    Cliente cliente; // Asociación 1 a 1 con Cliente
    Banco banco; // Asociación bidireccional con Banco

    public TarjetaCredito(String numero, String fechaVencimiento, Cliente cliente, Banco banco) {
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
        this.cliente = cliente;
        this.banco = banco;
    }

    public String getNumero() {
        return numero;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }
}
