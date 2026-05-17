package entities;

import enums.Estado;
import enums.FormaPago;
import interfaces.Calculable;

import java.time.LocalDate;
import java.util.List;

public class Pedido extends Base implements Calculable {

    private LocalDate fecha;
    private Estado estado;
    private Double total;
    private FormaPago formaPago;
    private Usuario usuario;
    private List<DetallePedido> detalles;

    public Pedido() {}

    public Pedido(Long id, LocalDate fecha, Estado estado, FormaPago formaPago,
                  Usuario usuario, List<DetallePedido> detalles) {
        super(id);
        this.fecha = fecha;
        this.estado = estado;
        this.formaPago = formaPago;
        this.usuario = usuario;
        this.detalles = detalles;
        this.total = 0.0;
    }

    // ── 1. calcularTotal ──────────────────────────────────────────────────────
    // Implementa la interface Calculable.
    // stream()       → crea el Stream<DetallePedido>            [INTERMEDIA no aplica aquí, es el origen]
    // mapToDouble()  → operación INTERMEDIA: transforma cada detalle en su subtotal (precio × cantidad)
    // sum()          → operación TERMINAL:  reduce todos los doubles a un único valor acumulado
    @Override
    public void calcularTotal() {
        this.total = detalles.stream()
                .mapToDouble(d -> d.getProducto().getPrecio() * d.getCantidad())
                .sum();
    }

    // ── 2. mostrarProductosDisponibles ────────────────────────────────────────
    // stream()   → crea el Stream<Producto>
    // filter()   → operación INTERMEDIA: retiene sólo los productos cuyo campo disponible == true
    // forEach()  → operación TERMINAL:  consume cada elemento imprimiéndolo por consola
    public void mostrarProductosDisponibles(List<Producto> productos) {
        System.out.println("\n=== Productos disponibles ===");
        productos.stream()
                .filter(p -> p.getDisponible())
                .forEach(System.out::println);
    }

    // ── 3. contarItems ────────────────────────────────────────────────────────
    // stream()      → crea el Stream<DetallePedido>
    // mapToInt()    → operación INTERMEDIA: transforma cada detalle en su cantidad (int)
    // sum()         → operación TERMINAL:  suma todos los enteros del stream
    public void contarItems() {
        int totalItems = detalles.stream()
                .mapToInt(DetallePedido::getCantidad)
                .sum();
        System.out.println("\nEl pedido tiene " + totalItems + " ítems en total.");
    }

    // ── 4. detectarStockBajo ──────────────────────────────────────────────────
    // stream()   → crea el Stream<Producto>
    // filter()   → operación INTERMEDIA: retiene sólo los productos con stock menor a 5
    // forEach()  → operación TERMINAL:  consume cada elemento imprimiendo una alerta
    public void detectarStockBajo(List<Producto> productos) {
        System.out.println("\n=== Alerta: productos con stock bajo (< 5 unidades) ===");
        productos.stream()
                .filter(p -> p.getStock() < 5)
                .forEach(p -> System.out.println(
                        "⚠ STOCK BAJO → " + p.getNombre() + " | stock actual: " + p.getStock()));
    }

    // ── Getters y Setters ─────────────────────────────────────────────────────

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }

    public FormaPago getFormaPago() { return formaPago; }
    public void setFormaPago(FormaPago formaPago) { this.formaPago = formaPago; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public List<DetallePedido> getDetalles() { return detalles; }
    public void setDetalles(List<DetallePedido> detalles) { this.detalles = detalles; }

    @Override
    public String toString() {
        return "Pedido{id=" + getId() +
               ", fecha=" + fecha +
               ", estado=" + estado +
               ", formaPago=" + formaPago +
               ", usuario=" + (usuario != null ? usuario.getNombre() + " " + usuario.getApellido() : "N/A") +
               ", total=$" + total + "}";
    }
}
