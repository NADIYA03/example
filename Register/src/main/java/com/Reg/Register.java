package com.Reg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.jasper.tagplugins.jstl.core.Out;

@WebServlet("/Reg")
public class Register extends HttpServlet {

 private static final String First_Name = null;

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
	System.out.println(req.getParameter("Language"));
	String Language=req.getParameter("Language");
	
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","nadiyan@3");
	PreparedStatement st=con.prepareStatement("Select * from register where Language=?");
	st.setString(1, Language);
	
	ResultSet rs=st.executeQuery();
	PrintWriter out=res.getWriter();
	while(rs.next()) {
		out.println("FirstName :"+rs.getString("FirstName")+"LastName :"+rs.getString("LastName")+"Phone :"+rs.getString("Phone")+"Email :"+rs.getString("Email")+"language :"+rs.getString("language"));
		System.out.println("FirstName :"+rs.getString("FirstName")+"LastName :"+rs.getString("LastName")+"Phone :"+rs.getString("Phone")+"Email :"+rs.getString("Email")+"language :"+rs.getString("language"));
	}
	

	st.close();
	con.close();

	} catch (SQLException e) {
	e.printStackTrace();
	} catch (ClassNotFoundException e) {
	e.printStackTrace();
	}
	}

}
