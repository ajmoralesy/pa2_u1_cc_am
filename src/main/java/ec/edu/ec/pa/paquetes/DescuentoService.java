package ec.edu.ec.pa.paquetes;

import jakarta.inject.Singleton;

@Singleton
public class DescuentoService {
    public double calcularDescuento(double total) {
        if (total > 100) {
            return total * 0.10;
        }
        return 0;
    }
}
