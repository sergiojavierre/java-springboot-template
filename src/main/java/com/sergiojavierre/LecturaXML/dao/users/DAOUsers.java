package com.sergiojavierre.LecturaXML.dao.users;

import com.sergiojavierre.LecturaXML.entities.User;

public interface DAOUsers {

    public void save(User user);
    public User read();

}
