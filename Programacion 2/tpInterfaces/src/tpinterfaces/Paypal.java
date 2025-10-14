package tpinterfaces;

public class Paypal implements Pago {
    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago de $" + monto + " procesado con PayPal.");
    }
}
