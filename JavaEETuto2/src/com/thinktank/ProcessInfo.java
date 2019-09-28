package com.thinktank;
 
import java.io.IOException;
 
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/ProcessInfo")
public class ProcessInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProcessInfo() {
        super();
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// The URL to send data to (JSP FILE)
		String url = "/DisplayInfo.jsp";
		
		// NEW Error message to display on the screen
		//String errorMsg = "";
		
		// DATABASE EXAMPLE
		// NEW Add new data
		// Get the data entered on index.jsp
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		
		if(!regexChecker("^[A-Za-z\\.\\’ \\-]{2,30}$", fName)) {
			url = "/index.jsp";
			fName = "Try again";
		}
		
		if(!regexChecker("^[A-Za-z\\.\\’ \\-]{2,30}$", lName)) {
			url = "/index.jsp";
			lName = "Try again";
		}
		
		if(!regexChecker("^[A-Za-z0-9\\.\\’ \\-]{5,50}$", street)) {
			url = "/index.jsp";
			street = "Try again";
		}
		
		if(!regexChecker("^[A-Za-z\\.\\’ \\-]{5,30}$", city)) {
			url = "/index.jsp";
			city = "Try again";
		}
		
		if(!regexChecker("^(?:(A[KLRZ]|C[AOT]|D[CE]|FL|GA|HI|I[ADLN]|K[SY]|LA|M[ADEINOST]|N[CDEHJMVY]|O[HKR]|P[AR]|RI|S[CD]|T[NX]|UT|V[AIT]|W[AIVY]))$", state)) {
			url = "/index.jsp";
			state = "Try again";
		}
		
		if(!regexChecker("^[0-9\\-]{5,10}$", zipcode)) {
			url = "/index.jsp";
			zipcode = "Try again";
		}
		
		if(!regexChecker("^[A-Za-z0-9._\\%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$", email)) {
			url = "/index.jsp";
			email = "Try again";
		}
		
		// Must have 1 uppercase, 1 lowercase, 1 number and a special
		if(!regexChecker("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$", password)) {
			url = "/index.jsp";
			password = "Try again";
		}
		
		if(!regexChecker("^([0-9]( |-)?)?(\\(?[0-9]{3}\\)?|[0-9]{3})( |-)?([0-9]{3}( |-)?[0-9]{4}|[0-9]{7})$", phone)) {
			url = "/index.jsp";
			phone = "Try again";
		}
		
		
		// NEW Update the DB
		if(!url.equals("/index.jsp")) {
			updateDB(fName, lName, street, city, state, zipcode, email, password, phone);
		}
		
		// NEW Create object to pass to DisplayInfo.jsp
		Customer cust = new Customer(fName, lName, street, city, 
				state, zipcode, email, password, phone);
		request.setAttribute("cust", cust);
		
		// Forward data to DisplayInfo.jsp
		getServletContext()
			.getRequestDispatcher(url)
			.forward(request, response);
	}
	
	static boolean regexChecker(String theRegex, 
			String str2Check) {
		
		// You define the regex using pattern
		Pattern regexPattern = 
				Pattern.compile(theRegex);
				
		// Matcher searches a string for a match
		Matcher regexMatcher = 
				regexPattern.matcher(str2Check);
		
		if (regexMatcher.matches()){
			return true;
		} else {
			return false;
		}
		
	}
	
	// Setup MySQL Connector
	// Copy mysql-connector-java-8.0.15.jar into 
	// /WebContent/WEB-INF/lib/
	
	/*
	 * NEW SETUP DB
	 * mysql -u root -p
	 * CREATE DATABASE jeetut2;
	 * USE jeetut2;
	 * CREATE TABLE customer(
	 * fname VARCHAR(30) NOT NULL,
	 * lname VARCHAR(30) NOT NULL,
	 * street VARCHAR(50) NOT NULL,
	 * city VARCHAR(30) NOT NULL,
	 * state VARCHAR(2) NOT NULL,
	 * zipcode VARCHAR(10) NOT NULL,
	 * email VARCHAR(30) NOT NULL,
	 * password VARCHAR(20) NOT NULL,
	 * phone VARCHAR(20) NOT NULL, 
	 * cust_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY);
	 * CREATE USER 'dbadmin'@'localhost' IDENTIFIED BY 'turtledove';
	 * GRANT ALL PRIVILEGES ON jeetut2.customer TO 
	 * 'dbadmin'@'localhost' IDENTIFIED BY 'turtledove';
	 */
	
	// Adds users to the DB
		protected void updateDB(String fName, String lName, String street, String city,
				String state, String zipcode, String email, String password,
				String phone) {
			// Connects to the DB
			Connection con;
			
			try {
				// Everything needed to connect to the DB
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				// NEW Update database name
				String url = "jdbc:mysql://localhost/jeetut2";
		        String user = "dbadmin";
		        String pw = "turtledove";
		        
		        // Used to issue queries to the DB
		        con = DriverManager.getConnection(url, user, pw);
		        
		        // Sends queries to the DB for results
		        Statement s = con.createStatement();
		        
		        // Add a new entry
		        String query = "INSERT INTO CUSTOMER " + 
		        "(fname, lname, street, city, state, zipcode, email, password, phone, cust_id) " + 
		        "VALUES ('" + fName + "', '" + lName + "', '" +
		        street + "', '" + city + "', '" + state + "', '" +
		        zipcode + "', '" + email + "', '" + password + "', '" +
		        phone + "', NULL)";
		        
		        // Execute the Query
		        s.executeUpdate(query);
		        
		        // Close DB connection
		        con.close();
			} 
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
 
}