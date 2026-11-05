package ec.edu.ec.pa.paquetes.inteceptors;

import ec.edu.ec.pa.paquetes.Pedido;
import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@SMS 
@Interceptor 
@Priority(Interceptor.Priority.APPLICATION +20)
public class SMSInterceptor {

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {
        Object resultado = context.proceed();

        Pedido pedido = (Pedido) context.getParameters()[0];
        System.out.println("[SMSInterceptor] Se envió un SMS a " + pedido.getCliente()
                + " con el mensaje: su pedido de " + pedido.getProducto()
                + " por un total de $" + pedido.getTotal()
                + " ha sido realizado con éxito.");

        return resultado;
    }
}


