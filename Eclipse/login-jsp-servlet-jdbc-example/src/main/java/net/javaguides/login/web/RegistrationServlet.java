package net.javaguides.login.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.login.bean.User;
import net.javaguides.login.database.LoginDao;


@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;
	
	public void init() {
		loginDao = new LoginDao();
	}
    
	public RegistrationServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fname-reg");
		String lname = request.getParameter("lname-reg");
		String phno = request.getParameter("phno-reg");
		String email = request.getParameter("email-reg");
		String pwd = request.getParameter("pass-reg");

		User user = new User(null, null, null, null, null, null);
        user.set_fname(fname);
		user.set_lname(lname);
		user.set_phno(phno);
		user.set_email(email);
        user.set_pass(pwd);

	
		
		
		
		
	}

}
