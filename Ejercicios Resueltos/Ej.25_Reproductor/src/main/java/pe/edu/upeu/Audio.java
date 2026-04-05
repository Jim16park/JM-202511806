package pe.edu.upeu;

public class Audio extends Multimedia {
    private String artista;


    public Audio(String titulo, int duracionSeg, String formato, String artista) {
        super(titulo, duracionSeg, formato);
        this.artista = artista;
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo audio: " + titulo + " - Artista: " + artista);
    }

    @Override
    public void pausar() {
        System.out.println("Audio pausado: " + titulo);
    }

    @Override
    public String obtenerInfo() {
        return "AUDIO | " + resumen() + " | Artista: " + artista;
    }
}