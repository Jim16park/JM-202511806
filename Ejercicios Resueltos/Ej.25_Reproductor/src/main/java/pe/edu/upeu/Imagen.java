package pe.edu.upeu;

import java.util.ArrayList;

public class Imagen extends Multimedia {
    private String dimensiones;


    public Imagen(String titulo, int duracionSeg, String formato, String dimensiones) {
        super(titulo, duracionSeg, formato);
        this.dimensiones = dimensiones;
    }

    @Override
    public void reproducir() {
        System.out.println("Mostrando imagen: " + titulo + " (" + dimensiones + ")");
    }

    @Override
    public void pausar() {
        System.out.println("Imagen en pausa: " + titulo);
    }

    @Override
    public String obtenerInfo() {
        return "[IMAGEN] " + resumen() + " | Dimensiones: " + dimensiones;
    }


    public static void main(String[] args) {
        ArrayList<Multimedia> lista = new ArrayList<>();

        lista.add(new Audio("Canción 1", 180, "mp3", "Bad Bunny"));
        lista.add(new Video("Película 1", 7200, "mp4", "1080p"));
        lista.add(new Imagen("Foto 1", 5, "jpg", "1920x1080"));

        System.out.println("=== REPRODUCTOR MULTIMEDIA ===\n");

        for (Multimedia m : lista) {
            System.out.println(m.obtenerInfo());
            m.reproducir();
            m.pausar();
            System.out.println(m.convertirFormato("avi"));
            System.out.println("----------------------------------");
        }
    }
}