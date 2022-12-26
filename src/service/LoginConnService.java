/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connexion.Connexion;
import entities.LoginConn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yoaim
 */
public class LoginConnService {
    
    public LoginConnService() {
        
    }
    
    public boolean seConnecter(String login,String password){
        for(LoginConn l : this.findAll()){
            if(l.getLogin()== login && l.getPassword() == password){
            return true;
            }
        }
    return true;
    }
    
    public List<LoginConn> findAll(){
        List<LoginConn> list = new ArrayList<>();
        try {
            String query ="select * from loginconn";
            
            PreparedStatement preparedStatement = Connexion.getConnection().prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                list.add(new LoginConn(resultSet.getInt("id"),resultSet.getString("login"),resultSet.getString("password")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginConnService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
