package pe.edu.upeu;

public class ImpuestoMexico extends CalculadoraImpuesto {


    public ImpuestoMexico() {
        super("México");
    }

    @Override
    public double calcularImpuesto(double monto) {
        return monto * 0.16;
    }
}