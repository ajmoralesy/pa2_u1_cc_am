package ec.edu.ec.pa.paquetes;

import ec.edu.ec.pa.paquetes.extensiones.NotificacionExtension;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.ApplicationPath;

@ApplicationScoped
public class CompraService {

    public void realizar(Compra compra, NotificacionExtension notificacionExtension ) {
        System.out.println("realizando compra...");
        System.out.println("Compra realizada para el cliente: " + compra.getCliente());
        System.out.println("Producto: " + compra.getProducto());
        System.out.println("Total: " + compra.getTotal());
        System.out.println("Correo: " + compra.getCorreo());
        System.out.println("Compra realizada con éxito.");


        //aqui voy a programar el envio de la notificacion
        notificacionExtension.enviar("Su pedido ha sido realizada con éxito.", compra.getCliente());
    }

}
