package ec.edu.ec.pa.paquetes.inteceptors;

import java.lang.reflect.Parameter;

import ec.edu.ec.pa.paquetes.AuditoriaService;
import ec.edu.ec.pa.paquetes.Pedido;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Auditoria
@Interceptor 
public class AuditoriaInteceptor {

    @Inject 
    private AuditoriaService auditoriaService;

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {

        
        // Todo lo que esta arriba se ejcuta antes de ejecutar el metodo interceptado
        Object resultado = context.proceed(); // Ejecuta el método interceptado
        System.out.println("Retorno: " + resultado);


        String nombreMetodo = context.getMethod().getName();
        System.out.println("Auditoria: Se está ejecutando el método: " + nombreMetodo);
        System.out.println("Ejecuto todo lo que quiero que haga el interceptor");
        Parameter[] parametros = context.getMethod().getParameters();
        for (Parameter parametro : parametros) {
            System.out.println("Parametro: " + parametro.getName());
        }
        Object[] valores = context.getParameters();
        Pedido pedido = (Pedido) valores[0];
        String cliente = pedido.getCliente();
        double total = pedido.getTotal();
        String correo = pedido.getCorreo();
        
        this.auditoriaService.guardarEnLaBase(cliente, total, correo);
        
        System.out.println("Mensaje luego de que se ejecuto el metodo interceptado");
        return resultado;
    }

}
