package net.javaguides.login.database;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.javaguides.login.bean.User;

public class LoginDao {

	public boolean validate(User user) throws ClassNotFoundException {
	    boolean status = false;

	    Class.forName("com.mysql.jdbc.Driver");

	    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users?useSSL=false", "root", "root");
	        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM loginusers WHERE email = ? AND password_hash = ? ")) {
	        preparedStatement.setString(1, user.get_email());
	        preparedStatement.setString(2, user.get_pass());

	        System.out.println(preparedStatement);
	        ResultSet rs = preparedStatement.executeQuery();
	        status = rs.next();

	    } catch (SQLException e) {
	        // process sql exception
	        printSQLException(e);
	        e.printStackTrace();
	    }
	    return status;
	}


    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    
    public User findUser(String email, String password) throws ClassNotFoundException {
        User user = null;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users?useSSL=false", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from loginusers where email = ? and password = ? ")) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs.next()) {
                // User found, load their data into a User object
                String fname = rs.getString("first_name");
                String lname = rs.getString("last_name");
                String phno = rs.getString("phone_number");
                String type = rs.getString("user_type");
                // Continue retrieving other columns as needed

                // Create a new User object with the retrieved data
                user = new User(fname, lname, email, password, phno, type);
                // Set other properties of the User object as needed
            }
        } catch (SQLException e) {
            // Process SQL exception
            printSQLException(e);
        }
        
        return user;
    }
    

    public void update(User user, Connection con)throws SQLException{
        
        try {
            String sql = "INSERT INTO loginusers (first_name, last_name, email, password_hash, phone_number, user_type) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);    
            statement.setString(1, user.get_fname());
            statement.setString(2, user.get_lname());
            statement.setString(3, user.get_email());
            statement.setString(4, user.get_pass());
            statement.setString(5, user.get_phno());
            statement.setString(6, user.get_type());
            statement.executeUpdate();
            System.out.println("Record created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
            
    }  
    
    public void delete(User user, Connection con)throws SQLException{
        try{     
            String sql = "DELETE FROM loginusers WHERE email = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, user.get_email());
            statement.executeUpdate();  
            System.out.println("Record deleted successfully.");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
    
}