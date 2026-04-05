package pe.edu.upeu;

import java.util.ArrayList;

public class Paciente {
    private String nombre;
    private int edad;
    private ArrayList<Medicion> historial = new ArrayList<>();


    public Paciente(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }


    public void registrarMedicion(Medicion medicion) {
        historial.add(medicion);
        System.out.println("Medición registrada para " + nombre + " en la fecha: " + medicion.getFecha());
    }


    public double calcularIMC(Medicion medicion) {
        return medicion.getPeso() / Math.pow(medicion.getAltura(), 2);
    }

    public double calcularIMCActual() {
        if (historial.isEmpty()) {
            return 0;
        }
        Medicion ultima = historial.get(historial.size() - 1);
        return calcularIMC(ultima);
    }


    public String clasificarIMC(double imc) {
        if (imc < 18.5) return "Bajo peso";
        if (imc < 25.0) return "Normal";
        if (imc < 30.0) return "Sobrepeso";
        return "Obesidad";
    }


    public void generarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("No hay mediciones registradas.");
            return;
        }

        System.out.println("\n--- HISTORIAL DE MEDICIONES DE " + nombre + " ---");
        for (Medicion m : historial) {
            double imc = calcularIMC(m);
            System.out.println("Fecha: " + m.getFecha() +
                    " | Peso: " + m.getPeso() + " kg" +
                    " | Altura: " + m.getAltura() + " m" +
                    " | IMC: " + String.format("%.2f", imc) +
                    " | Clasificación: " + clasificarIMC(imc));
        }
    }


    public String determinarTendencia() {
        if (historial.size() < 2) {
            return "No hay suficientes mediciones para determinar tendencia.";
        }

        Medicion primera = historial.get(0);
        Medicion ultima = historial.get(historial.size() - 1);

        double imcInicial = calcularIMC(primera);
        double imcFinal = calcularIMC(ultima);

        if (imcFinal < imcInicial) {
            return "Mejorando (el IMC ha disminuido).";
        } else if (imcFinal > imcInicial) {
            return "Empeorando (el IMC ha aumentado).";
        } else {
            return "Estable (el IMC se mantiene igual).";
        }
    }


    public void mostrarDatosPaciente() {
        System.out.println("\n--- DATOS DEL PACIENTE ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
    }


    public static void main(String[] args) {
        Paciente paciente1 = new Paciente("Jimena Lupaca", 18);

        paciente1.registrarMedicion(new Medicion(70, 1.60, "01/04/2026"));
        paciente1.registrarMedicion(new Medicion(68, 1.60, "15/04/2026"));
        paciente1.registrarMedicion(new Medicion(66, 1.60, "30/04/2026"));

        paciente1.mostrarDatosPaciente();

        double imcActual = paciente1.calcularIMCActual();
        System.out.println("\nIMC actual: " + String.format("%.2f", imcActual));
        System.out.println("Clasificación actual: " + paciente1.clasificarIMC(imcActual));

        paciente1.generarHistorial();

        System.out.println("\nTendencia: " + paciente1.determinarTendencia());
    }
}