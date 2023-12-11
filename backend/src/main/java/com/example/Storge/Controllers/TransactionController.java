package com.example.Storge.Controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Storge.Models.Transaction;
import com.example.Storge.Repositories.TransactionRepository;

@RestController
public class TransactionController {
    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    TransactionRepository transactionRepository;

    @PostMapping("/Transaction")
    public Transaction createSale(@RequestBody Transaction transaction) {
        logger.info("Creating a new transaction: {}", transaction);
        return transactionRepository.save(transaction);
    }

    @PatchMapping("/Transaction/{id}")
    public ResponseEntity<?> updateTransaction(@PathVariable("id") int id, @RequestBody Transaction updatedTransaction) {
        logger.info("Updating transaction with ID: {}", id);
    
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        if (optionalTransaction.isPresent()) {
            Transaction transaction = optionalTransaction.get();
            if (updatedTransaction.getQuantity() != 0) {
                int originalQuantity = transaction.getQuantity();
                int updatedQuantity = updatedTransaction.getQuantity();
                
                if (originalQuantity != updatedQuantity) {
                    logger.info("Quantity updated from {} to {}", originalQuantity, updatedQuantity);
                }
                
                transaction.setQuantity(updatedQuantity);
            }
            if (updatedTransaction.getPrice() != 0.0) {
                double originalPrice = transaction.getPrice();
                double updatedPrice = updatedTransaction.getPrice();
                
                if (originalPrice != updatedPrice) {
                    logger.info("Price updated from {} to {}", originalPrice, updatedPrice);
                }
                
                transaction.setPrice(updatedPrice);
            }
    
            logger.info("Updated transaction details: {}", transaction);
    
            Transaction savedTransaction = transactionRepository.save(transaction);
    
            logger.info("Saved transaction details: {}", savedTransaction);
    
            return ResponseEntity.ok(savedTransaction);
        } else {
            logger.warn("Transaction with ID {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }
}