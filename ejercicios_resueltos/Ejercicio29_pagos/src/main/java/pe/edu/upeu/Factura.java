package pe.edu.upeu;

public class Factura implements Pagable, Imprimible, Exportable {
    private String cliente;
    private double subtotal;
    private double impuesto;
    private boolean pagada;
    private String formatoExportacion;


    public Factura(String cliente, double subtotal, double impuesto) {
        this.cliente = cliente;
        this.subtotal = subtotal;
        this.impuesto = impuesto;
        this.pagada = false;
        this.formatoExportacion = "PDF";
    }

    @Override
    public double calcularMonto() {
        return subtotal + impuesto;
    }

    @Override
    public boolean procesarPago() {
        if (!pagada) {
            pagada = true;
            System.out.println("Pago procesado correctamente.");
            return true;
        } else {
            System.out.println("La factura ya fue pagada.");
            return false;
        }
    }


    @Override
    public void imprimir() {
        System.out.println("\n=== FACTURA IMPRESA ===");
        System.out.println(formatear());
    }

    @Override
    public String formatear() {
        return "Cliente: " + cliente +
                "\nSubtotal: S/ " + subtotal +
                "\nImpuesto: S/ " + impuesto +
                "\nTotal: S/ " + calcularMonto() +
                "\nEstado: " + (pagada ? "Pagada" : "Pendiente");
    }

    @Override
    public String exportar(String formato) {
        this.formatoExportacion = formato.toUpperCase();
        return "Factura exportada en formato " + formatoExportacion;
    }

    @Override
    public String getFormato() {
        return formatoExportacion;
    }

    public static void main(String[] args) {
        Factura factura = new Factura("Jimena Lupaca", 500, 90);


        Pagable p = factura;
        System.out.println("Monto total a pagar: S/ " + p.calcularMonto());
        p.procesarPago();


        Imprimible i = factura;
        i.imprimir();


        Exportable e = factura;
        System.out.println(e.exportar("pdf"));
        System.out.println("Formato actual: " + e.getFormato());
    }
}