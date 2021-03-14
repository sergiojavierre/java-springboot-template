package com.sergiojavierre.LecturaXML.dao.users;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sergiojavierre.LecturaXML.entities.Book;
import com.sergiojavierre.LecturaXML.entities.User;
import com.sergiojavierre.LecturaXML.entities.Data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DAOUsersXML implements DAOUsers{

    private final String file = "users.xml";

    @Override
    public Integer add(User user) {
        List<User>users = new ArrayList<>();
        User previous = new User("sergio@a.a","13");
        previous.add(new Book("Harry Potter"));
        users.add(previous);
        int lastId = users.get(users.size()-1).getId(); // tomo el último
        User.nextId = lastId + 1;
        user.setId(User.nextId);
        users.add(user);
        save(users);
        return User.nextId;
    }

    private void save(List<User> users){
        Data dataContainer = new Data(users);
        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writeValue(new File(file), dataContainer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {
        Data data = new Data(null);
        XmlMapper xmlMapper = new XmlMapper();
        try {
            String xml = new String(Files.readAllBytes(Path.of(file)));
            data = xmlMapper.readValue(xml, Data.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.getUsers();
    }

    @Override
    public User search(Integer id) {
        List<User> users = getAll();
        Optional<User> posibleUser = users.stream().filter(user->{
            return user.getId().equals(id);
        }).findFirst();
        return posibleUser.orElse(null);
    }

    @Override
    public void add(Integer id, Book book) {
        List<User> users = getAll();
        Optional<User> posibleUser = users.stream().filter(user->{
            return user.getId().equals(id);
        }).findFirst();
        posibleUser.ifPresent(user -> user.add(book));
        save(users);
    }
}
