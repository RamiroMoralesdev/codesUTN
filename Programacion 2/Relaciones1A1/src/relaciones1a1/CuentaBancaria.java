package relaciones1a1;

public class CuentaBancaria {
    private int cbu;
    private double saldo;
    private Titular titular; // Asociación uno a uno con Titular 1A1    
    private ClaveSeguridad claveSeguridad; // Asociación uno a uno con ClaveSeguridad 1A1

    public CuentaBancaria(String numeroCuenta, double saldo, Titular titular, ClaveSeguridad claveSeguridad) {
        this.cbu = Integer.parseInt(numeroCuenta);
        this.saldo = saldo;
        this.titular = titular;
        this.claveSeguridad = claveSeguridad;
    }

    public int getCBU() {
        return cbu;
    }
    public double getSaldo() {
        return saldo;
    }
    public Titular getTitular() {
        return titular;
    }

    public ClaveSeguridad getClaveSeguridad() {
        return claveSeguridad;
    }
}
