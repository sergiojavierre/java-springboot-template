package com.sergiojavierre.LecturaXML.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;
@JacksonXmlRootElement(localName = "user")
public class User {

    public static Integer nextId = 1;

    @JacksonXmlProperty(isAttribute = true)
    private Integer id;
    @JacksonXmlProperty(isAttribute = true)
    private String email;
    @JacksonXmlProperty(isAttribute = true)
    private String password;

    @JacksonXmlElementWrapper(localName = "books")
    @JacksonXmlProperty(localName = "book")
    List<Book> books = new ArrayList<>();

    public User() {
    }

    public User(String email, String password) {
        this.id = nextId;
        this.email = email;
        this.password = password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void add(Book book){
        if(this.books == null){
            this.books = new ArrayList<>();
        }
        books.add(book);
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
