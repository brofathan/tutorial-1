package id.ac.ui.cs.advprog.eshop.controller;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @Mock
    private Model model;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testCreateProductPage() {
        String viewName = productController.createProductPage(model);
        assert(viewName.equals("createProduct"));
    }


    @Test
    public void testProductListPage() {
        List<Product> productList = new ArrayList<>();
        when(productService.findAll()).thenReturn(productList);

        String viewName = productController.productListPage(model);

        assert(viewName.equals("productList"));
        verify(model, times(1)).addAttribute("products", productList);
    }

    @Test
    public void testDeleteProductPost() {
        String productId = "1";

        String viewName = productController.deleteProductPost(productId, model);

        assert(viewName.equals("redirect:/product/list"));
        verify(productService, times(1)).delete(productId);
    }

    @Test
    public void testEditProductPage() {
        String productId = "1";
        Product product = new Product();
        when(productService.findById(productId)).thenReturn(product);

        String viewName = productController.editProductPage(productId, model);

        assert(viewName.equals("editProduct"));
        verify(model, times(1)).addAttribute("product", product);
    }

}