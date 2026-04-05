package pe.edu.upeu;

import java.util.ArrayList;

public class NotifPush extends Notificacion {
    private String icono;


    public NotifPush(String destinatario, String mensaje, String icono) {
        super(destinatario, mensaje);
        this.icono = icono;
    }


    @Override
    public void enviar() {
        System.out.println("PUSH a " + destinatario + " | Ícono: " + icono);
        System.out.println("Mensaje: " + mensaje);
    }


    @Override
    public String formatear() {
        return "[PUSH] Destinatario: " + destinatario +
                " | Ícono: " + icono +
                " | Mensaje: " + mensaje;
    }


    public static void main(String[] args) {
        ArrayList<Notificacion> pendientes = new ArrayList<>();

        pendientes.add(new NotifEmail("jimena@gmail.com", "Tu tarea fue enviada correctamente", "Entrega Exitosa"));
        pendientes.add(new NotifSMS("Jimena", "Tu código fue compilado con éxito", "987654321"));
        pendientes.add(new NotifPush("Jimena", "Tienes una nueva actualización", "🔔"));

        System.out.println("=== ENVÍO MASIVO DE NOTIFICACIONES ===\n");

        for (Notificacion n : pendientes) {
            System.out.println(n.formatear());
            n.enviar();
            System.out.println("----------------------------------");
        }
    }
}