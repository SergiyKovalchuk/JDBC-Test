package com.jdbctest;

/**
 * Created by Hi-Tech on 08.05.2017.
 */
public class User {

    private int id, age;
    private String name, email;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(id: " + id
                + " name: " + name + " age" + age
                + " email: " + email + ")";
    }

    public User(){

    }

    public User(int id, String name, int age, String email){
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int geAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email= email;
    }
}
