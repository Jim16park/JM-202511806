package pe.edu.upeu;

public abstract class Multimedia {
    protected String titulo;
    protected String formato;
    protected int duracionSeg;


    public Multimedia(String titulo, String formato, int duracionSeg) {
        this.titulo = titulo;
        this.formato = formato;
        this.duracionSeg = duracionSeg;
    }


    public abstract void reproducir();
    public abstract void pausar();
    public abstract String obtenerInfo();


    public String convertirFormato(String nuevoFormato) {
        String anterior = formato;
        formato = nuevoFormato;
        return "Convertido de " + anterior + " a " + nuevoFormato;
    }


    public String resumen() {
        return titulo + " (" + formato + ") - " + duracionSeg + "s";
    }
}