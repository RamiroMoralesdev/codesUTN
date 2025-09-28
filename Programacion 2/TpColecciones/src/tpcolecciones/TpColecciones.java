/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tpcolecciones;

/**
 *
 * @author ramam
 */
public class TpColecciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Inventario inventario = new Inventario(); // Crear instancia de Inventario. Inventario tiene el ArrayList

        // Instancio los productos
        Producto p1 = new Producto("001", "Manzanas", 200, 100, CategoriaProducto.ALIMENTOS);
        Producto p2 = new Producto("002", "Televisor", 100000, 50, CategoriaProducto.ELECTRONICA);
        Producto p3 = new Producto("003", "Camisa", 5000, 200, CategoriaProducto.ROPA);
        Producto p4 = new Producto("004", "Sofá", 200000, 2, CategoriaProducto.HOGAR);
        Producto p5 = new Producto("005", "Computadora", 800000, 100, CategoriaProducto.ELECTRONICA);
        Producto p6 = new Producto("006", "Arroz", 1000, 10, CategoriaProducto.ALIMENTOS);

        // Agrego los productos al inventario 
        inventario.agregarProducto(p1);
        inventario.agregarProducto(p2);
        inventario.agregarProducto(p3);
        inventario.agregarProducto(p4);
        inventario.agregarProducto(p5);
        inventario.agregarProducto(p6);

        inventario.listarProductos(); 

        System.out.println("-----BUSCAR PRODUCTO POR ID-----");
        inventario.buscarProductoPorId("004");

        System.out.println("-----BUSCAR PRODUCTO POR CATEGORIA-----");
        inventario.buscarProductoPorCategoria(CategoriaProducto.ELECTRONICA);

        System.out.println("------ELIMINAR PRODUCTO------");
        inventario.eliminarProducto("003");
        inventario.listarProductos();


        System.out.println("------ACTUALIZAR STOCK------");
        inventario.actualizarStock("002", 100);

        System.out.println("------STOCK DISPONIBLE DEL PRODUCTO ------");
        inventario.stockDisponible("005");

        System.out.println("------PRODUCTO CON MAYOR STOCK------");
        inventario.productoMayorStock(); 

        System.out.println("------FILTRAR PRODUCTOS POR PRECIO------");
        inventario.filtrarProductosPrecios(1000, 3000);

        System.out.println("------CATEGORIAS DISPONIBLES------");
        CategoriaProducto.mostrarCategorias();

    
}
}
