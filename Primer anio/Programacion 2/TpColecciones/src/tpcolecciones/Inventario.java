package tpcolecciones;

import java.util.ArrayList;
import java.util.Iterator;

public class Inventario {
    private ArrayList<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public void listarProductos() {
        for (Producto p : productos) {
            p.mostrarInfo();
        }
    }

    public Producto buscarProductoPorId(String id) {
        Producto productoEncontrado = null;
        Iterator<Producto> it = this.productos.iterator();
        while (it.hasNext() && productoEncontrado == null) {
            Producto a = it.next();
            if (a.getId().equalsIgnoreCase(id)) {
                productoEncontrado = a;
                a.mostrarInfo();
            }
        }
        return productoEncontrado;

    }
        public void buscarProductoPorCategoria(CategoriaProducto categoria) {
        for (Producto p : productos) {
            if (p.getCategoria().equals(categoria)) {
                p.mostrarInfo();
                return;
            }
        }
        System.out.println("No hay productos en esta categoría.");
    }

    public void eliminarProducto(String id) {
        productos.removeIf(p -> p.getId().equals(id));
    }

    public void actualizarStock(String id, int nuevaCantidad) {
        for (Producto p : productos) {
            // Valido el id con equals para acceder al elemento 
            if (p.getId().equals(id)) {
                p.setCantidad(nuevaCantidad);
                System.out.println("Stock actualizado. Nuevo valor: " + p.getCantidad());
            } else {

            }
        }
    }

    public void stockDisponible(String id) {
        for (Producto p : productos) {
            if (p.getId().equals(id)) {
                System.out.println("Stock disponible del producto: " + p.getId() + " es: " + p.getCantidad());
                return;
            }
        }
        System.out.println("Producto no encontrado.");
        
    }


    public void productoMayorStock() {
        Producto mayor = productos.get(0); // arranco con el primero
        for (Producto p : productos) { // For each recorre todos los elementos, no necesita contador para incrementar 
            if (p.getCantidad() > mayor.getCantidad()) {
                mayor = p;
            }
        }
    
        System.out.println("El producto con mayor stock es: " 
            + mayor.getNombre() + " con " + mayor.getCantidad() + " unidades.");
    }
    

    public void filtrarProductosPrecios(int min, int max) {
        for (Producto p : productos) {
            if (p.getPrecio() >= min && p.getPrecio() <= max) {
                p.mostrarInfo();
            }
        }
}

    
}


