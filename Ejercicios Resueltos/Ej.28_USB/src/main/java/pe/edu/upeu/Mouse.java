package pe.edu.upeu;

public class Mouse implements Conectable {
    private boolean conectado = false;

    @Override
    public void conectar() {
        conectado = true;
        System.out.println("Mouse conectado.");
    }

    @Override
    public void desconectar() {
        conectado = false;
        System.out.println("Mouse desconectado.");
    }

    @Override
    public boolean estaConectado() {
        return conectado;
    }

    @Override
    public String getNombreDispositivo() {
        return "Mouse USB";
    }
}