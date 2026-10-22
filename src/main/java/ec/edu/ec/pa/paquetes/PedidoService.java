package ec.edu.ec.pa.paquetes;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@ApplicationScoped //Delego el control al contendor ArC
//@RequestScoped //para aplicaciones para aplicaciones web
//@Singleton
public class PedidoService {
    @Inject 
    private MailService mailService;

    public void realizar(Pedido pedido) {
        System.out.println("realizando pedido...");
        System.out.println("Pedido realizado por el cliente: " + pedido.getCliente());
        System.out.println("Producto: " + pedido.getProducto());
        System.out.println("Total: " + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());
        System.out.println("Pedido realizado con éxito.");

        String asunto = "Confirmacion de pedido";
        String cuerpo = "Estimado " + pedido.getCliente() + ", su pedido de " +
                pedido.getProducto() + " por un total de $" + pedido.getTotal() +
                " ha sido realizado con éxito.";
        this.mailService.enviar(pedido.getCorreo(), asunto, cuerpo);
    }
}
