/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luka.studentregistration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP Z620
 */
public class DBConnection {
    
    private static Connection conn;
    
     private DBConnection(){};
     
     public static Connection getConnection(){
        try { 
              if(conn == null) {
                   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "root");
            }
          } catch (SQLException ex) {
                ex.printStackTrace();
             }
         
        return conn;
     }
}
