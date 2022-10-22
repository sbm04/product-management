package org.shubham.productmanagement.controller;

import org.shubham.productmanagement.model.Product;
import org.shubham.productmanagement.service.ProductService;
import org.shubham.productmanagement.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping(value = "/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){

       return ResponseEntity.ok().body( productService.createProduct(product));

    }
    @GetMapping(value = "/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable long id) throws  Exception{

        return ResponseEntity.ok().body( productService.getProductById(id));

    }
    @GetMapping(value = "/products/")
    public ResponseEntity<List<Product>> getAllProduct() throws  Exception{

        return ResponseEntity.ok().body(productService.getAllProducts() );

    }
    @DeleteMapping("/products/{id}")
    public HttpStatus deleteProducts(@PathVariable long id){
        if(this.productService.deleteProducts(id)){
            return HttpStatus.OK;
        }
        else{
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
