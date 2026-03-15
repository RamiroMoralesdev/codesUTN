package tpinterfaces;

public class TarjetaCredito implements PagoConDescuento {
    @Override
    public double aplicarDescuento(double monto) {
        return monto * 0.10; // 10% de descuento
    }

    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago de $" + monto + " procesado con Tarjeta de Crédito.");
    }
}
