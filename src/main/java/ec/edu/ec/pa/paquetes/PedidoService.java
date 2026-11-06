package ec.edu.ec.pa.paquetes;

import ec.edu.ec.pa.paquetes.inteceptors.Auditoria;
import ec.edu.ec.pa.paquetes.inteceptors.Mail;
import ec.edu.ec.pa.paquetes.inteceptors.MedirTiempo;
import ec.edu.ec.pa.paquetes.inteceptors.SMS;
import ec.edu.ec.pa.paquetes.inteceptors.ValidacionCompra;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped // Delego el control al contendor ArC

public class PedidoService {
    @MedirTiempo 
    @Auditoria
    @SMS 
    @Mail 

    public String realizar(Pedido pedido, String valor1) {
        try {
            Thread.sleep(1500); // Simulamos un proceso que tarda 1 segundo
        } catch (Exception e) {
        }
        System.out.println("Realizando pedido...");
        System.out.println("Pedido realizado por el cliente: " + pedido.getCliente());
        System.out.println("Producto: " + pedido.getProducto());
        System.out.println("Total: " + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());
        System.out.println("Pedido realizado con éxito.");
        return "Pedido realizado con éxito.";
    }
}
