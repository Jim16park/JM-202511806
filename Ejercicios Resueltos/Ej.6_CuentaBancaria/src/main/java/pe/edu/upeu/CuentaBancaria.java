package pe.edu.upeu;

import java.util.ArrayList;

public class CuentaBancaria {
    private String titular;
    private double saldo;
    private String numeroCuenta;
    private ArrayList<String> movimientos;


    public CuentaBancaria(String titular, String numeroCuenta, double saldoInicial) {
        this.movimientos = new ArrayList<>();

        setTitular(titular);
        setNumeroCuenta(numeroCuenta);

        if (saldoInicial >= 0) {
            this.saldo = saldoInicial;
            movimientos.add("Cuenta creada con saldo inicial: S/ " + saldoInicial);
        } else {
            this.saldo = 0;
            movimientos.add("Cuenta creada con saldo inválido. Se asignó S/ 0.0");
        }
    }

    public String getTitular() {
        return titular;
    }


    public void setTitular(String titular) {
        if (titular != null && !titular.trim().isEmpty()) {
            this.titular = titular;
        } else {
            System.out.println("Error: El titular no puede estar vacío.");
        }
    }


    public String getNumeroCuenta() {
        return numeroCuenta;
    }


    public void setNumeroCuenta(String numeroCuenta) {
        if (numeroCuenta != null && !numeroCuenta.trim().isEmpty()) {
            this.numeroCuenta = numeroCuenta;
        } else {
            System.out.println("Error: El número de cuenta no puede estar vacío.");
        }
    }


    public double getSaldo() {
        return saldo;
    }


    public boolean depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            movimientos.add("Depósito: +S/ " + monto);
            return true;
        }
        return false;
    }


    public boolean retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            movimientos.add("Retiro: -S/ " + monto);
            return true;
        }
        return false;
    }


    public boolean transferir(CuentaBancaria destino, double monto) {
        if (monto > 0 && monto <= saldo) {
            this.saldo -= monto;
            destino.saldo += monto;

            this.movimientos.add("Transferencia enviada a " + destino.getTitular() + ": -S/ " + monto);
            destino.movimientos.add("Transferencia recibida de " + this.getTitular() + ": +S/ " + monto);

            return true;
        }
        return false;
    }


    public void getMovimientos() {
        System.out.println("\n--- MOVIMIENTOS DE " + titular + " ---");
        for (String movimiento : movimientos) {
            System.out.println(movimiento);
        }
    }


    public void mostrarDatos() {
        System.out.println("\n--- DATOS DE LA CUENTA ---");
        System.out.println("Titular: " + titular);
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Saldo actual: S/ " + saldo);
    }
}