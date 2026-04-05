package pe.edu.upeu;

public class Motocicleta extends Vehiculo {
    private int cilindrada;


    public Motocicleta(String marca, String modelo, int capacidad, double consumoKmLitro, int cilindrada) {
        super(marca, modelo, capacidad, consumoKmLitro);
        this.cilindrada = cilindrada;
    }

    @Override
    public String descripcion() {
        return super.descripcion() + ", Cilindrada: " + cilindrada + " cc";
    }


    public static int capacidadTotal(Vehiculo[] flota) {
        int total = 0;
        for (Vehiculo v : flota) {
            total += v.getCapacidad();
        }
        return total;
    }


    public static void main(String[] args) {
        Automovil auto = new Automovil("Toyota", "Corolla", 5, 15, 4);
        Autobus bus = new Autobus("Volvo", "B11R", 4, 2);
        Motocicleta moto = new Motocicleta("Yamaha", "FZ", 2, 35, 150);

        Vehiculo[] flota = {auto, bus, moto};

        double km = 100;
        double precioLitro = 18;

        System.out.println("=== AUTOMÓVIL ===");
        System.out.println(auto.descripcion());
        System.out.println("Costo de viaje: S/ " + auto.costoViaje(km, precioLitro));

        System.out.println("\n=== AUTOBÚS ===");
        System.out.println(bus.descripcion());
        System.out.println("Costo de viaje: S/ " + bus.costoViaje(km, precioLitro));

        System.out.println("\n=== MOTOCICLETA ===");
        System.out.println(moto.descripcion());
        System.out.println("Costo de viaje: S/ " + moto.costoViaje(km, precioLitro));

        System.out.println("\nCapacidad total de la flota: " + capacidadTotal(flota) + " personas");
    }
}