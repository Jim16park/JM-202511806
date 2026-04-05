package pe.edu.upeu;

public class CalculadoraImpuesto {
    protected String pais;


    public CalculadoraImpuesto(String pais) {
        this.pais = pais;
    }


    public double calcularImpuesto(double monto) {
        return 0;
    }


    public void mostrarResultado(double monto) {
        double impuesto = calcularImpuesto(monto);
        double total = monto + impuesto;

        System.out.println("País: " + pais);
        System.out.println("Monto: S/ " + monto);
        System.out.println("Impuesto: S/ " + impuesto);
        System.out.println("Total: S/ " + total);
    }
}