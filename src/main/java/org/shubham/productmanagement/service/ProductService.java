package org.shubham.productmanagement.service;

import org.shubham.productmanagement.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product getProductById(long id) throws Exception;
    List<Product> getAllProducts();
    boolean deleteProducts(long id);


}
