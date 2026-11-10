
package ec.edu.ec.pa.paquetes;

import ec.edu.ec.pa.paquetes.extensiones.NotificacionExtensionMail;
import ec.edu.ec.pa.paquetes.extensiones.NotificacionExtensionSMS;
import ec.edu.ec.pa.paquetes.extensiones.NotificacionExtensionWhatsApp;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main implements QuarkusApplication {
    // Inyección de dependencias mediante el contenedor ArC
    @Inject
    private CompraService compraService;

    @Inject
    private NotificacionExtensionMail notificacionExtensionMail;

    @Inject
    private NotificacionExtensionSMS notificacionExtensionSMS;

    @Inject 
    private NotificacionExtensionWhatsApp notificacionExtensionWhatsApp;

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args) {
        System.out.println("Iniciando la aplicación Quarkus");

        Compra compra = new Compra(
                "Juan Perez",
                "Smartphone",
                800.00,
                "alex.morales@example.com");

        compraService.realizar(compra, this.notificacionExtensionMail);

        Compra compra1 = new Compra(
                "Alexis Morales",
                "Smartphone",
                800.00,
                "alex.morales@example.com");

        compraService.realizar(compra1, this.notificacionExtensionSMS);

        Compra compra2 = new Compra(
                "Pedro Zambrano",
                "Smartphone",
                800.00,
                "alex.morales@example.com");

        compraService.realizar(compra2, this.notificacionExtensionWhatsApp);

        return 0; // Salida exitosa

    }
}
