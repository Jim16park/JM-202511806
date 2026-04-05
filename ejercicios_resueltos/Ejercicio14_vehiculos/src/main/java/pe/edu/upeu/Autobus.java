package pe.edu.upeu;

public class Autobus extends Vehiculo {
    private int pisos;


    public Autobus(String marca, String modelo, double consumoKmLitro, int pisos) {
        super(marca, modelo, pisos * 40, consumoKmLitro); // capacidad calculada
        this.pisos = pisos;
    }

    @Override
    public String descripcion() {
        return super.descripcion() + ", Pisos: " + pisos;
    }
}