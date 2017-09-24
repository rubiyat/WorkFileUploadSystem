package com.workfileuploadsystem.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.workfileuploadsystem.bean.User;

public class LoginDBUtil {

	private DataSource dataSource;

	public LoginDBUtil(DataSource theDataSource) {
		
		dataSource = theDataSource;
	}
	
public List<User> getUser() throws Exception{
		
		List<User> users = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try{
			// get a connection
			myConn =  dataSource.getConnection();
			
			// Create a sql statement
			String sql = "SELECT * FROM users";
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process a result set
			while(myRs.next()){
				// retrive data from result set row
				String firstName = myRs.getString("user_firstname");
				String lastName = myRs.getString("user_lastname");
				String email = myRs.getString("user_email");
				String phone = myRs.getString("user_phone");
				String password = myRs.getString("password");
				String occupation = myRs.getString("user_occupation");
				// create new student object
				User theUser = new User(firstName,lastName,email,phone,password,occupation);
				
				// add it to the list of students
				users.add(theUser);
			}
			
			return users;
			
		}finally{
			
//			// close JDBC objects
//			Close(myConn,myStmt,myRs);
			
		}
		
	}
	
	
}
