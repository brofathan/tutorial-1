package id.ac.ui.cs.advprog.eshop.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderTest {
    private List<Product> products;
    @BeforeEach
    void setup() {
        this.products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("b2ae25a2-efc1-403d-af31-fec36ae37f2e");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);

        Product product2 = new Product();
        product2.setProductId("b9b1dfe1-ddfd-471d-a3f1-0b486f0da294");
        product2.setProductName("Sabun Cap Usep");
        product2.setProductQuantity(1);

        this.products.add(product1);
        this.products.add(product2);
    }

    @Test
    void testCreateOrderEmptyProduct() {
        this.products.clear();

        assertThrows(IllegalArgumentException.class, () -> {
            @SuppressWarnings("unused")
            Order order = new Order("22831cd9-c685-4138-b8a1-6443697fbcc9",
                    this.products, 1708560000L, "Safira Sudrajat");
        });
    }

    @Test
    void testCreateOrderDefaultStatus() {
        Order order = new Order("2ce7fead-82fb-4ff9-9af6-d2c604a030e7",
                this.products, 1708560000L, "Safira Sudrajat");

        assertSame(this.products, order.getProducts());
        assertEquals(2, order.getProducts().size());
        assertEquals("Sampo Cap Bambang", order.getProducts().get(0).getProductName());
        assertEquals("Sabun Cap Usep", order.getProducts().get(1).getProductName());
        assertEquals("dbd4aff4-9a7f-4603-92c2-eaf529271cc9", order.getId());
        assertEquals(1708560000L, order.getOrderTime());
        assertEquals("Safira Sudrajat", order.getAuthor());
        assertEquals(OrderStatus.WAITING_PAYMENT.getValue(), order.getStatus());
    }

    @Test
    void testCreateOrderSuccessStatus() {
        Order order = new Order("2ce7fead-82fb-4ff9-9af6-d2c604a030e7",
                this.products, 1708560000L, "Safira Sudrajat", OrderStatus.SUCCESS.getValue());
        assertEquals(OrderStatus.SUCCESS.getValue(), order.getStatus());
    }

    @Test
    void testCreateOrderInvalidStatus() {
        assertThrows(IllegalArgumentException.class, () -> {
            @SuppressWarnings("unused")
            Order order = new Order("2ce7fead-82fb-4ff9-9af6-d2c604a030e7",
                    this.products, 1708560000L, "Safira Sudrajat", "MEOW");
        });
    }

    @Test
    void testSetStatusToCancelled() {
        Order order = new Order("2ce7fead-82fb-4ff9-9af6-d2c604a030e7",
                this.products, 1708560000L, "Safira Sudrajat");
        order.setStatus(OrderStatus.CANCELED.getValue());
        assertEquals(OrderStatus.CANCELED.getValue(), order.getStatus());
    }

    @Test
    void testSetStatusToInvalidStatus() {
        Order order = new Order("2ce7fead-82fb-4ff9-9af6-d2c604a030e7",
                this.products, 1708560000L, "Safira Sudrajat");
        assertThrows(IllegalArgumentException.class, () -> {
            order.setStatus("MEOW");
        });
    }
}
