/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luka.studentregistration.model;

/**
 *
 * @author HP Z620
 */
public class Student {
    private int id;
    private String name;
    private String password;
    private String address;
    private String contact;

    public Student() {
    }

    public Student(int id, String name, String password, String address, String contact) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.address = address;
        this.contact = contact;
    }

    public Student(String name, String password, String address, String contact) {
        this.name = name;
        this.password = password;
        this.address = address;
        this.contact = contact;
    }

    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", password=" + password + ", address=" + address + ", contact=" + contact + '}';
    }

    
}
