package tpinterfaces;

import java.util.ArrayList;
import java.util.List;

public class Pedido implements Pagable {

    // Se puede agregar clase enum dentro de una clase
    public enum Estado {
        PENDIENTE, PAGADO, ENVIADO, ENTREGADO
    }

    private List<Producto> productos = new ArrayList<>();
    private Cliente cliente;
    private Estado estado;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.estado = Estado.PENDIENTE;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public Estado getEstado() {
        return estado;
    }

    public void cambiarEstado(Estado nuevoEstado) {
        this.estado = nuevoEstado;
        // Notifica al cliente cada vez que cambia el estado
        cliente.notificar("Tu pedido ahora está: " + nuevoEstado);
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.calcularTotal(); // Acumula el precio de cada producto
        }
        return total;
    }
}
