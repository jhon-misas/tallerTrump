package co.taller.shipping;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ShippingCalculatorProxyTest {
    private final Order order = new Order("o1", "c1", "Medellín", 100, 4);

    @Test void delegaAlCalculadorSmart() {
        assertEquals(15.0, new ShippingCalculatorProxy(new SmartShippingCalculator()).calculate(order));
    }

    @Test void checkoutFuncionaConCualquierCalculador() {
        Checkout checkout = new Checkout(ignored -> 7.0);
        assertEquals(107.0, checkout.total(order));
    }

    @Test void calculaBogotaSinRecargo() {
        assertEquals(10.0, new SmartShippingCalculator().calculate(
                new Order("o2", "c1", "Bogotá", 100, 4)));
    }

    @Test void cacheaPorIdDeOrden() {
        int[] calls = {0};
        ShippingCalculator counting = ignored -> { calls[0]++; return 15.0; };
        ShippingCalculatorProxy proxy = new ShippingCalculatorProxy(counting);
        assertEquals(15.0, proxy.calculate(order));
        assertEquals(15.0, proxy.calculate(order));
        assertEquals(1, calls[0]);
    }

}
