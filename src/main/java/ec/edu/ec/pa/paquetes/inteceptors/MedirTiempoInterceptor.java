package ec.edu.ec.pa.paquetes.inteceptors;

import java.lang.reflect.Parameter;

import ec.edu.ec.pa.paquetes.Pedido;
import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@MedirTiempo 
@Interceptor 
@Priority(Interceptor.Priority.APPLICATION +40)
public class MedirTiempoInterceptor {

     @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {
        long inicio = System.currentTimeMillis();
        Object resultado = context.proceed(); // Ejecuta el método interceptado
        long fin = System.currentTimeMillis();
        System.out.println("[Tiempo] Tiempo de ejecución: " + (fin - inicio) + " ms");
        return resultado;
    }

}



