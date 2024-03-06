package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {
    private Map<String, String> paymentData;
    private Order order;
    private List<Product> products;

    @BeforeEach
    void setup() {
        this.paymentData = new HashMap<>();

        products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("97e55674-98af-4660-a4d2-63400c475a92");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        products.add(product1);

        Product product2 = new Product();
        product2.setProductId("2e891f43-ddb0-4b95-95ef-5f7b4f5f5308");
        product2.setProductName("Sabun Cap Usep");
        product2.setProductQuantity(1);
        products.add(product2);

        order = new Order(
                "31436a6a-58f2-4fa3-a0a1-6bda445329e2",
                products,
                1708560000L,
                "Safira Sudrajat"
        );
    }

    void loadBankTransferPaymentData() {
        paymentData.put("bankName", "BNI");
        paymentData.put("referenceCode", "1234567890");
    }

    void loadVoucherCodePaymentData() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
    }

    @Test
    void testCreatePaymentInvalidStatus(){
        loadBankTransferPaymentData();

        Payment payment = new Payment(
                "0114e361-9874-4d5f-afd5-95e2445b5d6e",
                PaymentMethod.BANK.getValue(),
                order,
                paymentData,
                "Hello"
        );

        assertEquals("0114e361-9874-4d5f-afd5-95e2445b5d6e", payment.getId());
        assertEquals(PaymentMethod.BANK.getValue(), payment.getMethod());
        assertEquals("Hello", payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testCreatePaymentBankPendingStatus() {
        loadBankTransferPaymentData();
        Payment payment = new Payment(
                "0114e361-9874-4d5f-afd5-95e2445b5d6e",
                PaymentMethod.BANK.getValue(),
                order,
                paymentData,
                PaymentStatus.PENDING.getValue()
        );
        assertEquals("0114e361-9874-4d5f-afd5-95e2445b5d6e", payment.getId());
        assertEquals(PaymentMethod.BANK.getValue(), payment.getMethod());
        assertEquals(PaymentStatus.PENDING.getValue(), payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testCreatePaymentVoucherPendingStatus() {
        loadVoucherCodePaymentData();
        Payment payment = new Payment(
                "0114e361-9874-4d5f-afd5-95e2445b5d6e",
                PaymentMethod.VOUCHER.getValue(),
                order,
                paymentData,
                PaymentStatus.PENDING.getValue()
        );
        assertEquals("0114e361-9874-4d5f-afd5-95e2445b5d6e", payment.getId());
        assertEquals(PaymentMethod.VOUCHER.getValue(), payment.getMethod());
        assertEquals(PaymentStatus.PENDING.getValue(), payment.getStatus());
        paymentData.clear();
    }
}
