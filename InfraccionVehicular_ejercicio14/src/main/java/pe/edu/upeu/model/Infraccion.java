package pe.edu.upeu.model;

public class Infraccion {

    private String placa;
    private String infractor;
    private String fecha;
    private String tipo;
    private double monto;
    private String estado;

    public Infraccion(String placa, String infractor, String fecha,
                      String tipo, double monto, String estado) {
        this.placa = placa;
        this.infractor = infractor;
        this.fecha = fecha;
        this.tipo = tipo;
        this.monto = monto;
        this.estado = estado;
    }

    public String getPlaca() { return placa; }
    public String getInfractor() { return infractor; }
    public String getFecha() { return fecha; }
    public String getTipo() { return tipo; }
    public double getMonto() { return monto; }
    public String getEstado() { return estado; }

    public void setEstado(String estado) {
        this.estado = estado != null ? estado : "Pendiente";
    }
}