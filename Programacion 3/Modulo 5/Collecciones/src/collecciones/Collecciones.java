/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package collecciones;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author ramiromoralesdev
 */
public class Collecciones {

    /**
     * @param args the command line arguments~~~~~
     */
    public static void main(String[] args) {
        Categoria bebidas = new Categoria("Bebidas", "Productos para tomar");
        Categoria comidas = new Categoria("Comidas", "Productos para comer");
        Categoria postres = new Categoria("Postres", "Productos dulces");

        Producto cafe = new Producto("Cafe", 1200.0, "Cafe molido", 50, "cafe.png", true, bebidas);
        Producto te = new Producto("Te", 900.0, "Te en saquitos", 80, "te.png", true, bebidas);
        Producto jugoNaranja = new Producto("Jugo Naranja", 1500.0, "Jugo natural", 40, "jugo.png", true, bebidas);
        Producto agua = new Producto("Agua", 700.0, "Agua sin gas", 100, "agua.png", true, bebidas);

        Producto hamburguesa = new Producto("Hamburguesa", 4500.0, "Hamburguesa completa", 20, "hamburguesa.png", true, comidas);
        Producto pizza = new Producto("Pizza", 5200.0, "Pizza muzzarella", 15, "pizza.png", true, comidas);
        Producto ensalada = new Producto("Ensalada", 3200.0, "Ensalada mixta", 30, "ensalada.png", true, comidas);

        Producto helado = new Producto("Helado", 2500.0, "Helado artesanal", 25, "helado.png", true, postres);
        Producto brownie = new Producto("Brownie", 1800.0, "Brownie con nuez", 35, "brownie.png", true, postres);
        Producto flan = new Producto("Flan", 1600.0, "Flan casero", 18, "flan.png", true, postres);

        Usuario usuario1 = new Usuario("Ramiro", "Morales", "ramiro@mail.com", "341543123", "1234", Rol.USUARIO);
        Usuario usuario2 = new Usuario("Belen", "Tores", "bt@mail.com", "3412345678", "abcd", Rol.USUARIO);

        Pedido pedido1 = new Pedido(LocalDate.now(), Estado.PENDIENTE, FormaPago.EFECTIVO);
        pedido1.addDetallePedido(2, cafe);
        pedido1.addDetallePedido(1, hamburguesa);
        pedido1.addDetallePedido(1, brownie);
        usuario1.addPedido(pedido1);

        Pedido pedido2 = new Pedido(LocalDate.now(), Estado.CONFIRMADO, FormaPago.TARJETA);
        pedido2.addDetallePedido(1, pizza);
        pedido2.addDetallePedido(2, agua);
        pedido2.addDetallePedido(1, helado);
        usuario1.addPedido(pedido2);

        Pedido pedido3 = new Pedido(LocalDate.now(), Estado.TERMINADO, FormaPago.TRANSFERENCIA);
        pedido3.addDetallePedido(2, te);
        pedido3.addDetallePedido(1, jugoNaranja);
        pedido3.addDetallePedido(1, ensalada);
        pedido3.addDetallePedido(1, flan);
        usuario2.addPedido(pedido3);

        // colección de productos
        List<Producto> productos = new java.util.ArrayList<>();
        productos.add(cafe);
        productos.add(te);
        productos.add(jugoNaranja);
        productos.add(agua);
        productos.add(hamburguesa);
        productos.add(pizza);
        productos.add(ensalada);
        productos.add(helado);
        productos.add(brownie);
        productos.add(flan);

        // colección de usuarios
        List<Usuario> usuarios = new java.util.ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);

        System.out.println(" UN PRODUCTO");
        System.out.println(cafe);

        System.out.println("LISTADO DE PRODUCTOS CARGADOS");
        for (Producto producto : productos) {
            System.out.println(producto);
        }

        System.out.println(" USUARIO CON MÁS PEDIDOS");
        Usuario usuarioMaxPedidos = usuarios.get(0);
        for (Usuario usuario : usuarios) {
            if (usuario.getPedidos().size() > usuarioMaxPedidos.getPedidos().size()) {
                usuarioMaxPedidos = usuario;
            }
        }
        System.out.println("Usuario: " + usuarioMaxPedidos);
        System.out.println("Pedidos:");
        for (Pedido pedido : usuarioMaxPedidos.getPedidos()) {
            System.out.println(pedido);
        }

        System.out.println(" COMPARACIÓN DE PRODUCTO");
        Producto cafeNuevo = new Producto("Cafe", 1500.0, "Cafe premium", 60, "cafe_premium.png", true, bebidas);
        System.out.println("Producto nuevo: " + cafeNuevo);
        System.out.println("\nComparando con toda la colección:");
        for (Producto producto : productos) {
            boolean esIgual = cafeNuevo.equals(producto);
            System.out.println(cafeNuevo.getNombre() + " = " + producto.getNombre() + "? " + esIgual);
        }
    }
    
}
