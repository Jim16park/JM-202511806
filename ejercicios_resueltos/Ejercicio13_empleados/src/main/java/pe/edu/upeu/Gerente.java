package pe.edu.upeu;

public class Gerente extends Empleado {
    private double bonoGerencial;
    private int empleadosACargo;


    public Gerente(String nombre, String id, double salarioBase, double bonoGerencial, int empleadosACargo) {
        super(nombre, id, salarioBase);
        this.bonoGerencial = bonoGerencial;
        this.empleadosACargo = empleadosACargo;
    }


    @Override
    public double calcularSalario() {
        return super.calcularSalario() + bonoGerencial;
    }


    @Override
    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + id);
        System.out.println("Empleados a cargo: " + empleadosACargo);
        System.out.println("Salario: S/ " + calcularSalario());
    }


    public static void main(String[] args) {
        EmpleadoFijo fijo = new EmpleadoFijo("Jimena Lupaca", "E001", 2500, 500);
        EmpleadoTemporal temporal = new EmpleadoTemporal("Ana Torres", "E002", 1000, 40, 20);
        Gerente gerente = new Gerente("Carlos Pérez", "G001", 4000, 1500, 10);

        System.out.println("=== EMPLEADO FIJO ===");
        fijo.mostrarDatos();

        System.out.println("\n=== EMPLEADO TEMPORAL ===");
        temporal.mostrarDatos();

        System.out.println("\n=== GERENTE ===");
        gerente.mostrarDatos();
    }
}