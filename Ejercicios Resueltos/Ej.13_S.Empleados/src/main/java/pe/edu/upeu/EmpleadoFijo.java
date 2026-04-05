package pe.edu.upeu;

public class EmpleadoFijo extends Empleado {
    private double bonificacion;


    public EmpleadoFijo(String nombre, String id, double salarioBase, double bonificacion) {
        super(nombre, id, salarioBase);
        this.bonificacion = bonificacion;
    }


    @Override
    public double calcularSalario() {
        return super.calcularSalario() + bonificacion;
    }
}