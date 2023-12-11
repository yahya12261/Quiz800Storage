package com.example.Storge.Models;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Data
/**
 * @param id
 * @param name
 * @param description
 * @param category
 * @param creationDate
 */

@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
  

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private String category;
    private Date CreationDate;

    public Product(int id , String name, String description ,String category,Date CreationDate){
        this.id = id; 
        this.name = name ;
        this.description = description;
        this.category = category ;
        this.CreationDate = CreationDate;
    }
        public void setId(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }
        
        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
        
        public void setDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return this.description;
        }
        
        public void setCategory(String category) {
            this.category = category;
        }

        public String getCategory() {
            return this.category;
        }
        
        public void setCreationDate(Date CreationDate) {
            this.CreationDate = CreationDate;
        }

        public Date getCreationDate() {
            return this.CreationDate;
        }
          

    
}