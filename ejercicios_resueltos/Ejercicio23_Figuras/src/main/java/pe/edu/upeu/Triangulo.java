package pe.edu.upeu;

public class Triangulo extends Figura {
    private double lado1;
    private double lado2;
    private double lado3;
    private double altura;
    private double base;


    public Triangulo(String color, double lado1, double lado2, double lado3, double base, double altura) {
        super(color);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return (base * altura) / 2;
    }

    @Override
    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }


    public static void main(String[] args) {
        Circulo circulo = new Circulo("Rojo", 5);
        Rectangulo rectangulo = new Rectangulo("Azul", 4, 6);
        Triangulo triangulo = new Triangulo("Verde", 3, 4, 5, 4, 3);

        System.out.println("=== CÍRCULO ===");
        System.out.println(circulo.descripcion());

        System.out.println("\n=== RECTÁNGULO ===");
        System.out.println(rectangulo.descripcion());

        System.out.println("\n=== TRIÁNGULO ===");
        System.out.println(triangulo.descripcion());

        // Esto da error si lo descomentas:
        // Figura f = new Figura("Negro"); // ERROR
    }
}