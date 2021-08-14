package spring.first.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
/**
 * Servlet implementation class TestDBConnection
 */
@WebServlet("/TestDBConnection")
public class TestDBConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Setup Connection
		String user = "hbstudent";
		String password = "hbstudent";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_tution_tracker?useSSL=false&amp";
		String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		
		// Get Connection 
		try {
			
			//PrintWriter out = response.getWriter(); 
			System.out.println("Connecting to database" + jdbcUrl);
			Class.forName(jdbcDriver);
			Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Success" + connection.getSchema());
			connection.close();
			
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ServletException(exception);
		}
	}

}
