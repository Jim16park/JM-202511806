package pe.edu.upeu;

public abstract class Multimedia {
    protected String titulo;
    protected int duracionSeg;
    protected String formato;


    public Multimedia(String titulo, int duracionSeg, String formato) {
        this.titulo = titulo;
        this.duracionSeg = duracionSeg;
        this.formato = formato;
    }


    public abstract void reproducir();
    public abstract void pausar();
    public abstract String obtenerInfo();


    public String convertirFormato(String nuevoFormato) {
        return "Convirtiendo \"" + titulo + "\" de " + formato + " a " + nuevoFormato;
    }


    public String resumen() {
        return titulo + " (" + formato + ") - " + duracionSeg + "s";
    }
}