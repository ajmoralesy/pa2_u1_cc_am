package ec.edu.ec.pa.paquetes.inteceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@ValidacionCompra
@Interceptor
@Priority(Interceptor.Priority.APPLICATION + 50)
public class ValidacionCompraInterceptor {

        @AroundInvoke
        public Object interceptar(InvocationContext context)
                        throws Exception {

                System.out.println(
                                "[VALIDACION] Verificando datos de la compra...");

                Object resultado = context.proceed();

                System.out.println(
                                "[VALIDACION] Proceso de compra finalizado.");

                return resultado;
        }
}