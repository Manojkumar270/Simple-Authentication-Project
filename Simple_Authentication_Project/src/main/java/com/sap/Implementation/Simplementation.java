package com.sap.Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.sap.Bean.RegisterBean;
import com.sap.Interface.Sinterface;
import com.sap.databaseconnection.DatabaseConnection;

public class Simplementation implements Sinterface{
	Connection con;

	@Override
	public int register(RegisterBean rb) {
		int result=0;
		con=DatabaseConnection.createConnection();
		try {
			PreparedStatement ps= con.prepareStatement("INSERT INTO details VALUES(?,?,?,?,?,?)");
			ps.setInt(1, rb.getId());
			ps.setString(2, rb.getName());
			ps.setString(3, rb.getUsername());
			ps.setString(4, rb.getPassword());
			ps.setString(5, rb.getEmail());
			ps.setString(6,rb.getMobile());
			result=ps.executeUpdate();
			
		}catch(Exception e){
			System.out.println("error");
			e.printStackTrace();
			
		}
		return result;
	}

	@Override
	public int login(String username, String password) {
		// TODO Auto-generated method stub
		int result=0;
		con=DatabaseConnection.createConnection();
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM `details` WHERE username ='"+username+"'and password ='"+password+"' ");
			System.out.println("username is : "+username);
			System.out.println("password is : "+password);
			
			
			while(rs.next()) {
				String usernamech=rs.getString("username");
				String passwordch=rs.getString("password");
				
				if(username.equals(usernamech)&& password.equals(passwordch)) {
					result=1;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
