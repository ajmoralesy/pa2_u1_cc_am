package ec.edu.ec.pa.paquetes;

import io.quarkus.arc.Unremovable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

//Ambitos y contextos 
@ApplicationScoped //su ambito es durante toda su aplicacion, es decir se crea una sola instancia de la clase y se  comparte entre todos los componentes que la utilizan.
//@Singleton //su ambito es durante toda su aplicacion, es decir se crea una sola instancia de la clase y se  comparte entre todos los componentes que la utilizan.
//@RequestScoped // su ambito es en aplicaciones web durante el request/peticion http, es decir se crea una instancia de la clase y se comparte entre todos los componentes que la utilizan durante el request/peticion http.
//@SeccionScoped // su ambito es durante la secion del usuario, es decir se crea una instancia de la clase y se comparte entre todos los componentes que la utilizan durante durante la secion del usuario.
//@Dependent // Su ambito es durante la inyeccion de depencias, es decir y se comparte entre todos los componentes que la utilizan durante la inyeccion de depedencias.

@Named("mail")
public class MailService implements Notificacion {
    private Integer cantidad = 0;
    private String nombre;

   @Override
   public void enviar(String destino, String mensaje) {
    System.out.println("Enviando correo a: "+destino);
    System.out.println("Mensaje: "+mensaje);
    System.out.println("Correo enviado con éxito.");
    System.out.println("Fin del envio de correo.");
     
   }
   public String getNombre() {
        return nombre;
    }
     public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}

