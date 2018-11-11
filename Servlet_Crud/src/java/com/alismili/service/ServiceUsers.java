/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alismili.service;

import com.alismili.models.User;
import java.util.List;

/**
 *
 * @author Ali
 */
public interface ServiceUsers {
    
        public List<User> usersQry();
	
	public void userIns(User user);
	
	public User userFnd(String name);
	
	public void userUpd(User user);
	
	public void userDel(String name);
	
	public String getMessage();
    
       

    
}
