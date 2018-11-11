/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alismili.dao;

import com.alismili.conection.ConectDb;
import com.alismili.models.User;
import com.alismili.service.ServiceUsers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Ali
 */
public class ServiceUserImpl implements ServiceUsers {
    
    private final ConectDb db;
	private String message;
	
	public ServiceUserImpl() {
		this.db = new ConectDb();
	}

	@Override
	public List<User> usersQry() {
		List<User> list = null;
		
		String sql = "SELECT nombre, contraseña, email, nivelAcceso, baneado FROM usuario";
		
		Connection cn = db.getConnection();
		
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(sql);
				
				ResultSet rs = ps.executeQuery();
				list = new LinkedList<User>();
				while (rs.next()) {
					User user = new User();
					user.setName(rs.getString(1));
					user.setPassword(rs.getString(2));
					user.setEmail(rs.getString(3));
					user.setLevelAccess(rs.getInt(4));
                                        user.setBaned(rs.getBoolean(5));
					
					list.add(user);
				}
				ps.close();
				
			} catch (SQLException e) {
				setMessage("Problems for listing: " + e.getMessage());
			} finally {
				try {
					cn.close();
				} catch (SQLException ex) {
					setMessage(ex.getMessage());
				}
			}
		} else {
			setMessage("Error in conexion: " + db.getMessage());
		}
		
		return list;
	}

	@Override
	public void userIns(User user) {
		String sql = "INSERT INTO usuario(nombre, contraseña, email, nivelAcceso, baneado) VALUES(?,?,?,?,?)";
		
		Connection cn = db.getConnection();
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(sql);
				
				ps.setString(1, user.getName());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getEmail());
				ps.setInt(4, user.getLevelAccess());
                                ps.setBoolean(5, user.isBaned());
				int exec = ps.executeUpdate();
				
				if (exec == 0) {
					throw new SQLException();
				}
				ps.close();
				
			} catch (SQLException e) {
				setMessage("Problems for inserting: " + e.getMessage());
                        
			} finally {
				try {
					cn .close();
				} catch (SQLException ex) {
					setMessage(ex.getMessage());
				}
			}
		} else {
			setMessage("Error in conexion: " + db.getMessage());
		}
		
	}

	@Override
	public User userFnd(String name) {
		User user = null;
		
		String sql = "SELECT nombre, contraseña, email, nivelAcceso, baneado FROM usuario WHERE nombre=?";
		
		Connection cn = db.getConnection();
		
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(sql);
				
				ps.setString(1, name);
				
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					user = new User();
					
					user.setName(rs.getString(1));
					user.setPassword(rs.getString(2));
					user.setEmail(rs.getString(3));
					user.setLevelAccess(rs.getInt(4));
                                        user.setBaned(rs.getBoolean(5));
				}
				ps.close();
                                				
			} catch (SQLException e) {
				setMessage("Problems for consulting: " + e.getMessage());
			} finally {
				try {
					cn.close();
				} catch (SQLException ex) {
					setMessage(ex.getMessage());
				}
			}
		} else {
			setMessage("Error in conexion: " + db.getMessage());
		}
		return user;
	}

	@Override
	public void userUpd(User user) {
		String sql = "UPDATE usuario SET  contraseña=?, email=?, nivelAcceso=?, baneado=?  WHERE nombre=?"; //WHERE nombre=?
		
		Connection cn = db.getConnection();
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(sql);
				
				
				ps.setString(1, user.getPassword());
				ps.setString(2, user.getEmail());
				ps.setInt(3, user.getLevelAccess());
                                ps.setBoolean(4, user.isBaned());
                                ps.setString(5, user.getName());
				
				int exec = ps.executeUpdate();
				
				if (exec == 0) {
					throw new SQLException();
					
				}
				ps.close();
				
			} catch (SQLException e) {
				setMessage("Problems for updating: " + e.getMessage());
			} finally {
				try {
					cn .close();
				} catch (SQLException ex) {
					setMessage(ex.getMessage());
				}
			}
		} else {
			setMessage("Error in conexion: " + db.getMessage());
		}
		
	}

	@Override
	public void userDel(String name) {
		String sql = "DELETE FROM usuario WHERE nombre=?";
		
		Connection cn = db.getConnection();
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(sql);

				ps.setString(1, name);
				
				int exec = ps.executeUpdate();
				
				if (exec == 0) {
					throw new SQLException();
				}
				ps.close();
				
			} catch (SQLException e) {
				setMessage("Problems for deleting: " + e.getMessage());
			} finally {
				try {
					cn .close();
				} catch (SQLException ex) {
					setMessage(ex.getMessage());
				}
			}
		} else {
			setMessage("Error in conexion: " + db.getMessage());
		}
		
	}

	@Override
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
}
    
}
