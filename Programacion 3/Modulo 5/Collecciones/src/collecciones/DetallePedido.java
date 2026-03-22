/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collecciones;

import java.util.Objects;

/**
 *
 * @author ramiromoralesdev
 */
public class DetallePedido {
    private int cantidad;
    private Double subtotal;
    private Producto producto;

    public DetallePedido(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
        calcularSubtotal();
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        calcularSubtotal();
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
        calcularSubtotal();
    }

    public void calcularSubtotal() {
        if (producto == null || producto.getPrecio() == null) {
            this.subtotal = 0.0;
        } else {
            this.subtotal = cantidad * producto.getPrecio();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DetallePedido)) {
            return false;
        }
        DetallePedido that = (DetallePedido) o;
        return Objects.equals(producto, that.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producto);
    }

    @Override
    public String toString() {
        String nombreProducto = producto != null ? producto.getNombre() : "sin producto";
        return "DetallePedido{" + "cantidad=" + cantidad + ", subtotal=" + subtotal + ", producto='" + nombreProducto + '\'' + '}';
    }
}
