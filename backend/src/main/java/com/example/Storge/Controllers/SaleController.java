package com.example.Storge.Controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Storge.Models.Sale;
import com.example.Storge.Models.Transaction;
import com.example.Storge.Repositories.SaleRepository;
import com.example.Storge.Repositories.TransactionRepository;

@RestController
public class SaleController {
    private static final Logger logger = Logger.getLogger(SaleController.class.getName());

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping("/Sale")
    public List<Sale> getSales() {
        logger.info("Getting all sales");
        return saleRepository.findAll();
    }

    @PostMapping("/Sale")
    public ResponseEntity<Sale> createSale(@RequestBody Sale sale) {
        logger.info("Creating a new sale");

        Sale savedSale = saleRepository.save(sale);
        List<Transaction> transactions = sale.getTransactions();
        if (transactions != null) {
            for (Transaction transaction : transactions) {
                transaction.setSale(savedSale);
                transactionRepository.save(transaction);
            }
        }

        logger.info("Sale created successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSale);
    }
}