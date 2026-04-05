package pe.edu.upeu;

import java.util.ArrayList;

public class Imagen extends Multimedia {
    private String dimensiones;

    public Imagen(String titulo, String formato, int duracionSeg, String dimensiones) {
        super(titulo, formato, duracionSeg);
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

        lista.add(new Audio("Canción 1", "mp3", 180, "Bad Bunny"));
        lista.add(new Video("Película 1", "mp4", 7200, "1080p"));
        lista.add(new Imagen("Foto 1", "jpg", 5, "1920x1080"));

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