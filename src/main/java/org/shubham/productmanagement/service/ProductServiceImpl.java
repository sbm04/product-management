package org.shubham.productmanagement.service;

import org.shubham.productmanagement.model.Product;
import org.shubham.productmanagement.repository.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements  ProductService{
    @Autowired
    private ProductRespository productRespository;
    public Product createProduct(Product product) {
        return productRespository.save(product);


    }

    public Product getProductById(long id) throws Exception {
        Optional<Product> product = productRespository.findById(id);
        if(product.isPresent()){
            return product.get();

        }
        else{
            throw new Exception("Product Doesnot exist");
        }

    }
    public List<Product> getAllProducts(){
         return productRespository.findAll();
    }
    public boolean deleteProducts(long id){
        Optional<Product> product = productRespository.findById(id);
        if(product.isPresent()){
            this.productRespository.delete(product.get());
            return true;

        }
        else{
            return false;
        }
    }
}
