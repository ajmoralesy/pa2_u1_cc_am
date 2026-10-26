package ec.edu.uce.paquetes;

import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class VentaService {
    private CalculadoraDescuento descuentoRegular;
    private CalculadoraDescuento descuentoVIP;

    // Inyeccion por constructor
    @Inject
    public VentaService(@Named("regular") CalculadoraDescuento descuentoRegular,
            @Named("vip") CalculadoraDescuento descuentoVIP) {
        this.descuentoRegular = descuentoRegular;
        this.descuentoVIP = descuentoVIP;
    }

    // Inyeccion por atributo
    @Inject
    private Auditoria auditoria;

    private final String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }

    public void procesarVenta(int venta, double precio, String tipoCliente) {
        System.out.println("UUID VentaService: " + getId());
        CalculadoraDescuento calculadoraDescuento;
        if ("REGULAR".equalsIgnoreCase(tipoCliente)) {

            calculadoraDescuento = descuentoRegular;

            System.out.println("UUID DescuentoRegular: "
                    + ((DescuentoRegular) descuentoRegular).getId());

        } else if ("VIP".equalsIgnoreCase(tipoCliente)) {

            calculadoraDescuento = descuentoVIP;

            System.out.println("UUID DescuentoVIP: "
                    + ((DescuentoVIP) descuentoVIP).getId());

        } else {

            System.out.println("Tipo de cliente no valido");
            return;
        }
        double descuento = calculadoraDescuento.calcular(precio);
        double total = precio - descuento;

        auditoria.auditarVenta(venta, tipoCliente, precio, descuento, total);
    }

}
