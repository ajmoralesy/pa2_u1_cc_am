
package ec.edu.ec.pa.paquetes.inteceptors;

import ec.edu.ec.pa.paquetes.DescuentoService;
import ec.edu.ec.pa.paquetes.Pedido;

import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Descuento
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class DescuentoInterceptor {

    @Inject
    private DescuentoService descuentoService;

    @AroundInvoke
    public Object interceptar(InvocationContext context)
            throws Exception {

        String nombreMetodo = context.getMethod().getName();

        System.out.println(
                "Descuento: Se está ejecutando el método: "
                        + nombreMetodo);

        // Obtener los argumentos del método
        Object[] valores = context.getParameters();
        Pedido pedido = (Pedido) valores[0];

        double totalOriginal = pedido.getTotal();

        // Calcular descuento utilizando el servicio inyectado
        double descuento = this.descuentoService.calcularDescuento(totalOriginal);

        double totalFinal = totalOriginal - descuento;

        // Actualizar el total antes de realizar el pedido
        pedido.setTotal(totalFinal);

        System.out.println("Total sin descuento: $" + totalOriginal);
        System.out.println("Descuento: $" + descuento);
        System.out.println("Total con descuento: $" + totalFinal);

        // Ejecutar el método interceptado
        Object resultado = context.proceed();

        System.out.println("Retorno: " + resultado);

        return resultado;
    }
}