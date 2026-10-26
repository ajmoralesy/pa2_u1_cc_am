# Taller práctico: Simulador de Descuentos con Quarkus

**Asignatura:** Programación Avanzada II  
**Tema:** IoC, DI, CDI, Qualifiers, Scopes y ciclo de vida de componentes.

## 1. Descripción del proyecto

El proyecto consiste en desarrollar un simulador de descuentos utilizando Java y Quarkus. El sistema permite procesar ventas según el tipo de cliente, aplicando un descuento del 5% para clientes REGULAR y del 15% para clientes VIP.

La aplicación utiliza el contenedor CDI de Quarkus para administrar las dependencias y se ejecuta mediante consola.

## 2. Estructura del proyecto

El proyecto está compuesto por las siguientes clases:

- **Main:** Inicia la aplicación y ejecuta las cuatro ventas.
- **CalculadoraDescuento:** Interfaz que define el método para calcular descuentos.
- **DescuentoRegular:** Calcula el descuento del 5%.
- **DescuentoVIP:** Calcula el descuento del 15%.
- **VentaService:** Procesa las ventas y selecciona el descuento correspondiente.
- **Auditoria:** Registra la información de cada venta en consola.

## 3. Resultados esperados

| Venta | Tipo | Monto | Descuento | Total |
|---|---|---|---|---|
| 1 | REGULAR | $100.00 | 5% | $95.00 |
| 2 | VIP | $200.00 | 15% | $170.00 |
| 3 | REGULAR | $300.00 | 5% | $285.00 |
| 4 | VIP | $500.00 | 15% | $425.00 |

## 4. Preguntas de análisis

### 1. ¿En qué parte del ejercicio se aplica IoC y en cuál DI?

IoC se aplica cuando Quarkus se encarga de crear y administrar los objetos de las clases, sin tener que crearlos manualmente con `new`.

DI se aplica en `VentaService`, donde se reciben las dos calculadoras de descuento por constructor y la clase `Auditoria` por atributo mediante `@Inject`.

### 2. ¿Qué función cumplen los Qualifiers y por qué son necesarios?

Los Qualifiers sirven para diferenciar las clases que implementan una misma interfaz. En este caso, se utiliza `@Named("regular")` y `@Named("vip")` para identificar cada descuento y evitar que Quarkus tenga problemas al momento de inyectarlos.

### 3. ¿Cuál es la diferencia entre @ApplicationScoped y @Dependent?

`@ApplicationScoped` permite utilizar la misma instancia durante la ejecución de la aplicación, mientras que `@Dependent` hace que la instancia dependa de la clase donde se inyecta.

En el ejercicio se utiliza `@ApplicationScoped` para las clases de descuentos y `VentaService`, mientras que `@Dependent` se utiliza en `Auditoria`.

### 4. ¿Por qué las instancias @ApplicationScoped pueden reutilizarse entre varias ventas?

Porque Quarkus mantiene la misma instancia mientras la aplicación está funcionando, por lo que no necesita crear una nueva para cada venta. Esto se puede comprobar con los UUID, ya que se mantiene el mismo identificador al procesar las ventas.

### 5. ¿Qué sucedería si se elimina el Qualifier de un punto de inyección de CalculadoraDescuento?

Se produciría un error porque Quarkus no podría encontrar la implementación correspondiente al punto de inyección. Por eso se utilizan `@Named("regular")` y `@Named("vip")`, para indicar qué descuento debe inyectarse.
