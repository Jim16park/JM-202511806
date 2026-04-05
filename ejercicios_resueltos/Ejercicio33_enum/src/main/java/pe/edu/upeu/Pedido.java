package pe.edu.upeu;

public class Pedido {
    private int idPedido;
    private String cliente;
    private EstadoPedido estado;


    public Pedido(int idPedido, String cliente) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.estado = EstadoPedido.PENDIENTE; // estado inicial
    }


    public void mostrarPedido() {
        System.out.println("\n=== DATOS DEL PEDIDO ===");
        System.out.println("ID Pedido: " + idPedido);
        System.out.println("Cliente: " + cliente);
        System.out.println("Estado: " + estado);
        System.out.println("Descripción: " + estado.getDescripcion());
        System.out.println("Color: " + estado.getColor());
    }


    public void cambiarEstado(EstadoPedido nuevoEstado) {
        if (estado.puedeTransicionarA(nuevoEstado)) {
            System.out.println("Estado cambiado de " + estado + " a " + nuevoEstado);
            estado = nuevoEstado;
        } else {
            System.out.println("No se puede cambiar de " + estado + " a " + nuevoEstado);
        }
    }

    public static void main(String[] args) {
        Pedido pedido1 = new Pedido(101, "Jimena Lupaca");

        pedido1.mostrarPedido();

        pedido1.cambiarEstado(EstadoPedido.CONFIRMADO);
        pedido1.mostrarPedido();

        pedido1.cambiarEstado(EstadoPedido.EN_PREPARACION);
        pedido1.mostrarPedido();

        pedido1.cambiarEstado(EstadoPedido.ENVIADO);
        pedido1.mostrarPedido();

        pedido1.cambiarEstado(EstadoPedido.ENTREGADO);
        pedido1.mostrarPedido();


        pedido1.cambiarEstado(EstadoPedido.CANCELADO);
    }
}