package id.ac.ui.cs.advprog.eshop.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;

public class ProductServiceTest {

    private ProductServiceImpl productService;
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        productService = new ProductServiceImpl();
        productService.setProductRepository(productRepository);
    }

    @Test
    public void testCreateProduct() {
        Product product = new Product();
        when(productRepository.create(product)).thenReturn(product);

        Product createdProduct = productService.create(product);

        assertEquals(product, createdProduct);
        verify(productRepository, times(1)).create(product);
    }

    @Test
    public void testDeleteProduct() {
        String productId = "1";
        when(productRepository.delete(productId)).thenReturn("deleted");

        String result = productService.delete(productId);

        assertEquals("deleted", result);
        verify(productRepository, times(1)).delete(productId);
    }

    @Test
    public void testEditProduct() {
        Product product = new Product();
        when(productRepository.edit(product)).thenReturn("edited");

        String result = productService.edit(product);

        assertEquals("edited", result);
        verify(productRepository, times(1)).edit(product);
    }

    @Test
    public void testFindProductById() {
        String productId = "1";
        Product product = new Product();
        when(productRepository.findById(productId)).thenReturn(product);

        Product foundProduct = productService.findById(productId);

        assertEquals(product, foundProduct);
        verify(productRepository, times(1)).findById(productId);
    }
}
