package tpcolecciones;

public class Producto {
    private String id;
    private String nombre;
    private double precio;
    private int cantidad;
    CategoriaProducto categoria;

    public Producto(String id, String nombre, double precio, int cantidad, CategoriaProducto categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    public void mostrarInfo() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Categoría: " + categoria.getDescripcion() // Muestro la descripcion del enum
        );
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public CategoriaProducto getCategoria() {
        return categoria;
    }

    // Setter para actualizar stock
    public int setCantidad(int nuevaCantidad) {
        return this.cantidad = nuevaCantidad;
    }

}
