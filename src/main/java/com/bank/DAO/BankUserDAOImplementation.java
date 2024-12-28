package com.bank.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.model.BankUserDetails;

public class BankUserDAOImplementation implements BankUserDAO
{
	private static final String url="jdbc:mysql://localhost:3307/teca64_advancejava?user=root&password=12345";
	private static final String insert="insert into bank_user_details(User_Name, User_EmailId, User_Aadher_Number, User_Pan_Number, User_Mobile_Number, User_Address, User_Gender,User_Status, User_Amount) values(?,?,?,?,?,?,?,?,?)";
	private static final String select_all = "select * from bank_user_details";
	private static final String update = "update bank_user_details set User_Pin=?,User_Account_Number=?,User_Status=? where User_ID=?";
	private static final String delete = "delete from bank_user_details where User_ID=?";
	private static final String user_login = "select * from bank_user_details where User_EmailId=? and User_Pin=?";
	private static final String update_amount = "update bank_user_details set User_Amount=? where User_Account_Number=?";
	private static final String debit = "update bank_user_details set User_Amount=? where User_EmailId=?";
	private static final String numbers = "select * from bank_user_details where User_Mobile_Number=?";
	private static final String update_amount_number = "update bank_user_details set User_Amount=? where User_Mobile_Number=?";
	@Override
	public void insertBankUserDetails(BankUserDetails bankUserDetails)  {
		// TODO Auto-generated method stub
		try {
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(insert);

			preparedStatement.setString(1, bankUserDetails.getName());
			preparedStatement.setString(2, bankUserDetails.getEmailid());
			preparedStatement.setLong(3, bankUserDetails.getAadharnumber());
			preparedStatement.setString(4, bankUserDetails.getPannumber());
			preparedStatement.setLong(5, bankUserDetails.getMobilenumber());
			preparedStatement.setString(6, bankUserDetails.getAddress());
			preparedStatement.setString(7, bankUserDetails.getGender());
			preparedStatement.setString(8, "pending");
			preparedStatement.setDouble(9, bankUserDetails.getAmount());
			
			int result = preparedStatement.executeUpdate();
			if(result!=0)
			{
				System.out.println(bankUserDetails.getName() +" registration successfull");
			}
			else
			{
				System.out.println("registration not successfull");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<BankUserDetails> selectAllBankUserDetails()  {
		// TODO Auto-generated method stub
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(select_all);
			ResultSet resultSet=preparedStatement.executeQuery();
			List<BankUserDetails> list = new ArrayList<BankUserDetails>();
			if(resultSet.isBeforeFirst())
			{
				while(resultSet.next())
				{
					BankUserDetails bankUserDetails = new BankUserDetails();
					bankUserDetails.setId(resultSet.getInt("User_ID"));
					bankUserDetails.setEmailid(resultSet.getString("User_EmailId"));
					bankUserDetails.setAadharnumber(resultSet.getLong("User_Aadher_Number"));
					bankUserDetails.setPannumber(resultSet.getString("User_Aadher_Number"));
					bankUserDetails.setMobilenumber(resultSet.getLong("User_Mobile_Number"));
					bankUserDetails.setName(resultSet.getString("User_Name"));
					bankUserDetails.setStatus(resultSet.getString("User_Status"));
//					bankUserDetails.setPin(resultSet.getLong("User_Pin"));
					
					list.add(bankUserDetails);
				}
				return list;
			}
			else
			{
				return null;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
		
	}

	@Override
	public int updatePinAndAccountNumber(int pin, int accountNumber,int id) {
		// TODO Auto-generated method stub
		try {
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(update);
			preparedStatement.setInt(1, pin);
			preparedStatement.setInt(2, accountNumber);
			preparedStatement.setString(3, "Accepted");
			preparedStatement.setInt(4,id);
			return preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		
		
	
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		try {
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(delete);
			preparedStatement.setInt(1, id);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		
	}

	@Override
	public BankUserDetails getUserDetailsByUsingEmailAndPassword(String emailid, int pin) {
		
		// TODO Auto-generated method stub
		try {
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(user_login);
			preparedStatement.setString(1, emailid);
			preparedStatement.setInt(2, pin);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				BankUserDetails bankUserDetails = new BankUserDetails();
				bankUserDetails.setName(resultSet.getString("User_Name"));
				bankUserDetails.setGender(resultSet.getString("User_Gender"));
				bankUserDetails.setAmount(resultSet.getDouble("User_Amount"));
				
				
				return bankUserDetails;
			}
			else
			{
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
		
	}

	@Override
	public int updateAmountByUsingAccountNumber(double amount, int account) {
		// TODO Auto-generated method stub
		
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(update_amount);
			preparedStatement.setDouble(1, amount);
			preparedStatement.setDouble(2, account);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public int debit(String email, double amount) {
		// TODO Auto-generated method stub
		
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(debit);
			preparedStatement.setDouble(1, amount);
			preparedStatement.setString(2, email);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		
	}

	@Override
	public BankUserDetails phoneNumberDetails(long number) {
		// TODO Auto-generated method stub
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(numbers);
			preparedStatement.setLong(1, number);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				BankUserDetails bankUserDetails = new BankUserDetails();
				bankUserDetails.setMobilenumber(resultSet.getLong("User_Mobile_Number"));
				bankUserDetails.setAmount(resultSet.getDouble("User_Amount"));
				
				return bankUserDetails;
			}
			else
			{
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public int phoneAmountTranfor(long number,double amount) {
		// TODO Auto-generated method stub
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(update_amount_number);
			preparedStatement.setDouble(1,amount);
			preparedStatement.setLong(2,number);
			
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

}
