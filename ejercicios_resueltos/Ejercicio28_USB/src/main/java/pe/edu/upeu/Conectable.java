package pe.edu.upeu;

public interface Conectable {
    void conectar();
    void desconectar();
    boolean estaConectado();
    String getNombreDispositivo();
}