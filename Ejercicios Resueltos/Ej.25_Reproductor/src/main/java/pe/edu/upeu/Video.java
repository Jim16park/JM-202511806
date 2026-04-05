package pe.edu.upeu;

public class Video extends Multimedia {
    private String resolucion;


    public Video(String titulo, int duracionSeg, String formato, String resolucion) {
        super(titulo, duracionSeg, formato);
        this.resolucion = resolucion;
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo video: " + titulo + " en " + resolucion);
    }

    @Override
    public void pausar() {
        System.out.println("Video pausado: " + titulo);
    }

    @Override
    public String obtenerInfo() {
        return "VIDEO | " + resumen() + " | Resolución: " + resolucion;
    }
}