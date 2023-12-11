package com.example.Storge.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Storge.Models.Sale;
@Repository
public interface SaleRepository extends JpaRepository<Sale,Integer> {
}

