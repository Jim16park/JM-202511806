package pe.edu.upeu;

public class Notificacion {
    protected String destinatario;
    protected String mensaje;


    public Notificacion(String destinatario, String mensaje) {
        this.destinatario = destinatario;
        this.mensaje = mensaje;
    }


    public void enviar() {
        System.out.println("Enviando notificación a " + destinatario);
    }


    public String formatear() {
        return "Destinatario: " + destinatario + " | Mensaje: " + mensaje;
    }
}