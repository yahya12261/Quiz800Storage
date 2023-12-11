package com.example.Storge.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Storge.Models.Transaction;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}