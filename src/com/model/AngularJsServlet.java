package com.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;	

public class AngularJsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AngularJsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		try {

			String data = fetchDataUsingSQL();
			if (data != null)
				response.getWriter().write(data);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private String fetchDataUsingSQL() {
		Mydb db = new Mydb();
		Connection con = db.getCon();
		ArrayList<User> al = new ArrayList<>();

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user1");
			while (rs.next()) {
				User userobj = new User(rs.getInt("uid"),
										rs.getString("uname"), 
										rs.getString("upass"),
										rs.getString("email"));
				al.add(userobj);
				System.out.println(userobj);
			}
			Gson gson = new Gson();
			return gson.toJson(al);
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return null;
	}

}
