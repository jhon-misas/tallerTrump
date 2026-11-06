package co.taller.shipping;

import java.util.HashMap;
import java.util.Map;

/** Proxy de migración con caché local a la instancia por order.id(). */
public class ShippingCalculatorProxy implements ShippingCalculator {
    private final ShippingCalculator smart;
    private final Map<String, Double> cache = new HashMap<>();

    public ShippingCalculatorProxy(ShippingCalculator smart) {
        this.smart = smart;
    }

    @Override
    public double calculate(Order order) {
        return cache.computeIfAbsent(order.id(), ignored -> smart.calculate(order));
    }
}
