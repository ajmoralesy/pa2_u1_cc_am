package ec.edu.ec.pa.paquetes.extensiones;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NotificacionExtensionSMS implements NotificacionExtension {

    @Override
    public void enviar(String mensaje, String destinatario) {
        System.out.println("Enviando SMS a: " + destinatario);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("SMS enviado con éxito.");
    }
}
