package com.sergiojavierre.LecturaXML.controllers;

import com.sergiojavierre.LecturaXML.dao.DAOFactory;
import com.sergiojavierre.LecturaXML.entities.Book;
import com.sergiojavierre.LecturaXML.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UsersController {

    @GetMapping("/users")
    public String readUsers(Model model){
        model.addAttribute("users",DAOFactory.getInstance().getDaoUsers().getAll());
        return "users";
    }

    @GetMapping("/user")
    public String readUser(Model model, @RequestParam Integer id){
        model.addAttribute("users", List.of(DAOFactory.getInstance().getDaoUsers().search(id)));
        return "users";
    }

    @GetMapping("/addUser")
    public String addUser(Model model, @RequestParam String email, @RequestParam String password){
        User user = new User(email,password);
        DAOFactory.getInstance().getDaoUsers().add(user);
        //aquí crearemos la vista que queramos para el usuario añadido correctamente
        return "users";
    }

    @GetMapping("/addBookToUser")
    public String addBookToUser(Model model, @RequestParam Integer id, @RequestParam String title){
        DAOFactory.getInstance().getDaoUsers().add(id,new Book(title));
        //lo mismo para el libro añadido
        return "users";
    }
}
