package com.bank.service;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Random;

import com.bank.DAO.AdminDAO;
import com.bank.DAO.AdminDAOimplementation;
import com.bank.DAO.BankUserDAO;
import com.bank.DAO.BankUserDAOImplementation;
import com.bank.exception.AdminException;
import com.bank.model.BankUserDetails;

public class AdminServiceImplementation implements AdminService {
	AdminDAO adminDAO = new AdminDAOimplementation();
	BankUserDAO bankUserDAO = new BankUserDAOImplementation();
	List<BankUserDetails> allBankUserDetails;
	int count = 1;
	Scanner  scanner = new Scanner(System.in);
	
	@Override
	public void adminLogin() {
		// TODO Auto-generated method stub
		allBankUserDetails = bankUserDAO.selectAllBankUserDetails();
		System.out.println("enter the Email : ");
		String emailid = scanner.next();
		System.out.println("enter the Admin Password");
		String password = scanner.next();
		try
		{
			if(adminDAO.getAdminDetailsByUsingEmailidAndPassword(emailid,password))
			{
				System.out.println("Enter 1 To Get All UserDetails");
				System.out.println("Enter 2 To Get All Account Request Details");
				System.out.println("Enter 3 To Get All Account Closing Request Details");
			
				switch (scanner.nextInt()) 
				{
					case 1: System.out.println("All UserDetails");
						allUserDetails();
							break;			
					case 2: System.out.println("All Account Request Details");
						acceptAllAccountRequstDetails();
							break;
				
					case 3: System.out.println("All Account Closing Request Details");
							break;

					default: 
				   			break;
				}	
			}
			else
			{
				throw new AdminException("INVALID CREDINTIALS");
			}
		}
		catch (AdminException e) 
		{
			System.out.println(e.getMsg());
		}
	}

	@Override
	public void acceptAllAccountRequstDetails() {
		// TODO Auto-generated method stub
		List<BankUserDetails> listofpendingData = allBankUserDetails.stream()
				.filter((user->user.getStatus()
				.equals("pending"))).collect(Collectors.toList());
		
		//All Pending Details
		
		listofpendingData.forEach((pendingdata)->{
			System.out.println("S.No : "+ count++);
			System.out.println("User Name = "+pendingdata.getName());
			System.out.println("User Email ID = "+pendingdata.getEmailid());
			System.out.println("User Status = "+pendingdata.getStatus());
			
			long aadharnumber = pendingdata.getAadharnumber();
			String aa = aadharnumber+"";
			
			System.out.println("User Aadhar Number = "+aa.substring(0, 4)+"****"+aa.substring(9, 12));
			
			long m = pendingdata.getMobilenumber();
			String mb = m+"";
			System.out.println("User mobile number : "+mb.substring(0, 3)+"****"+mb.substring(7, 10));
//			System.out.println("User Mobile Number = "+pendingdata.getMobilenumber());
			System.out.println("*****************************************************");
			
			
		});
		System.out.println("Enter serial number to select User Details");
		BankUserDetails bankUserDetails = listofpendingData.get(scanner.nextInt()-1);
		System.out.println("Enter \n 1. accept \n 2.Reject");
		switch(scanner.nextInt())
		{
		case 1 : System.out.println("accept");
			acceptUserRequst(bankUserDetails);
					break;
		case 2 : System.out.println("reject");
			rejuctUserRequst(bankUserDetails);
			
					break;
		
		default : System.out.println("invaslied option");
		            break;
					
		}
		
	}

	@Override
	public void acceptUserRequst(BankUserDetails bankUserDetails) {
		// TODO Auto-generated method stub
		Random random = new Random();
		int pin = random.nextInt(10000);
		if(pin<1000)
		{
			pin+=1000;
		}
		
		int accountnumber = random.nextInt(10000000);
		if(accountnumber<1000000)
		{
			accountnumber+=1000000;
		}
		int result = bankUserDAO.updatePinAndAccountNumber(pin, accountnumber, bankUserDetails.getId());
		if(result>0)
		{
			System.out.println("Account Accepted Successfully........");
			System.out.println(bankUserDetails.getName() + " Account number is : "+accountnumber);
			System.out.println(bankUserDetails.getName() + " Pin number is : "+pin);
		}
		else
		{
			throw new AdminException("Invalied creduncials");
		}
	}

	@Override
	public void rejuctUserRequst(BankUserDetails bankUserDetails) {
		// TODO Auto-generated method stub
		int result=bankUserDAO.delete(bankUserDetails.getId());
		if(result!=0)
		{
			System.out.println("Account rejucted successfully");
		}
		else
		{
			throw new AdminException("Unable to reject");
		}
		
	}

	@Override
	public void allUserDetails() {
		BankUserDAO bankUserDAO = new BankUserDAOImplementation();
		List<BankUserDetails> allDetails = bankUserDAO.selectAllBankUserDetails();
		
		allDetails.forEach((Details)->{
			System.out.println("User id : "+Details.getId());
			System.out.println("User Name : "+Details.getName());
			System.out.println("User Email Id : "+Details.getEmailid());
			System.out.println("User Aadhar No. : "+Details.getAadharnumber());
			System.out.println("User Pan No. : "+Details.getPannumber());
			System.out.println("User Mobile No. : "+Details.getMobilenumber());
			System.out.println("User Address : "+Details.getAddress());
			System.out.println("User Gender : "+Details.getGender());
			System.out.println("User Account No. : "+Details.getAccountnumber());
			System.out.println("User Status : "+Details.getStatus());
			System.out.println("============================================================");
		});
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
