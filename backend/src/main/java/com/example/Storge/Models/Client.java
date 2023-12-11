package com.example.Storge.Models;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@Table(name = "client")


public class Client {
    // Fetch clients and view id, name, last name, mobile.
    @Id
    @GeneratedValue
    private int id ;
    private String name ;
    private String lastName;
    private String mobile;
    public Client(int id , String name , String lastName , String mobile){
        this.id = id;
        this.name = name ; 
        this.lastName = lastName ; 
        this.mobile = mobile;

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
        
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getLastName() {
            return this.lastName;
        }
        
        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getMobile() {
            return this.mobile;
        }
            

}
