package tpcolecciones;

import java.util.ArrayList;

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

    public void buscarProductoPorId(String id) {
        // Tambien se puede usar while para no recorrer todo el array si ya se encontro, tengo que ver como era
        for (Producto p : productos) {
            if (p.getId().equals(id)) {
                p.mostrarInfo();
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

        public void buscarProductoPorCategoria(CategoriaProducto categoria) {
        // Tambien se puede usar while para no recorrer todo el array si ya se encontro, tengo que ver como era
        for (Producto p : productos) {
            if (p.getId().equals(categoria)) {
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
            // Con foreach recorro todo el array, actualiza el stock pero sigue recorriendo hasta el final. Con while para al encontrar elemento 
            // Valido el id con equals para acceder al elemento 
            if (p.getId().equals(id)) {
                p.setCantidad(nuevaCantidad);
                System.out.println("Stock actualizado.");
            } else {
                System.out.println("Producto no encontrado.");
            }
        }
        System.out.println("Producto no encontrado.");
    }


    public void productoMayorStock() {;
    for (i = 0; i < productos.size(); i++) {
        if (p.getCantidad() > i.getCantidad()) {
            productoMayorStock = p;
            System.out.println("Producto con mayor stock:" + p);
        }
    }
}

    public void filtrarProductosPrecios(int min, int max) {
        for (Producto p : productos) {
            if (p.getPrecio() >= min && p.getPrecio() <= max) {
                p.mostrarInfo();
            }
        }
}

    
}


