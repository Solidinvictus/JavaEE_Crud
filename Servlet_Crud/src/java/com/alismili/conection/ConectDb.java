/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alismili.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ali
 */
public class ConectDb {
    
    private final String database;
    private String message;

    public Connection getConnection() {
        Connection cn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + database,
                    "root", "cenec");

        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            setMessage(ex.getMessage());
        }

        return cn;
    }

    public ConectDb() {
        this.database = "accesoseguro";
    }

    public ConectDb(String database) {
        this.database = database;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
}
    
}
