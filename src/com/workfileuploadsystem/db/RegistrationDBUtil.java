package com.workfileuploadsystem.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.workfileuploadsystem.bean.User;

public class RegistrationDBUtil {
	
	private DataSource dataSource;

	public RegistrationDBUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}

public void addUser(User theUser) throws Exception{
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into users "
					   + "(user_firstname,user_lastname,user_email,user_phone,password,user_occupation) "
					   + "values (?,?,?,?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the student
			myStmt.setString(1, theUser.getFirstName());
			myStmt.setString(2, theUser.getLastName());			
			myStmt.setString(3, theUser.getEmail());
			myStmt.setString(4, theUser.getPhone());
			myStmt.setString(5, theUser.getPassword());
			myStmt.setString(6, theUser.getOccupation());
			
			// execute sql insert
			myStmt.execute();
			
		}catch(Exception ex){
			
			ex.printStackTrace();
	  }finally {
			// clean up JDBC objects
			//Close(myConn,myStmt,null);
		}

	}


}
