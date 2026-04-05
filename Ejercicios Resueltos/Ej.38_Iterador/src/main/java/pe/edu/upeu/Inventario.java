package pe.edu.upeu;

import java.util.ArrayList;
import java.util.Iterator;

public class Inventario implements Iterable<Producto> {

    private ArrayList<Producto> productos = new ArrayList<>();


    public void agregarProducto(Producto p) {
        productos.add(p);
    }


    private class IteradorDisponible implements Iterator<Producto> {
        private int posicion = 0;

        @Override
        public boolean hasNext() {

            while (posicion < productos.size() &&
                    productos.get(posicion).getStock() <= 0) {
                posicion++;
            }
            return posicion < productos.size();
        }

        @Override
        public Producto next() {
            return productos.get(posicion++);
        }
    }


    @Override
    public Iterator<Producto> iterator() {
        return new IteradorDisponible();
    }


    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        inventario.agregarProducto(new Producto("Laptop", 5));
        inventario.agregarProducto(new Producto("Mouse", 0));
        inventario.agregarProducto(new Producto("Teclado", 3));
        inventario.agregarProducto(new Producto("Monitor", 0));
        inventario.agregarProducto(new Producto("USB", 10));

        System.out.println("=== PRODUCTOS CON STOCK DISPONIBLE ===");


        for (Producto p : inventario) {
            System.out.println(p);
        }
    }
}