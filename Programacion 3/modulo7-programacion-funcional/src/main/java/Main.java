import enums.Estado;
import enums.FormaPago;
import enums.Rol;
import entities.*;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Categoria electronica  = new Categoria(1L, "Electrónica",  "Dispositivos y accesorios electrónicos");
        Categoria ropa         = new Categoria(2L, "Ropa",         "Indumentaria");
        Categoria alimentos    = new Categoria(3L, "Alimentos",    "Productos alimenticios");


        Producto p1 = new Producto(1L, "Auriculares Bluetooth",  4500.00, "Auriculares inalámbricos",    10, "auriculares.jpg", true,  electronica);
        Producto p2 = new Producto(2L, "Cargador USB-C",        1200.00, "Cargador rápido 65W",          3, "cargador.jpg",    true,  electronica);  // stock bajo
        Producto p3 = new Producto(3L, "Remera Oversize",       2800.00, "talle único",     2, "remera.jpg",      false, ropa);          // no disponible + stock bajo
        Producto p4 = new Producto(4L, "Zapatillas Running",   15000.00, "Calzado deportivo amortiguada",           20, "zapatillas.jpg",  true,  ropa);
        Producto p5 = new Producto(5L, "Barra de Cereal",        350.00, "Sabor vainilla",  15, "cereal.jpg",      false, alimentos);    // no disponible

        List<Producto> catalogo = List.of(p1, p2, p3, p4, p5);

        
        Usuario usuario = new Usuario(
                1L, "Ramiro", "Morales",
                "ramiro@mail.com", "3512000000",
                "pass123", Rol.USUARIO
        );

        
        DetallePedido d1 = new DetallePedido(1L, 2, p1);  // 2 × $4500  = $9000
        DetallePedido d2 = new DetallePedido(2L, 1, p4);  // 1 × $15000 = $15000
        DetallePedido d3 = new DetallePedido(3L, 3, p2);  // 3 × $1200  = $3600

        List<DetallePedido> detalles = List.of(d1, d2, d3);

        
        Pedido pedido = new Pedido(
                1L,
                LocalDate.of(2026, 5, 17),
                Estado.PENDIENTE,
                FormaPago.TRANSFERENCIA,
                usuario,
                detalles
        );

        // PUNTO 1 — calcularTotal()
        // Stream: mapToDouble (INTERMEDIA) + sum (TERMINAL)

        System.out.println(" PUNTO 1 - calcularTotal()");
        System.out.println("");
        System.out.println("Detalles del pedido:");
        detalles.forEach(d -> System.out.println("  " + d));
        pedido.calcularTotal();
        System.out.printf("Total calculado: $%.2f%n", pedido.getTotal());

    
        // PUNTO 2 — mostrarProductosDisponibles()
        // Stream: filter (INTERMEDIA) + forEach (TERMINAL)

        System.out.println(" PUNTO 2 - mostrarProductosDisponibles()");
        System.out.println("");
        pedido.mostrarProductosDisponibles(catalogo);

      
        // PUNTO 3 — contarItems()
        // Stream: mapToInt (INTERMEDIA) + sum (TERMINAL)

        System.out.println(" PUNTO 3 - contarItems()");
        System.out.println("");
        pedido.contarItems();

        // PUNTO 4 — detectarStockBajo()
        // Stream: filter (INTERMEDIA) + forEach (TERMINAL)

        System.out.println(" PUNTO 4 - detectarStockBajo()");
        System.out.println("");
        pedido.detectarStockBajo(catalogo);

        System.out.println("\n");
        System.out.println(" Resumen del pedido");
        System.out.println("");
        System.out.println(pedido);
    }
}
