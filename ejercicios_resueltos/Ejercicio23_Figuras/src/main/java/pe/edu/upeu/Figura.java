package pe.edu.upeu;

public abstract class Figura {
    protected String color;


    public Figura(String color) {
        this.color = color;
    }


    public abstract double calcularArea();
    public abstract double calcularPerimetro();


    public String descripcion() {
        return "Color: " + color +
                " | Área: " + String.format("%.2f", calcularArea()) +
                " | Perímetro: " + String.format("%.2f", calcularPerimetro());
    }
}