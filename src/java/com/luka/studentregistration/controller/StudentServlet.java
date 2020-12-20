/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luka.studentregistration.controller;

import com.luka.studentregistration.dao.StudentDao;
import com.luka.studentregistration.model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP Z620
 */
@WebServlet("/")
public class StudentServlet extends HttpServlet{
 
     StudentDao studDao = new StudentDao();
    
     
  

     
    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{
        doGet(req, res);
    }





    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String action = req.getServletPath();
       switch(action)
       {
            case"/new":studentForm(req, res);
               break;
       
            case"/insert":insertStudent(req, res);
               break;
      
            case"/delete":deleteStudent(req, res);
               break;
         
            case"/edit":editForm(req, res);
               break;

            case"/update":updateStudent(req, res);
               break;
       
            default:studentList(req, res);
                break;
       }  
    
    
    
    }
    
    private void studentForm(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
         
        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        rd.forward(req, res);
     }
    
     private void insertStudent(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
           PrintWriter out = res.getWriter();
        String name = req.getParameter("sname");
        String password = req.getParameter("password");
        String address = req.getParameter("address");
        String contact = req.getParameter("pnumber");
         
        Student student = new Student(name,password,address,contact);
       
        studDao.insertStudent(student);
        req.setAttribute("student", student);
        res.sendRedirect("list");
       
     }
    
     private void deleteStudent(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
         
        int id = Integer.parseInt(req.getParameter("id"));
        studDao.deleteStudent(id);
        res.sendRedirect("list");
     }
    
       private void editForm(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = studDao.selectStudent(id);
        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        req.setAttribute("student", student);
        rd.forward(req, res);
     }

       
        private void updateStudent(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
         
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("sname");
        String password = req.getParameter("password");
        String address = req.getParameter("address");
        String contact = req.getParameter("pnumber");
         
        Student student = new Student(id,name,password,address,contact);
        studDao.updateStudent(student);
        res.sendRedirect("list");
     }
     
       
         private void studentList(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
      
        
        List<Student> students = studDao.selectAllStudents();
        req.setAttribute("students", students);
        RequestDispatcher rd = req.getRequestDispatcher("list.jsp");
        rd.forward(req, res);
       
         }
       
       
       
}





   