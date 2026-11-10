package ec.edu.ec.pa.paquetes.extensiones;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NotificacionExtensionWhatsApp implements NotificacionExtension {
    @Override
    public void enviar(String mensaje, String destinatario) {
        System.out.println("Enviando WhatsApp a: " + destinatario);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("WhatsApp enviado con éxito.");
    }
}
