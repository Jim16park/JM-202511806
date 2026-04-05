package pe.edu.upeu;

public class Medicion {
    private double peso;
    private double altura;
    private String fecha;


    public Medicion(double peso, double altura, String fecha) {
        this.peso = peso;
        this.altura = altura;
        this.fecha = fecha;
    }


    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public String getFecha() {
        return fecha;
    }
}