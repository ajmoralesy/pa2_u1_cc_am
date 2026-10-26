package ec.edu.uce.paquetes;

import java.util.UUID;

import jakarta.enterprise.context.Dependent;

@Dependent
public class Auditoria {

    private final String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }

    public void auditarVenta(int venta, String tipo,
            double monto, double descuento, double total) {

        System.out.println("UUID Auditoria: " + getId());
        System.out.println("Auditoria de la venta:");
        System.out.println("Venta: " + venta);
        System.out.println("Tipo: " + tipo);
        System.out.println("Monto: $" + monto);
        System.out.println("Descuento: " + (tipo.equalsIgnoreCase("REGULAR") ? "5%" : "15%"));
        System.out.println("Total: $" + total);
    }

}
