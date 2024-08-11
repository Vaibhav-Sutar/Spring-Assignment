package com.example.crudtask_accio.dto.Responce;
import java.util.Date;

public class CustomerResponseDto {

    private String Uid;
    private String message;
    private Date joinedOn;
    private String firstName;
    private String lastName;
    private String street;
    private String address;
    private String city;
    private String state;
    private String email;
    private String phone;

    public CustomerResponseDto() {
    }

    public CustomerResponseDto(String Uid, String message, Date joinedOn, String firstName, String lastName, String street, String address, String city, String state, String email, String phone) {
        this.Uid = Uid;
        this.message = message;
        this.joinedOn = joinedOn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.address = address;
        this.city = city;
        this.state = state;
        this.email = email;
        this.phone = phone;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String Uid) {
        this.Uid = Uid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static customerResponseDtoBuilder builder() {
        return new customerResponseDtoBuilder();
    }

    public static class customerResponseDtoBuilder {
        private String Uid;
        private String message;
        private Date joinedOn;
        private String firstName;
        private String lastName;
        private String street;
        private String address;
        private String city;
        private String state;
        private String email;
        private String phone;

        public customerResponseDtoBuilder Uid(String Uid) {
            this.Uid = Uid;
            return this;
        }

        public customerResponseDtoBuilder message(String message) {
            this.message = message;
            return this;
        }

        public customerResponseDtoBuilder joinedOn(Date joinedOn) {
            this.joinedOn = joinedOn;
            return this;
        }

        public customerResponseDtoBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public customerResponseDtoBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public customerResponseDtoBuilder street(String street) {
            this.street = street;
            return this;
        }

        public customerResponseDtoBuilder address(String address) {
            this.address = address;
            return this;
        }

        public customerResponseDtoBuilder city(String city) {
            this.city = city;
            return this;
        }

        public customerResponseDtoBuilder state(String state) {
            this.state = state;
            return this;
        }

        public customerResponseDtoBuilder email(String email) {
            this.email = email;
            return this;
        }

        public customerResponseDtoBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public CustomerResponseDto build() {
            return new CustomerResponseDto(Uid, message, joinedOn, firstName, lastName, street, address, city, state, email, phone);
        }
    }

    // toString method
    @Override
    public String toString() {
        return "customerResponseDto{" +
                "Uid='" + Uid + '\'' +
                ", message='" + message + '\'' +
                ", joinedOn=" + joinedOn +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", street='" + street + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
