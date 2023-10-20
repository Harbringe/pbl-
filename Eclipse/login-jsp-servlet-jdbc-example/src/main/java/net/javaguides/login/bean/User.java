package net.javaguides.login.bean;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private String fname;
    private String lname;
    private String email;
    private String pass;
    private String phno;

    // Payment method pending
    private String type;

    public User(String fname, String lname, String email, String pass, String phno, String type2){
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.pass = pass;
        this.phno = phno;
        this.type = type2;
    }


    public void set_fname(String fname){
        this.fname=fname;
    }   
    public String get_fname(){
        return this.fname;
    }
    
    public void set_lname(String lname){
        this.lname=lname;
    }   
    public String get_lname(){
        return this.lname;
    }

    public void set_email(String email){
        this.email=email;
    }   
    public String get_email(){
        return this.email;
    }

    public void set_pass(String pass){
        this.pass=pass;
    }   
    public String get_pass(){
        return this.pass;
    }

    public void set_phno(String phno){
        this.phno = phno;
    }   
    public String get_phno(){
        return this.phno;
    }

    public void set_type(String type){
        this.type=type;
    }   
    public String get_type(){
        return this.type;
    }    

}
