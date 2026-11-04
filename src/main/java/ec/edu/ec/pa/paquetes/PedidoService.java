package ec.edu.ec.pa.paquetes;

import ec.edu.ec.pa.paquetes.inteceptors.Auditoria;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped // Delego el control al contendor ArC

public class PedidoService {
    @Auditoria
    public String realizar(Pedido pedido, String valor1) {
        long intitialTime = System.currentTimeMillis();
        
        try {
            Thread.sleep(1500); // Simulamos un proceso que tarda 1 segundo
        } catch (Exception e) {
        }
        System.out.println("realizando pedido...");
        System.out.println("Pedido realizado por el cliente: " + pedido.getCliente());
        System.out.println("Producto: " + pedido.getProducto());
        System.out.println("Total: " + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());
        System.out.println("Pedido realizado con éxito.");
        long finalTime = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución: " + (finalTime - intitialTime) + " ms");
        return "Pedido realizado con éxito.";
    }
}
