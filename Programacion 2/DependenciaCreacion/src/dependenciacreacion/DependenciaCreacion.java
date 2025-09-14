/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dependenciacreacion;

/**
 *
 * @author ramam
 */
public class DependenciaCreacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Ejercicio 13
        Usuario usuario = new Usuario("Ramiro", "ejemplo@email.com");
        GeneradorQR generador = new GeneradorQR();

        CodigoQr qr = generador.generar("QRCODE12345", usuario);

        System.out.println("QR generado: " + qr.getValor() +
                " para el usuario " + qr.getUsuario().getNombre());

        
        // Ejercicio 14 

        Proyecto proyecto = new Proyecto("Proyecto Programacion", 90);
        EditorVideo editor = new EditorVideo();

        Render render = editor.exportar("MP4", proyecto);

        System.out.println("Render exportado en formato: " + render.getFormato() +
                " para el proyecto " + render.getProyecto().getNombre());

    }
    
}
