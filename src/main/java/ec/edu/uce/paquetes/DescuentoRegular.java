package ec.edu.uce.paquetes;

import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("regular")
public class DescuentoRegular implements CalculadoraDescuento {

    private final String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }

    @Override
    public double calcular(double monto) {
        return monto * 0.05;
    }

}
