package com.example.Storge.Controllers;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.Storge.Models.Product;
import com.example.Storge.Repositories.ProductRepository;

@RestController
public class ProductController {
    private static final Logger logger = Logger.getLogger(ProductController.class.getName());

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/Product")
    public List<Product> getProducts() {
        logger.info("Getting all products");
        return productRepository.findAll();
    }

    @PostMapping("/Product")
    public Product createProduct(@RequestBody Product product) {
        logger.info("Creating a new product: " + product.getName());
        return productRepository.save(product);
    }

    @PutMapping("/Product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        logger.info("Updating product with ID: " + id);

        // Log the updated product details
        logger.info("Updated product details: " + updatedProduct);

        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setCategory(updatedProduct.getCategory());
            existingProduct.setCreationDate(updatedProduct.getCreationDate());

            // Log the existing product details before the update
            logger.info("Existing product details: " + existingProduct);

            Product savedProduct = productRepository.save(existingProduct);

            // Log the saved product details after the update
            logger.info("Saved product details: " + savedProduct);

            return ResponseEntity.ok(savedProduct);
        } else {
            logger.warning("Product with ID " + id + " not found");
            return ResponseEntity.notFound().build();
        }
    }
}