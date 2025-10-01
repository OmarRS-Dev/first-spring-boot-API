package com.omar.msvc.products.controllers;

import com.omar.msvc.products.services.ProductService;
import com.omar.msvc.products.entities.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    final private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> list(){
        return  service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> details(@PathVariable Long id) {
        Optional<Product> productOptional = service.findById(id);

        if (productOptional.isPresent()) {
            Product pd = productOptional.get();
            return ResponseEntity.ok(pd);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
