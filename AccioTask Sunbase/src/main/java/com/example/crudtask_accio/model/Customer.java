package com.example.crudtask_accio.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String Uid;

    @Column(nullable = false, unique = true)
    private String email;

    @CreationTimestamp
    private Date joinedOn;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String street;

    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false, unique = true)
    private String phone;

    // No-argument constructor
    public Customer() {
    }

    // All-arguments constructor
    public Customer(int id, String Uid, String email, Date joinedOn, String firstName, String lastName, String street, String address, String city, String state, String phone) {
        this.id = id;
        this.Uid = Uid;
        this.email = email;
        this.joinedOn = joinedOn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.address = address;
        this.city = city;
        this.state = state;
        this.phone = phone;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String Uid) {
        this.Uid = Uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getJoinedOn() {
        return joinedOn;
    }

    public void setJoinedOn(Date joinedOn) {
        this.joinedOn = joinedOn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Builder pattern for Customer
    public static CustomerBuilder builder() {
        return new CustomerBuilder();
    }

    // Inner static class for builder
    public static class CustomerBuilder {
        private int id;
        private String Uid;
        private String email;
        private Date joinedOn;
        private String firstName;
        private String lastName;
        private String street;
        private String address;
        private String city;
        private String state;
        private String phone;

        public CustomerBuilder id(int id) {
            this.id = id;
            return this;
        }

        public CustomerBuilder Uid(String Uid) {
            this.Uid = Uid;
            return this;
        }

        public CustomerBuilder email(String email) {
            this.email = email;
            return this;
        }

        public CustomerBuilder joinedOn(Date joinedOn) {
            this.joinedOn = joinedOn;
            return this;
        }

        public CustomerBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public CustomerBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public CustomerBuilder street(String street) {
            this.street = street;
            return this;
        }

        public CustomerBuilder address(String address) {
            this.address = address;
            return this;
        }

        public CustomerBuilder city(String city) {
            this.city = city;
            return this;
        }

        public CustomerBuilder state(String state) {
            this.state = state;
            return this;
        }

        public CustomerBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Customer build() {
            return new Customer(id, Uid, email, joinedOn, firstName, lastName, street, address, city, state, phone);
        }
    }

    // toString method
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", Uid='" + Uid + '\'' +
                ", email='" + email + '\'' +
                ", joinedOn=" + joinedOn +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", street='" + street + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
