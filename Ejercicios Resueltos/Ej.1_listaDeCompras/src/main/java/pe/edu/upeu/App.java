package pe.edu.upeu;

import java.util.ArrayList;
import java.util.Collections;


        public class App {


            static class ListaCompras {
                private ArrayList<String> productos;

                public ListaCompras() {
                    productos = new ArrayList<>();
                }


                public void agregarProducto(String producto) {
                    if (!productos.contains(producto)) {
                        productos.add(producto);
                        System.out.println("Producto agregado: " + producto);
                    } else {
                        System.out.println("El producto '" + producto + "' ya está en la lista.");
                    }
                }


                public void eliminarProducto(String producto) {
                    if (productos.remove(producto)) {
                        System.out.println("Producto eliminado: " + producto);
                    } else {
                        System.out.println("El producto '" + producto + "' no se encontró en la lista.");
                    }
                }

                public boolean buscarProducto(String producto) {
                    return productos.contains(producto);
                }


                public int contarProductos() {
                    return productos.size();
                }


                public void ordenarAlfabeticamente() {
                    Collections.sort(productos);
                    System.out.println("Lista ordenada alfabéticamente.");
                }


                public void mostrarProductos() {
                    System.out.println("Lista de compras: " + productos);
                }
            }


            public static void main(String[] args) {
                ListaCompras lista = new ListaCompras();

                lista.agregarProducto("Leche");
                lista.agregarProducto("Pan");
                lista.agregarProducto("Arroz");
                lista.agregarProducto("Leche"); // duplicado

                lista.mostrarProductos();

                System.out.println("¿Está Pan? " + lista.buscarProducto("Pan"));
                System.out.println("Cantidad de productos: " + lista.contarProductos());

                lista.eliminarProducto("Pan");
                lista.mostrarProductos();

                lista.ordenarAlfabeticamente();
                lista.mostrarProductos();
            }
        }


