package ec.edu.uce.paquetes;

import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("vip")
public class DescuentoVIP implements CalculadoraDescuento {

    private final String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }

    @Override
    public double calcular(double monto) {
        return monto * 0.15;
    }

}
