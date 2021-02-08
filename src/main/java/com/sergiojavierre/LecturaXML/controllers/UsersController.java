package com.sergiojavierre.LecturaXML.controllers;

import com.sergiojavierre.LecturaXML.dao.DAOFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {

    @GetMapping("/user")
    public String readUserHTML(Model model){
        model.addAttribute(DAOFactory.getInstance().getDaoUsers().read());
        return "user";
    }

}
