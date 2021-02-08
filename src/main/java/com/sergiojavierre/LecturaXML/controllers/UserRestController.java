package com.sergiojavierre.LecturaXML.controllers;

import com.sergiojavierre.LecturaXML.dao.DAOFactory;
import com.sergiojavierre.LecturaXML.entities.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @RequestMapping("/")
    public String index(){
        return "Hola estudiantes";
    }

    @RequestMapping("/escritura")
    public String write(){
        User user = new User("sergio","1234");
        DAOFactory.getInstance().getDaoUsers().save(user);
        return user.getEmail();
    }

    @RequestMapping("/lecturaString")
    public String readString(){
        return DAOFactory.getInstance().getDaoUsers().read().toString();
    }

    @RequestMapping("/lecturaXML")
    public User readXML(){
        return DAOFactory.getInstance().getDaoUsers().read();
    }

}
