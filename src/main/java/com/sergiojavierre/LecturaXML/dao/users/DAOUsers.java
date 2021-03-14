package com.sergiojavierre.LecturaXML.dao.users;

import com.sergiojavierre.LecturaXML.entities.Book;
import com.sergiojavierre.LecturaXML.entities.User;

import java.util.List;

public interface DAOUsers {

    public Integer add(User user);
    public List<User> getAll();
    public User search(Integer id);
    public void add(Integer id, Book book);

}
