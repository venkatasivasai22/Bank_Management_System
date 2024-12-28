package com.bank.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAOimplementation implements AdminDAO {
	private static final String url = "jdbc:mysql://localhost:3307/teca64_advancejava?user=root&password=12345";
	private static final String admin_login = "select * from admin_details where Admin_Emailid=? and Admin_Password=?";
	@Override
	public boolean getAdminDetailsByUsingEmailidAndPassword(String email, String password) {
		
			try {
				Connection connection = DriverManager.getConnection(url);
				PreparedStatement preparedStatement = connection.prepareStatement(admin_login);
				preparedStatement.setString(1, email);
				preparedStatement.setString(2,password);
				ResultSet resultSet = preparedStatement.executeQuery();
				if(resultSet.next())
				{
					return true;
				}
				else
				{
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
		
	}

}
