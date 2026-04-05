package pe.edu.upeu;

import java.util.ArrayList;

public class Computadora {
    private ArrayList<Conectable> perifericos = new ArrayList<>();


    public void agregarDispositivo(Conectable dispositivo) {
        perifericos.add(dispositivo);
        System.out.println(dispositivo.getNombreDispositivo() + " agregado a la computadora.");
    }


    public void conectarTodos() {
        System.out.println("\n=== CONECTANDO DISPOSITIVOS ===");
        for (Conectable d : perifericos) {
            d.conectar();
        }
    }


    public void desconectarTodos() {
        System.out.println("\n=== DESCONECTANDO DISPOSITIVOS ===");
        for (Conectable d : perifericos) {
            d.desconectar();
        }
    }


    public void mostrarEstado() {
        System.out.println("\n=== ESTADO DE LOS DISPOSITIVOS ===");
        for (Conectable d : perifericos) {
            System.out.println(d.getNombreDispositivo() + " -> " +
                    (d.estaConectado() ? "Conectado" : "Desconectado"));
        }
    }


    public static void main(String[] args) {
        Computadora pc = new Computadora();

        pc.agregarDispositivo(new Teclado());
        pc.agregarDispositivo(new Mouse());
        pc.agregarDispositivo(new Impresora());
        pc.agregarDispositivo(new MemoriaUSB());

        pc.mostrarEstado();
        pc.conectarTodos();
        pc.mostrarEstado();
        pc.desconectarTodos();
        pc.mostrarEstado();
    }
}