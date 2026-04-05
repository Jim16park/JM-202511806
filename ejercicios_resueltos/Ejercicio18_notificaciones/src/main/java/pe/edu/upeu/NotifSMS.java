package pe.edu.upeu;

public class NotifSMS extends Notificacion {
    private String numTelefono;


    public NotifSMS(String destinatario, String mensaje, String numTelefono) {
        super(destinatario, mensaje);
        this.numTelefono = numTelefono;
    }


    @Override
    public void enviar() {
        System.out.println("SMS a " + destinatario + " | Teléfono: " + numTelefono);
        System.out.println("Mensaje: " + mensaje);
    }


    @Override
    public String formatear() {
        return "[SMS] Destinatario: " + destinatario +
                " | Teléfono: " + numTelefono +
                " | Mensaje: " + mensaje;
    }
}