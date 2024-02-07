package id.ac.ui.cs.advprog.eshop.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        productRepository.create(product);
        return product;
    }

    @Override
    public String delete(String id){
        productRepository.delete(id);
        return "deleted";
    }

    @Override
    public String edit(Product product){
        productRepository.edit(product);
        return "edited";
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        Iterator<Product> producIterator = productRepository.findAll();
        List<Product> allProduct = new ArrayList<>();
        producIterator.forEachRemaining(allProduct::add);
        return allProduct;
    }
    
}
