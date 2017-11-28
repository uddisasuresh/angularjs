package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mydb {
	
	Connection con;
	public Connection getCon() {

		try {
			// jdbc connection for mysql
			/*
			 * Class.forName("com.mysql.jdbc.Driver"); con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "admin");
			 */

			// jdbc connection for postgrelsql

			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}
}