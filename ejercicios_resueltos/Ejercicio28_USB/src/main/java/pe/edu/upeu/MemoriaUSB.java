package pe.edu.upeu;

public class MemoriaUSB implements Conectable {
    private boolean conectado = false;

    @Override
    public void conectar() {
        conectado = true;
        System.out.println("Memoria USB conectada.");
    }

    @Override
    public void desconectar() {
        conectado = false;
        System.out.println("Memoria USB desconectada.");
    }

    @Override
    public boolean estaConectado() {
        return conectado;
    }

    @Override
    public String getNombreDispositivo() {
        return "Memoria USB";
    }
}