package ec.edu.ec.pa.paquetes;

import ec.edu.ec.pa.paquetes.inteceptors.ValidacionCompra;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.ApplicationPath;

@ApplicationScoped
public class CompraService {

    @Inject
    @Named("mail")
    private Notificacion notificacionCorreo;

    @ValidacionCompra
    public void realizar(Compra compra) {
        System.out.println("realizando compra...");
        System.out.println("Compra realizada para el cliente: " + compra.getCliente());
        System.out.println("Producto: " + compra.getProducto());
        System.out.println("Total: " + compra.getTotal());
        System.out.println("Correo: " + compra.getCorreo());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException(
                    "Se interrumpió la compra", e);
        }
        System.out.println("Compra realizada con éxito.");

        String cuerpo = "Estimado " + compra.getCliente() + ", su compra de " +
                compra.getProducto() + " por un total de $" + compra.getTotal() +
                " ha sido realizado con éxito.";
        // Notificacion de pedido por correo electronico
        this.notificacionCorreo.enviar(compra.getCorreo(), cuerpo);
        this.notificacionCorreo.setCantidad(this.notificacionCorreo.getCantidad() + 1);
        System.out.println("Cantidad de correos enviados Compra: " + this.notificacionCorreo.getCantidad());
        System.out.println("Nombre: " + this.notificacionCorreo.getNombre());

    }

}
