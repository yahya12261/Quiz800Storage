package com.example.Storge.Models;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @JsonIgnore
     @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;
    private int quantity;
    private double price;

        public Transaction(int id ,Product product, Sale sale , int Qty ,double price){
            this.id = id ; 
            this.product = product ;
            this.sale = sale; 
            this.quantity = Qty ; 
            this.price = price;
        }

 public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

   public Product getProduct() {
       return this.product;
   }

   public void setProduct(Product product) {
       this.product = product;
   }

   public int getQuantity() {
       return this.quantity;
   }

   public void setQuantity(int quantity) {
       this.quantity = quantity;
   }

   public double getPrice() {
       return this.price;
   }

   public void setPrice(double price) {
       this.price = price;
   }

   

    public Sale getSale() {
        return this.sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

}