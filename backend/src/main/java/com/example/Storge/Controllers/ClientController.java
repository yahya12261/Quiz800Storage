package com.example.Storge.Controllers;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.example.Storge.Models.Client;
import com.example.Storge.Repositories.ClientRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
public class ClientController {
    private static final Logger logger = Logger.getLogger(ClientController.class.getName());
        @Autowired
        ClientRepository clientRepository;
        @GetMapping("/Client")
        public List<Client> getClients() {
            logger.info("Getting all clients");
            return clientRepository.findAll();
        }
        
        @PostMapping("/Client")
        public Client createClient(@RequestBody Client client) {
            logger.info("Creating a new client: " + client.getName());
            return clientRepository.save(client);
        }
    @PutMapping("/Client/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable int id, @RequestBody Client updatedClient) {
        logger.info("Updating client with ID: " + id);
    
        // Log the updated client details
        logger.info("Updated client details: " + updatedClient);
    
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client existingClient = optionalClient.get();
            existingClient.setName(updatedClient.getName());
            existingClient.setLastName(updatedClient.getLastName());
            existingClient.setMobile(updatedClient.getMobile());
            logger.info("Existing client details: " + existingClient);
            Client savedClient = clientRepository.save(existingClient);
            logger.info("Saved client details: " + savedClient);
            return ResponseEntity.ok(savedClient);
        } else {
            logger.warning("Client with ID " + id + " not found");
            return ResponseEntity.notFound().build();
        }
    }
}
