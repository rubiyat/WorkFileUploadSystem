package com.workfileuploadsystem.servlet;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;


import com.workfileuploadsystem.bean.User;
import com.workfileuploadsystem.db.LoginDBUtil;


/**
 * Servlet implementation class LoginControllerServlet
 */
@WebServlet("/LoginControllerServlet")
public class LoginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//private LoginDBUtil loginDBUtil;
	
	@Resource(name="jdbc/work_file_upload_system")
	private DataSource dataSource;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Override
	public void init() throws ServletException {
		super.init();
		
//		try{
//			
//			loginDBUtil = new LoginDBUtil(dataSource);
//		}catch(Exception ex){
//			
//			throw new ServletException(ex);
//		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 
		String userEmail = request.getParameter("userName");
        String userPass = request.getParameter("password");
        String userNameDB = null;
        String passwordDB = null;
        String firstName = null;
        
        
       String generatedPassword = null;
		
		try {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(userPass.getBytes());
		
		byte[] bytes = md.digest();
		
		StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++)
        {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }   generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        
        
        Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		HttpSession session = request.getSession(true);
		 
		 try{
			 
			myConn = dataSource.getConnection();
			String sql = "SELECT * FROM users WHERE user_email='"+userEmail+"' AND password='"+generatedPassword+"'";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			while(myRs.next()){
				firstName = myRs.getString("user_firstname");
			    userNameDB = myRs.getString("user_email");
			    passwordDB = myRs.getString("password");
			   
			}
			
			if(userEmail.equals(userNameDB) || generatedPassword.equals(passwordDB)){
				session.setAttribute("firstName", firstName);
				//request.setAttribute("err", "");
				RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
				dispatcher.forward(request, response);
				 
			   }else{
				   request.setAttribute("err", "Login Failed");
				   RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
				   dispatcher.forward(request, response);
				
			   }
			
		
		 }catch(SQLException se){
			 se.printStackTrace();
		 }
	}

}
