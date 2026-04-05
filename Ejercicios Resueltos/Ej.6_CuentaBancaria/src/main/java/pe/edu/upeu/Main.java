package pe.edu.upeu;

public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria("Jimena Lupaca", "123456789", 1000);
        CuentaBancaria cuenta2 = new CuentaBancaria("Ana Torres", "987654321", 500);


        cuenta1.mostrarDatos();
        cuenta2.mostrarDatos();


        cuenta1.depositar(300);
        cuenta1.retirar(200);
        cuenta1.transferir(cuenta2, 250);


        cuenta1.mostrarDatos();
        cuenta2.mostrarDatos();

         
        cuenta1.getMovimientos();
        cuenta2.getMovimientos();
    }
}