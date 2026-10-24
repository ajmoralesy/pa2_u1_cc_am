
package ec.edu.ec.pa.paquetes;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main implements QuarkusApplication {
    // Inyección de dependencias mediante el contenedor ArC
    @Inject
    private PedidoService pedidoService;
    @Inject
    private CompraService compraService;
    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args) {
        System.out.println("Iniciando la aplicación Quarkus");
        // Creamos manualmente el objeto de la clase Pedido
        Pedido pedido = new Pedido(
            "Juan Perez",
            "Laptop",
            1500.00,
            "juan.perez@example.com"
        );
        pedido.setTelefono("09890222506");

        // Utilizamos el servicio inyectado por Quarkus
        this.pedidoService.realizar(pedido);

        Compra compra  = new Compra("Alexis Morales","Smartphone",800.00,"ajmoralesy@uce.edu.ec");
        compra.setTelefono("0989022506");
        this.compraService.realizar(compra);
         return 0;

    }
}


