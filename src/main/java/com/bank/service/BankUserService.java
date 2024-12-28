package com.bank.service;

public interface BankUserService {
	void forSleep(String value);
	void userRegistration();
	void userLogin();
	void userOption(String emailid,int password);
	void debit(String emailid,int password);
	void checkBalance(String email,int password);
	void numberToNumber(String email,int password);
	void credit(String emailid,int password);
}
