/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luka.studentregistration.dao;

import com.luka.studentregistration.model.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP Z620
 */
public class StudentDao {
    

    
    private static final String INSERT_STUDENTS = "insert into students(name,password,address,contact)values(?,md5(?),?,?)";
    private static final String SELECT_ALL_STUDENTS = "select * from students";
    private static final String SELECT_STUDENT_BY_ID = "select id,name,password,address,contact from students where id=?";
    private static final String DELETE_STUDENT = "delete from students where id=?";
    private static final String UPDATE_STUDENT = "update students set name=?,password=?,address=?,contact=? where id=?";


  
    

    public void insertStudent(Student student){
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(INSERT_STUDENTS);
            pst.setString(1, student.getName());
            pst.setString(2, student.getPassword());
            pst.setString(3, student.getAddress());
            pst.setString(4, student.getContact());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    } 
   

    public List<Student> selectAllStudents(){
            
            List<Student>students = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(SELECT_ALL_STUDENTS);   
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
               int id = rs.getInt("id");
               String name = rs.getString("name");
               String password = rs.getString("password");
               String address = rs.getString("address");
               String contact = rs.getString("contact");
               students.add(new Student(id,name,password,address,contact));
            }       
        }   catch (SQLException ex) {
                ex.printStackTrace();
        }       
            return students;
    }  
    
    
    public Student selectStudent(int id){
     
            Student student = null;
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(SELECT_STUDENT_BY_ID);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
               String name = rs.getString("name");
               String password = rs.getString("password");
               String address = rs.getString("address");
               String contact = rs.getString("contact");
               student = new Student(id,name,password,address,contact);
            } 
        }   catch (SQLException ex) {
              ex.printStackTrace();
        }
            return student;
    }


    public boolean updateStudent(Student student){
        
            boolean studdUpdated = false ;
        try {   
            Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(UPDATE_STUDENT);
            pst.setString(1, student.getName());
            pst.setString(2, student.getPassword());
            pst.setString(3, student.getAddress());
            pst.setString(4, student.getContact());
            pst.setInt(5, student.getId());
           
            studdUpdated = pst.executeUpdate() > 0;
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
            return studdUpdated;
             
    }


    public boolean deleteStudent(int id){
         
            boolean studdDelete = false;
        try {  
            Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(DELETE_STUDENT);
            pst.setInt(1, id);
            studdDelete = pst.executeUpdate()>0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            return studdDelete;
    } 

}
