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
        Bibloteca bibloteca = new Bibloteca("Biblioteca");


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




        // Instancio libros
        System.out.println("------------------");
        System.out.println("-----LIBROS-----");

        Libro l1 = new Libro("1", "Piense y Hagase Rico", 2000, new Autor("10", "Napoleon Hill", "Estadounidense"));
        Libro l2 = new Libro("2", "El Conde de Monte Cristo", 1846, new Autor("11", "Alexandre Dumas", "Frances")); 
        Libro l3 = new Libro("3", "MalaSangre", 2023, new Autor("12", "Giselle Kruger", "Argentina"));
        Libro l4 = new Libro("4", "El Principito", 2000, new Autor("13", "Antoine de Saint-Exupery", "Frances"));

        bibloteca.agregarLibro(l1);
        bibloteca.agregarLibro(l2);
        bibloteca.agregarLibro(l3);
        bibloteca.agregarLibro(l4);

        System.out.println("-----LISTAR LIBROS-----");
        bibloteca.listarLibros();

        System.out.println("-----BUSCAR LIBRO POR ISBN-----");
        bibloteca.buscarLibroPorId("1");

        System.out.println("-----ELIMINAR LIBRO POR ISBN-----");
        bibloteca.eliminarLibro("1"); // Falta obtener indices

        System.out.println("-----OBTENER CANTIDAD DE LIBROS-----");
        bibloteca.obtenerCantidadLibros();

        System.out.println("-----FILTRAR LIBROS POR AÑO-----");
        bibloteca.filtarLibrosPorAnio(2000);
        
        System.out.println("-----MOSTRAR AUTORES DISPONIBLES-----");
        bibloteca.mostrarAutoresDisponibles();

    
}
}
