package com.sap.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	static Connection con;
	public static Connection createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registerbase","root","Manoj123");
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
}
