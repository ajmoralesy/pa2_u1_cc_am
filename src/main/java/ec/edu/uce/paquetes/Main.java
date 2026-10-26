package ec.edu.uce.paquetes;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main implements QuarkusApplication {

    // Inyección por atributo
    @Inject
    private VentaService ventaService;

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args) throws Exception {
        System.out.println("=== SIMULADOR DE DESCUENTOS ===");
        ventaService.procesarVenta(1, 100, "REGULAR");
        ventaService.procesarVenta(2, 200, "VIP");
        ventaService.procesarVenta(3, 300, "REGULAR");
        ventaService.procesarVenta(4, 500, "VIP");

        return 0;
    }
}