package com.crud.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	public Database() {
		// TODO Auto-generated constructor stub
	}
	
	public static Connection getConnection() throws SQLException
	{
		Connection connection=null;
		 String url="jdbc:mysql://localhost:3306/BookStore";
		 String userName="root";
		 String password="";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection(url, userName, password);
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return connection;
	}
	
	public static void close() throws SQLException
	{
		Connection connection=Database.getConnection();
		
		if((connection==null) && (!connection.isClosed()))
		{
			connection.close();
		}
		
	}

}
