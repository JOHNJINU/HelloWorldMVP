package com.imm.helloworldmvp.model;

public class User {

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String fullname="", email = "";

    public User(){

    }

    public User(String fullName, String email){
        this.fullname = fullName;
        this.email = email;
    }

    public String toString(){

        return "User name " + fullname  + "\n" + "Email " + email ;
    }


}


