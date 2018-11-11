/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alismili.models;

import java.io.Serializable;

/**
 *
 * @author Ali
 */
public class User implements Serializable {
    private String name;
    private String password;
    private String email;
    private int levelAccess;
    private boolean baned;

    public User(String name, String password, String email, int levelAccess, boolean baned) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.levelAccess = levelAccess;
        this.baned = baned;
    }
    
     public User() {
     
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLevelAccess() {
        return levelAccess;
    }

    public void setLevelAccess(int levelAcces) {
        this.levelAccess = levelAcces;
    }

    public boolean isBaned() {
        return baned;
    }

    public void setBaned(boolean baned) {
        this.baned = baned;
    }

    
    
}
