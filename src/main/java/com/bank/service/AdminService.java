package com.bank.service;

import com.bank.model.BankUserDetails;

public interface AdminService {
	void adminLogin();
	void acceptAllAccountRequstDetails();
	void acceptUserRequst(BankUserDetails bankUserDetails);
	void rejuctUserRequst(BankUserDetails bankUserDetails);
	void allUserDetails();

}
