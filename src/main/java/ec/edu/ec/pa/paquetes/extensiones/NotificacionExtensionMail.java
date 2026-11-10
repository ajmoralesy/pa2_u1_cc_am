package ec.edu.ec.pa.paquetes.extensiones;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NotificacionExtensionMail implements NotificacionExtension {
    @Override
    public void enviar(String mensaje, String destinatario) {
        System.out.println("Enviando correo a: " + destinatario );
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Correo enviado con éxito.");

    }



}
