/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package relaciones1a1;

/**
 *
 * @author ramam
 */
public class mainRelaciones {
    
        public static void main(String[] args) {

      // Ejercicio 1 Pasaporte, Persona, Foto
        Persona persona = new Persona("Ramiro Morales", "46998595");
        Foto foto = new Foto("ramiro_foto.png", "png");
        Pasaporte pasaporte = new Pasaporte("A1234567", "14/09/2025", foto, persona);

        // Verificamos relación bidireccional. Imprimimos pasaporte y persona
        System.out.println("\nEl pasaporte pertenece a: " + pasaporte.getPersona().getNombre());
        System.out.println("La persona tiene pasaporte número: " + persona.getPasaporte().getNumero());

        // Ejercicio 2 Usuario, Celular, Bateria
        Bateria bateria = new Bateria("Li-Ion", 4000);
        Usuario usuario = new Usuario("Ramiro Morales", "46998595");
        Celular celular = new Celular("112233", "Iphone", "16", bateria, usuario);

        // Verificamos relación bidireccional. Imprimimos usuario y celular
        System.out.println("\nEl celular pertenece a: " + celular.getUsuario().getNombre());
        System.out.println("El usuario tiene el celular: " + celular.getMarca() + celular.getModelo());


        // Ejercicio 3 Libro, Autor, Editorial
        Autor autor = new Autor("Gabriel Garcia Marquez", "Colombiano");
        Editorial editorial = new Editorial("Sudamericana", "Buenos Aires, Argentina");
        Libro libro = new Libro("Cien Años de Soledad", "978-3-16-148410-0", editorial);

        // Verificamos relación bidireccional. Imprimimos libro y editorial
        System.out.println("\nEl libro pertenece a: " + libro.getEditorial().getNombre());
        System.out.println("La editorial tiene el libro: " + libro.getTitulo());


        // Ejercicio 4 Cliente, TarjetaDeCredito 
        Cliente cliente = new Cliente("Ramiro Morales", "46998595");
        Banco banco = new Banco("Banco Nación", "30-12345678-9", null);
        TarjetaCredito tarjetaCredito = new TarjetaCredito("1234-5678-9012-3456", "12/25", cliente, banco);

        // Verificamos relación bidireccional. Imprimimos cliente y tarjeta de crédito
        System.out.println("\nLa tarjeta de crédito pertenece a: " + tarjetaCredito.cliente.getNombre());


        // Ejercicio 5 Computadora, PlacaMadre, Propietario
        Propietario propietario = new Propietario("Ramiro Morales", "46998595");
        PlacaMadre placaMadre = new PlacaMadre("ASUS", "Z490");
        Computadora computadora = new Computadora("Dell", "SN123456", placaMadre, propietario);

        // Verificamos relación bidireccional. Imprimimos propietario y computadora
        System.out.println("\nLa computadora pertenece a: " + computadora.getPropietario().getNombre());

        
        // Ejercicio 6 Reserva, Cliente, Mesa

        ClienteRestorant clienteRestorant = new ClienteRestorant("Ramiro Morales", "46998595");
        Mesa mesa = new Mesa(5, 4);
        Reserva reserva = new Reserva("14/09/2023", "20:00", clienteRestorant, mesa);

        // Verificamos relación bidireccional. Imprimimos reserva y mesa
        System.out.println("\nLa mesa pertenece a: " + reserva.getCliente().getNombre());
        System.out.println("El cliente tiene la reserva para la mesa número: " + reserva.getMesa().getNumero());

        // Ejercicio 7 Vehiculo, Motor, Propietario

        Motor motor = new Motor("V8", "SN123456");
        Conductor conductor = new Conductor("Ramiro Morales", "LIC123456");
        Vehiculo vehiculo = new Vehiculo("ABC123", "Audi", motor, conductor);

        // Verificamos relación bidireccional. Imprimimos vehiculo y conductor
        System.out.println("\nEl vehiculo pertenece a: " + vehiculo.getConductor().getNombre());
        System.out.println("El conductor tiene el vehiculo: " + vehiculo.getModelo());

        // Ejercicio 8 Documento, FirmaDigital, Usuario
        UsuarioDoc usuarioDoc = new UsuarioDoc("Ramiro Morales", "46998595");
        FirmaDigital firmaDigital = new FirmaDigital("abc123hash", "14/09/2023", usuarioDoc);
        Documento documento = new Documento("Contrato de Alquiler", "Contenido del contrato...", firmaDigital);

        // Verificamos relación bidireccional. Imprimimos documento y firma digital
        System.out.println("\nEl documento pertenece a: " + documento.getFirmaDigital().getUsuarioDoc().getNombre());
        System.out.println("La firma digital pertenece al documento: " + documento.getTitulo());


        // Ejercicio 9 CitaMedica, Paciente, Profesional
        Paciente paciente = new Paciente("Ramiro Morales", "OSDE");
        Profesional profesional = new Profesional("Dr. Juan Perez", "Cardiología");
        CitaMedica citaMedica = new CitaMedica("15/09/2023", "10:00", paciente, profesional);

        // Verificamos relación bidireccional. Imprimimos cita médica, paciente y profesional
        System.out.println("\nLa cita médica es para: " + citaMedica.getPaciente().getNombre());
        System.out.println("El profesional a cargo es: " + citaMedica.getProfesional().getNombre());


       // Ejercicio 10 CuentaBancaria, ClaveSeguridad, Titular
        Titular titular = new Titular("Ramiro Morales", "46998595");
        ClaveSeguridad claveSeguridad = new ClaveSeguridad("abc123", "14/09/2023");
        CuentaBancaria cuentaBancaria = new CuentaBancaria("1234567890", 1000.0, titular, claveSeguridad);

        // Verificamos relación bidireccional. Imprimimos cuenta bancaria y titular
        System.out.println("\nLa cuenta bancaria pertenece a: " + cuentaBancaria.getTitular().getNombre());
        System.out.println("El titular tiene la cuenta número: " + cuentaBancaria.getCBU());

    }
}