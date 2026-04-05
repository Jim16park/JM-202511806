package pe.edu.upeu;

public class NotifEmail extends Notificacion {
    private String asunto;


    public NotifEmail(String destinatario, String mensaje, String asunto) {
        super(destinatario, mensaje);
        this.asunto = asunto;
    }


    @Override
    public void enviar() {
        System.out.println("EMAIL a " + destinatario + " | Asunto: " + asunto);
        System.out.println("Mensaje: " + mensaje);
    }


    @Override
    public String formatear() {
        return "[EMAIL] Destinatario: " + destinatario +
                " | Asunto: " + asunto +
                " | Mensaje: " + mensaje;
    }
}