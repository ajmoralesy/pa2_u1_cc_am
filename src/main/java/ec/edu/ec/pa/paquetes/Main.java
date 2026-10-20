
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

        // Utilizamos el servicio inyectado por Quarkus
        this.pedidoService.realizar(pedido);
        return 0;
    }
}


