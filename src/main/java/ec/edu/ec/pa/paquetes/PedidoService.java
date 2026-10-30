package ec.edu.ec.pa.paquetes;

import ec.edu.ec.pa.paquetes.inteceptors.Auditoria;
import ec.edu.ec.pa.paquetes.inteceptors.Descuento;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped // Delego el control al contendor ArC

public class PedidoService {
    @Descuento
    public String realizar(Pedido pedido, String valor1) {

        System.out.println("realizando pedido...");

        System.out.println(
                "Pedido realizado por el cliente: "
                        + pedido.getCliente());

        System.out.println("Producto: " + pedido.getProducto());
        System.out.println("Total: " + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());
        System.out.println("Pedido realizado con éxito.");

        return "Pedido realizado con éxito.";
    }
}
