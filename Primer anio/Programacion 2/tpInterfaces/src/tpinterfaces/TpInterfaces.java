package tpinterfaces;

/**
 *
 * @author ramiromoralesdev
 */
public class TpInterfaces {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Ramiro", "ramiro@gmail.com");
        

        Producto p1 = new Producto("Mouse", 2500);
        Producto p2 = new Producto("Teclado", 4800);
        Producto p3 = new Producto("Monitor", 75000);

        Pedido pedido = new Pedido(cliente);
        pedido.agregarProducto(p1);
        pedido.agregarProducto(p2);
        pedido.agregarProducto(p3);

        System.out.println("Total del pedido: $" + pedido.calcularTotal());

        // Cambiar estados y observar notificaciones
        pedido.cambiarEstado(Pedido.Estado.PAGADO);
        pedido.cambiarEstado(Pedido.Estado.ENVIADO);
        pedido.cambiarEstado(Pedido.Estado.ENTREGADO);
    }

    
}
