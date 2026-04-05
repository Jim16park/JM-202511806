package pe.edu.upeu;

public class Teclado implements Conectable {
    private boolean conectado = false;

    @Override
    public void conectar() {
        conectado = true;
        System.out.println("Teclado conectado.");
    }

    @Override
    public void desconectar() {
        conectado = false;
        System.out.println("Teclado desconectado.");
    }

    @Override
    public boolean estaConectado() {
        return conectado;
    }

    @Override
    public String getNombreDispositivo() {
        return "Teclado USB";
    }
}