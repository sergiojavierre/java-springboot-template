package com.sergiojavierre.LecturaXML.dao.users;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sergiojavierre.LecturaXML.entities.User;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DAOUsersXML implements DAOUsers{
    @Override
    public void save(User user) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writeValue(new File("user.xml"), user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User read() {
        User user = null;
        XmlMapper xmlMapper = new XmlMapper();
        try {
            String xml = new String(Files.readAllBytes(Path.of("user.xml")));
            user = xmlMapper.readValue(xml, User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}
