package ec.edu.ec.pa.paquetes;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

@ApplicationScoped // Delego el control al contendor ArC

public class PedidoService {

    @Inject
    @Named("mail") 
    private Notificacion notificacionCorreo;
    @Inject 
     @Named("sms") 
    private Notificacion notificacionSMS;
    

    public void realizar(Pedido pedido) {
        System.out.println("realizando pedido...");
        System.out.println("Pedido realizado por el cliente: " + pedido.getCliente());
        System.out.println("Producto: " + pedido.getProducto());
        System.out.println("Total: " + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());
        System.out.println("Pedido realizado con éxito.");

        String cuerpo = "Estimado " + pedido.getCliente() + ", su pedido de " +
                pedido.getProducto() + " por un total de $" + pedido.getTotal() +
                " ha sido realizado con éxito.";
        //Notificacion de pedido por correo electronico
        this.notificacionCorreo.enviar(pedido.getCorreo(), cuerpo);
        //Notificacion de pedido por SMS
        this.notificacionSMS.enviar(pedido.getTelefono(), cuerpo);
    
    }
}
