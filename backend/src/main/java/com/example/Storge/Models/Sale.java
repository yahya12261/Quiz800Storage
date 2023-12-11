package com.example.Storge.Models;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Data
/**
 * @param id
 * @param name
 * @param lastName
 * @param mobile
 */

@NoArgsConstructor
@Entity
@Table(name = "sale")
public class Sale {

        @Id
        @GeneratedValue
        private int id;
        private Date date;
          @ManyToOne
            @JoinColumn(name = "client_id")
            private Client client;
            private int saller;
            @Transient
    private double total;

    @OneToMany(mappedBy = "sale")
    private List<Transaction> transactions;

    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public double getTotal() {
        if (transactions != null) {
            total = transactions.stream()
                    .mapToDouble(transaction -> transaction.getPrice() * transaction.getQuantity())
                    .sum();
        }
        return total;
    }
 

            public void setTotal(double total) {
                this.total = total;
            }



        public Client getClient() {
            return this.client;
        }

        public void setClient(Client client) {
            this.client = client;
        }

        public int getSaller() {
            return this.saller;
        }

        public void setSaller(int saller) {
            this.saller = saller;
        }

          
            public Sale( int saller,double total){
                this.date = new Date();
                this.saller = saller;
                this.total=total;
            }
       

    }