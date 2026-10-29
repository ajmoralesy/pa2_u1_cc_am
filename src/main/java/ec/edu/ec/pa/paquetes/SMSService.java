package ec.edu.ec.pa.paquetes;

import jakarta.inject.Named;
import jakarta.inject.Singleton;

@Singleton
@Named("sms")
public class SMSService implements Notificacion {

    @Override
    public void enviar(String destino, String mensaje) {
        System.out.println("Enviar SMS a: " + destino);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("SMS enviado con éxito.");
        System.out.println("Fin del envio de SMS.");
    }

    @Override
    public Integer getCantidad() {
        return null;
    }

    @Override
    public void setCantidad(Integer cantidad) {
 
    }

    @Override
    public String getNombre() {
        // TODO Auto-generated method stub
       return null;
    }

    @Override
    public void setNombre(String nombre) {
  
    }
}
