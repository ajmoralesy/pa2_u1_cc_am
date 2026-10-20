package ec.edu.ec.pa.paquetes;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Singleton;

//@ApplicationScoped //Delego el control al contendor ArC
//@RequestScoped //para aplicaciones para aplicaciones web
@Singleton 
public class MailService {
   public void enviar(String correo, String asunto, String cuerpo) {
        System.out.println("Enviando correo a: " + correo);
        System.out.println("Asunto: " + asunto);
        System.out.println("Cuerpo: " + cuerpo);
        System.out.println("Correo enviado con éxito.");
    }
}
