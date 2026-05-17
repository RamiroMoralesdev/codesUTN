package entities;

public class DetallePedido extends Base {

    private int cantidad;
    private Double subtotal;
    private Producto producto;

    public DetallePedido() {}

    public DetallePedido(Long id, int cantidad, Producto producto) {
        super(id);
        this.cantidad = cantidad;
        this.producto = producto;
        this.subtotal = producto.getPrecio() * cantidad;
    }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public Double getSubtotal() { return subtotal; }
    public void setSubtotal(Double subtotal) { this.subtotal = subtotal; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    @Override
    public String toString() {
        return "DetallePedido{id=" + getId() +
               ", producto='" + (producto != null ? producto.getNombre() : "N/A") + "'" +
               ", cantidad=" + cantidad +
               ", subtotal=$" + subtotal + "}";
    }
}
