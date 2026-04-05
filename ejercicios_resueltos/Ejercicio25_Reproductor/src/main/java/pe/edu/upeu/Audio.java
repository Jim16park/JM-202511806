package pe.edu.upeu;

public class Audio extends Multimedia {
    private String artista;

    public Audio(String titulo, String formato, int duracionSeg, String artista) {
        super(titulo, formato, duracionSeg);
        this.artista = artista;
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo audio: " + titulo + " - " + artista);
    }

    @Override
    public void pausar() {
        System.out.println("Audio pausado: " + titulo);
    }

    @Override
    public String obtenerInfo() {
        return "[AUDIO] " + resumen() + " | Artista: " + artista;
    }
}