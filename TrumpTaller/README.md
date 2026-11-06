# Taller práctico: Proxy para envío

Proyecto de ejemplo en Java 17 y JUnit 5. `Checkout` depende de `ShippingCalculator`; el proxy controla la migración gradual y el paso 5 añade caché por identificador de orden.

## Requisitos

- JDK 17 o superior
- Maven 3.8 o superior
- Git

## Ejecutar

En PowerShell, desde la carpeta del proyecto:

```powershell
mvn test
```

Para compilar sin tests: `mvn package -DskipTests`.

La caché es por instancia del proxy. Si una orden cambia manteniendo el mismo `id`, se debe crear una instancia nueva o invalidar esa entrada (esta versión de taller presupone órdenes inmutables).
