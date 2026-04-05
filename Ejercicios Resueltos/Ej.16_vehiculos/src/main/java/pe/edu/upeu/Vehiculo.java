package pe.edu.upeu;

public class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int capacidad;
    protected double consumoKmLitro;


    public Vehiculo(String marca, String modelo, int capacidad, double consumoKmLitro) {
        this.marca = marca;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.consumoKmLitro = consumoKmLitro;
    }


    public double costoViaje(double km, double precioLitro) {
        return (km / consumoKmLitro) * precioLitro;
    }


    public String descripcion() {
        return "Marca: " + marca +
                ", Modelo: " + modelo +
                ", Capacidad: " + capacidad +
                ", Consumo: " + consumoKmLitro + " km/l";
    }

    
    public int getCapacidad() {
        return capacidad;
    }
}