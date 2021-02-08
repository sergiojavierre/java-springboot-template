package com.sergiojavierre.LecturaXML.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class User {

    @JacksonXmlProperty(isAttribute = true)
    private String email;
    @JacksonXmlProperty(isAttribute = true)
    private String password;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
