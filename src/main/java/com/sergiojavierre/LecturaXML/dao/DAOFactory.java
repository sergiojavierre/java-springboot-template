package com.sergiojavierre.LecturaXML.dao;

import com.sergiojavierre.LecturaXML.dao.users.DAOUsers;
import com.sergiojavierre.LecturaXML.dao.users.DAOUsersXML;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOUsers daoUsers;

    private DAOFactory(){}

    public static DAOFactory getInstance() {
        if(daoFactory == null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public DAOUsers getDaoUsers() {
        if(daoUsers == null){
            daoUsers = new DAOUsersXML();
        }
        return daoUsers;
    }
}
