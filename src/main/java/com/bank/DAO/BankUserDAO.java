package com.bank.DAO;

import java.util.List;

import com.bank.model.BankUserDetails;

public interface BankUserDAO {
	void insertBankUserDetails(BankUserDetails bankUserDetails);
	List<BankUserDetails> selectAllBankUserDetails();
	int updatePinAndAccountNumber(int pin,int accountNumber,int id);
	int delete(int id);
	BankUserDetails getUserDetailsByUsingEmailAndPassword(String emailid,int pin);
	
	int updateAmountByUsingAccountNumber(double amount, int account);
	int debit(String email,double amount);
	BankUserDetails phoneNumberDetails(long number);
	int phoneAmountTranfor(long number,double amount);

}
