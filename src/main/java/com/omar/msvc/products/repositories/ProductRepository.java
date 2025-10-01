package com.omar.msvc.products.repositories;

import com.omar.msvc.products.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
