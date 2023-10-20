package net.javaguides.login.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import net.javaguides.login.bean.User;
import net.javaguides.login.database.LoginDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String email = request.getParameter("email-login");
        String password = request.getParameter("pass-login");
        User user = new User(null, null, null, null, null, null);
        user.set_email(email);
        user.set_pass(password);
        System.out.println("hello");
        System.out.println(user.get_email());
        System.out.println(user.get_pass());
        
        try{
        if (loginDao.validate(user)) {
            HttpSession session = request.getSession();
            session.setAttribute("email",email);
            response.sendRedirect("loginsuccess.jsp");
        } else {
            HttpSession session = request.getSession();
            //session.setAttribute("user", username);
            response.sendRedirect("login.jsp");
        }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
