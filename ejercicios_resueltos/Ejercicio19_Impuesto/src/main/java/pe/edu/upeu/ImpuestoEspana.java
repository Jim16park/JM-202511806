package pe.edu.upeu;

public class ImpuestoEspana extends CalculadoraImpuesto {


    public ImpuestoEspana() {
        super("España");
    }

    @Override
    public double calcularImpuesto(double monto) {
        return monto * 0.21;
    }
}