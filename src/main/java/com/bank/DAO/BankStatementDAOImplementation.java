package com.bank.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

import com.bank.model.BankStatement;

public class BankStatementDAOImplementation implements BankStatementDAO {
	private static final String url = "jdbc:mysql://localhost:3307/teca64_advancejava?user=root&password=12345";
	private static final String insert="insert into bank_statement (Tranction_Amount, Balance_Amount, Date_Of_Tranction, Time_Of_Tranction, Tranction_Type, User_Id) values(?,?,?,?,?,?);";
	BankStatement bankStatement = new BankStatement();
	@Override
	public int insertStatementDetails(BankStatement bankStatement) {
		// TODO Auto-generated method stub
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			preparedStatement.setDouble(1, bankStatement.getTransactionamount());
			preparedStatement.setDouble(2, bankStatement.getBalanceamount());
			preparedStatement.setDate(3, Date.valueOf(bankStatement.getDateoftranction()));
			preparedStatement.setTime(4, Time.valueOf(bankStatement.getTimeoftranction()));
			preparedStatement.setString(5, bankStatement.getTransactiontype());
			preparedStatement.setInt(6, bankStatement.getUserid());
			return preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		
		
	}

}
