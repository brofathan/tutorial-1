package id.ac.ui.cs.advprog.eshop.repository;

import java.util.*;

import org.springframework.stereotype.Repository;
import id.ac.ui.cs.advprog.eshop.model.Product;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();
    
    public Product create(Product product){
        product.setProductId(UUID.randomUUID().toString());
        productData.add(product);
        return product;
    }

    public String delete(String id){
        List<Product> productData2 = new ArrayList<>();

        for (Product p: productData) {
            if(!id.equals(p.getProductId())){
                productData2.add(p);
            }
        }

        productData = new ArrayList<>();

        for (Product p: productData2) {
            productData.add(p);
        }

        return "deleted";
    }

    public Iterator<Product> findAll(){
        return productData.iterator();
    }
}
