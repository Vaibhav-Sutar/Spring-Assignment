package com.example.crudtask_accio.dto.Request;


public class JwtRequest {

    private String email;
    private String password;

    public JwtRequest() {
    }

    public JwtRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static JwtRequestBuilder builder() {
        return new JwtRequestBuilder();
    }

    public static class JwtRequestBuilder {
        private String email;
        private String password;

        public JwtRequestBuilder email(String email) {
            this.email = email;
            return this;
        }

        public JwtRequestBuilder password(String password) {
            this.password = password;
            return this;
        }

        public JwtRequest build() {
            return new JwtRequest(email, password);
        }
    }
}