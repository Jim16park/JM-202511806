package pe.edu.upeu;

import java.util.ArrayList;

public class ImpuestoUSA extends CalculadoraImpuesto {
    private double salesTax;


    public ImpuestoUSA(double salesTax) {
        super("USA");
        this.salesTax = salesTax;
    }

    @Override
    public double calcularImpuesto(double monto) {
        return monto * salesTax;
    }

    public static void main(String[] args) {
        ArrayList<CalculadoraImpuesto> calculadoras = new ArrayList<>();

        calculadoras.add(new ImpuestoMexico());
        calculadoras.add(new ImpuestoEspana());
        calculadoras.add(new ImpuestoUSA(0.08)); // 8% de Sales Tax

        double montoFactura = 1000;

        System.out.println("=== CÁLCULO DE IMPUESTOS POR PAÍS ===\n");

        for (CalculadoraImpuesto c : calculadoras) {
            c.mostrarResultado(montoFactura);
            System.out.println("----------------------------------");
        }
    }
}