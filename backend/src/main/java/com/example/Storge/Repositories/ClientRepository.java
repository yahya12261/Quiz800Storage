package com.example.Storge.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Storge.Models.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {
    
}
