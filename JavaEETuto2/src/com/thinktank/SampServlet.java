package com.thinktank;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * Create Eclipse JEE Web Project
 * Help -> Welcome
 * Create a new JEE Web Project
 * 
 * Right Click JEETut -> New -> Servlet
 * 
 * Servlets make it easy to develop web based applications
 * that provide access to things such as databases.
 * 
 * Servlets run on the server and process data for dynamic web pages
 * Servlets are found under Deployment Descriptor/Servlets
 * 
 * The Document Root Directory is where all other files are stored
 * 
 * The WEB-INF Directory is where you store files that you don't want
 * to be accessible on the web. Data files, web.xml, Java classes, Servlets
 * 
 * JSP Apps use the MVC Pattern where each part should largely function
 * on its own so if one part changes it has little effect on the others
 * 1. Model : The Java code that accesses/processes the data 
 * 2. View : The interface that the user sees
 * 3. Controller : Serves as a communicator between the Model and View
 */
 
// Used to send HTML and XML to the client
import java.io.PrintWriter;
 
// Matches up the servlet with a URL
@WebServlet("/SampServlet")
 
//HttpServlet provides methods for handling Get and
//Post requests and manage required resources
public class SampServlet extends HttpServlet {
	// Used to maintain compatibility between different
	// versions of this class. It is also a way to make
	// sure code is using the same versions of different
	// classes
	// Serializing involves converting objects into a form
	// that can be stored or transmitted
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SampServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	// Used by servlet to handle Get requests
    // HttpServletRequest : Request from the user such
    // as form data
    // HttpServletResponse : Response sent back to the user
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// Send all get requests to doPost
		doPost(request, response);
	}
 
	// Used by servlet to handle Post requests
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		// Defines that you want to send HTML to the browser
		// Must be set before creating the PrintWriter so
		// we know what type of data will be written
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		try {
			out.println("<h3>Testing Servlets</h3>");
		}
		finally {
			out.close();
		}
		
		// Setup Servers
		// 1. Click Servers tab at bottom of screen
		// 2. If it says No Servers are available
		// 	a. Click on that -> Select installed Tomcat version
		// 3. Right click on Server -> Add Remove -> Select JEETut
		// 4. Click Start the Server in bottom right hand corner
		// 	a. If you get the Server at localhost already in use error
		// 	   you need to shutdown Tomcat
		// 5. Make sure Servers/Tomcat.../server.xml file has 
		// <Context docBase="JEETut" path="/JEETut"... at bottom of file
		// 6. In browser http://localhost:8080/JEETut/SampServlet
		
	}
 
}