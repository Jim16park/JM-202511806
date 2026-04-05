package pe.edu.upeu;

public class EmpleadoTemporal extends Empleado {
    private int horasTrabajadas;
    private double tarifaHora;


    public EmpleadoTemporal(String nombre, String id, double salarioBase, int horasTrabajadas, double tarifaHora) {
        super(nombre, id, salarioBase);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaHora = tarifaHora;
    }


    @Override
    public double calcularSalario() {
        return super.calcularSalario() + (horasTrabajadas * tarifaHora);
    }
}
