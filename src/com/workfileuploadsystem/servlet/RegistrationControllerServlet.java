package com.workfileuploadsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.workfileuploadsystem.bean.User;
import com.workfileuploadsystem.db.RegistrationDBUtil;


/**
 * Servlet implementation class RegistrationControllerServlet
 */
@WebServlet("/RegistrationControllerServlet")
public class RegistrationControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RegistrationDBUtil registrationDBUtil;
	
	@Resource(name="jdbc/work_file_upload_system")
	private DataSource dataSource;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Override
	public void init() throws ServletException {
		super.init();
		
		try{
			
			registrationDBUtil = new RegistrationDBUtil(dataSource);
		}catch(Exception ex){
			
			throw new ServletException(ex);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		try{
			
			//read "Command" parameter
			String theCommand = request.getParameter("command");
			
			//if the command is missing, then default to listing student
			if(theCommand == null){
				theCommand = "ADD";
			}
			//route the appropriate mathod
			
			switch(theCommand){
			
				
				
				case "ADD":
					
					addUser(request,response);
					break;
					
				
				default:
					addUser(request,response);
					
			}
		
		}catch(Exception ex){
			throw new ServletException(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
private void addUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
		// read student info from form data
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");	
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String ocupation = request.getParameter("occupation");
		
		String generatedPassword = null;
		
		try {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		
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
		
		// Create a new student object
		User theUser = new User(firstName, lastName, email, phone, generatedPassword,ocupation);
		
		// add the student to database
		registrationDBUtil.addUser(theUser);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
		// send back to the main page (Student list)
		//listStudent(request,response);
		
	}
}
