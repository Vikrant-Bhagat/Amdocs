package com.amdocs.entities;

public class Customer {
	 private int customerid;
     private String name;
     private String email;
     
     
     public Customer(String name, String email) {
         this.name = name;
         this.email = email;
     }

     public int getcustomerid() {
         return customerid;
     }

     public String getName() {
         return name;
     }
     
     public String getEmail() {
         return email;
     }

     public void setName(String name) {
         this.name = name;
     }

     

     public void setEmail(String email) {
         this.email = email;
     }
   
	
	
}
