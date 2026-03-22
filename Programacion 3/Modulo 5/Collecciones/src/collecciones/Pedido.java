/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collecciones;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author ramiromoralesdev
 */
public class Pedido implements calculable {
    private LocalDate fecha;
    private Estado estado;
    private Double total;
    private FormaPago formaPago;
    private Set<DetallePedido> detallesPedido;  // Bidireccional

    public Pedido(LocalDate fecha, Estado estado, FormaPago formaPago) {
        this.fecha = fecha;
        this.estado = estado;
        this.formaPago = formaPago;
        this.total = 0.0;
        this.detallesPedido = new HashSet<>();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Double getTotal() {
        return total;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Set<DetallePedido> getDetallesPedido() {
        return Collections.unmodifiableSet(detallesPedido);
    }

    public void addDetallePedido(int cantidad, Producto producto) {
        if (cantidad <= 0 || producto == null) {
            return;
        }

        DetallePedido detalleExistente = findDetallePedidoByProducto(producto);
        if (detalleExistente != null) {
            detalleExistente.setCantidad(detalleExistente.getCantidad() + cantidad);
        } else {
            detallesPedido.add(new DetallePedido(cantidad, producto));
        }
        calcularTotal();
    }

    public DetallePedido findDetallePedidoByProducto(Producto producto) {
        for (DetallePedido detalle : detallesPedido) {
            if (detalle.getProducto().equals(producto)) {
                return detalle;
            }
        }
        return null;
    }

    public void deleteDetallePedidoByProducto(Producto producto) {
        DetallePedido detalle = findDetallePedidoByProducto(producto);
        if (detalle != null) {
            detallesPedido.remove(detalle);
            calcularTotal();
        }
    }

    @Override
    public void calcularTotal() {
        double acumulado = 0.0;
        for (DetallePedido detalle : detallesPedido) {
            acumulado += detalle.getSubtotal();
        }
        this.total = acumulado;
    }

    @Override
    public String toString() {
        return "Pedido{" + "fecha=" + fecha + ", estado=" + estado + ", total=" + total + ", formaPago=" + formaPago + ", cantidadDetalles=" + detallesPedido.size() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pedido)) {
            return false;
        }
        Pedido pedido = (Pedido) o;
        return Objects.equals(fecha, pedido.fecha) && estado == pedido.estado && Objects.equals(total, pedido.total) && formaPago == pedido.formaPago;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha, estado, total, formaPago);
    }
}


