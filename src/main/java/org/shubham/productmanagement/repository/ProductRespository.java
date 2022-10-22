package org.shubham.productmanagement.repository;

import org.shubham.productmanagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRespository extends JpaRepository<Product, Long> {

}
