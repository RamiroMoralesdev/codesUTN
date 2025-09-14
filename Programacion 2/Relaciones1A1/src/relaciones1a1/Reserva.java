package relaciones1a1;

public class Reserva {
    private String fecha;
    private String hora;
    private ClienteRestorant cliente;
    private Mesa mesa;

    public Reserva(String fecha, String hora, ClienteRestorant cliente, Mesa mesa) {
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        this.mesa = mesa;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public ClienteRestorant getCliente() {
        return cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }
}
