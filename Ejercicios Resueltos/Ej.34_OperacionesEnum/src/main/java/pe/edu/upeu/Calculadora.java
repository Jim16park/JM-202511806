package pe.edu.upeu;

import java.util.Scanner;

public class Calculadora {

    public static double operar(double a, double b, Operacion op) {
        return op.calcular(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== CALCULADORA ===");

        System.out.print("Ingrese número 1: ");
        double a = sc.nextDouble();

        System.out.print("Ingrese número 2: ");
        double b = sc.nextDouble();

        System.out.println("\nSeleccione operación:");
        System.out.println("1. SUMA");
        System.out.println("2. RESTA");
        System.out.println("3. MULTIPLICACION");
        System.out.println("4. DIVISION");

        int opcion = sc.nextInt();

        Operacion op;

        switch (opcion) {
            case 1:
                op = Operacion.SUMA;
                break;
            case 2:
                op = Operacion.RESTA;
                break;
            case 3:
                op = Operacion.MULTIPLICACION;
                break;
            case 4:
                op = Operacion.DIVISION;
                break;
            default:
                System.out.println("Opción inválida");
                return;
        }

        try {
            double resultado = operar(a, b, op);
            System.out.println("\nResultado: " + resultado + " (" + op.getSimbolo() + ")");
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}