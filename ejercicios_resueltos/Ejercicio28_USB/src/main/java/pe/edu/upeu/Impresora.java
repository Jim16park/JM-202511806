package pe.edu.upeu;

public class Impresora implements Conectable {
    private boolean conectado = false;

    @Override
    public void conectar() {
        conectado = true;
        System.out.println("Impresora conectada.");
    }

    @Override
    public void desconectar() {
        conectado = false;
        System.out.println("Impresora desconectada.");
    }

    @Override
    public boolean estaConectado() {
        return conectado;
    }

    @Override
    public String getNombreDispositivo() {
        return "Impresora USB";
    }
}