package pe.edu.upeu;

public class Empleado {
    protected String nombre;
    protected String id;
    protected double salarioBase;


    public Empleado(String nombre, String id, double salarioBase) {
        this.nombre = nombre;
        this.id = id;
        this.salarioBase = salarioBase;
    }


    public double calcularSalario() {
        return salarioBase;
    }


    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + id);
        System.out.println("Salario: S/ " + calcularSalario());
    }
}