package com.bank.service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import com.bank.DAO.AdminDAO;
import com.bank.DAO.AdminDAOimplementation;
import com.bank.DAO.BankStatementDAO;
import com.bank.DAO.BankStatementDAOImplementation;
import com.bank.DAO.BankUserDAO;
import com.bank.DAO.BankUserDAOImplementation;
import com.bank.exception.BankUserException;
import com.bank.model.BankStatement;
import com.bank.model.BankUserDetails;

public class BankUserServiceImpl implements BankUserService {
	Scanner scanner = new Scanner(System.in);
	BankUserDAO bankUserDAO = new BankUserDAOImplementation();
	BankUserDetails bankUserDetails = new BankUserDetails();
	BankStatementDAO bankStatementDAO = new BankStatementDAOImplementation();
	
	@Override
	public void forSleep(String value) {
		// TODO Auto-generated method stub
		for (int i =0;i<=value.length()-1;i++)
		{
			System.out.print(value.charAt(i));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
		
	}

	@Override
	public void userRegistration() 
	{
		List<BankUserDetails> allbankUserDetails = bankUserDAO.selectAllBankUserDetails();
		BankUserDetails bankUserDetails = new BankUserDetails();
		
		//=======================name===============================
		System.out.println("Enter Your Name : ");
		String name = scanner.next();
		bankUserDetails.setName(name);
		// ---------------------email--------------------------------
//		boolean isEmail = true;
//		while (isEmail)
//		{
//			try {
//				System.out.println("Enter your Email : ");
//				String email = scanner.next();
//				
//				if(email.endsWith("@gmail.com"))
//				{
////					bankUserDetails.setEmailid(email);
////					long emailcount = 
//					isEmail=false;
//					bankUserDetails.setEmailid(email);
//					
//				}
//				else
//				{
//					throw new BankUserException("invalied email id");
//				}
//			}
//			catch(BankUserException e)
//			{
//				System.out.println(e.getMsg());
//			}
//		}
		
		boolean emailstatus = true;
		while(emailstatus)
		{
			try
			{
				System.out.println("Enter your Emailid");
				String email = scanner.next();
				if(email.endsWith("@gmail.com"))
				{
//					bankUserDetails.setEmailid(email);
					long emailcount = allbankUserDetails.stream().filter((user->user.getEmailid().equals(email))).count();
					//System.out.println(emailcount);
					if (emailcount==0) 
					{
						bankUserDetails.setEmailid(email);
						emailstatus = false;
					} 
					else 
					{
						throw new BankUserException("Already Email Id  Exists");
					}
					
				}
				else
				{
					throw new BankUserException("invalid email");
				}
			}
			catch(BankUserException e)
			{
				System.out.println(e.getMsg());
			}
		}
		
		//=========================mobile============================
//		boolean status = true;
//		while(status)
//		{
//			try 
//			{
//				System.out.println("Enter Your Mobile Number : ");
//				long mobileNumber = scanner.nextLong();
//				if(mobileNumber>=6000000000l && mobileNumber<=9999999999l)
//				{
//					status=false;
//					bankUserDetails.setMobilenumber(mobileNumber);
//				}
//				else
//				{
//					throw new BankUserException("Invalid Mobile Number");
//				}
//			}
//			catch(BankUserException e)
//			{
//				System.out.println(e.getMsg());
//			}
//		}
		
		boolean status1 = true;
		while(status1)
		{
			try
			{
				System.out.println("Enter your Mobile Number");
				long mobilenumber = scanner.nextLong();
				if(mobilenumber>=6000000000l && mobilenumber<=9999999999l)
				{
					long mobilenumbercount = allbankUserDetails.stream().filter((user->user.getMobilenumber()==mobilenumber)).count();
					if (mobilenumbercount==0) 
					{
						status1 = false;
						bankUserDetails.setMobilenumber(mobilenumber);
					} 
					else
					{
						System.out.println("Already Mobile Number Exists");
					}
				} 
				else
				{
					throw new  BankUserException("Invalid mobile Number");
				}
			}
			catch(BankUserException e )
			{
				System.out.println(e.getMsg());
			}
		}
		//========================pan==============================
//		System.out.println("Enter Your PAN Number : ");
//		String pannumber = scanner.next();
//		bankUserDetails.setPannumber(pannumber);
		
		
		boolean panstatus = true;
		while(panstatus) {
			try {
				System.out.println("Enter Your PAN Number");
		        String pannum = scanner.next();
		        if(pannum.length() != 10) {
					throw new BankUserException("Pan number length is not valid");
				}else {
					for(int i=0; i<5; i++) {
						if(Character.isUpperCase(pannum.charAt(i)) && Character.isAlphabetic(pannum.charAt(i))) {
						}else {
							throw new BankUserException("Alphabet should be capital");
						}
					}
					for(int i=5; i<9; i++) {
						if(Character.isDigit(pannum.charAt(i))) {

						}else {
							throw new BankUserException("Must be digit should placed in this position");
						}
					}
					if(Character.isUpperCase(pannum.charAt(9)) && Character.isAlphabetic(pannum.charAt(9))){
					}else {
						throw new BankUserException("Alphabet should be capital in last position");
					}
				}
		        long pancount = allbankUserDetails.stream()
		        		.filter(user->user.getPannumber().equals(pannum)).count();
		        if(pancount == 0) {
		        	bankUserDetails.setPannumber(pannum);
		        	panstatus = false;
		        }else {
		        	throw new BankUserException("Pan Number Already exists");
		        }
			}catch (BankUserException e) {
				System.out.println(e.getMsg());
			}
		}
		//==================aadhar========================
//		boolean aadharstatus = true;
//		while(aadharstatus)
//		{
//			System.out.println("Enter Aadhar Number : ");
//			long aadhar = scanner.nextLong();
//			try
//			{
//				if(aadhar>=100000000000l && aadhar<=999999999999l)
//				{
//					aadharstatus = false;
//					bankUserDetails.setAadharnumber(aadhar);
//				}
//				else
//				{
//					throw new BankUserException("Invalid aadhar number");
//				}
//			}
//			catch (BankUserException e)
//			{
//				System.out.println(e.getMsg());
//			}
//			
//		}
		
		boolean aadharstatus =true;
		while(aadharstatus)
		{
			try
			{
				System.out.println("Enter your Adhar Number");
				long adharnumber = scanner.nextLong();
				if(adharnumber>=100000000000l && adharnumber<=999999999999l)
				{
					long adharnnumbercount = allbankUserDetails.stream().filter((user->user.getAadharnumber()==adharnumber)).count();
					if (adharnnumbercount==0) 
					{
						aadharstatus=false;
						bankUserDetails.setAadharnumber(adharnumber);
					}
					else 
					{
						System.out.println("Already Aadhar Number Exists");
					}
				}
				else
				{
					throw new BankUserException("Invalid Aadhar Number");
				}
			}
			catch(BankUserException e)
			{
				System.out.println(e.getMsg());
			}
		}
		//---------------------address---------------------
		System.out.println("Enter Your Address : ");
		String address = scanner.next();
		bankUserDetails.setAddress(address);
		boolean gen = true;
		while(gen)
		{
			System.out.println("Enter your gender : ");
			String gender = scanner.next();
			try {
				if(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("femail")||gender.equalsIgnoreCase("others"))
				{
					gen=false;
					bankUserDetails.setGender(gender);
				}
				else
				{
					throw new BankUserException("gender invalied");
				}
			}
			catch (BankUserException e)
			{
				System.out.println(e.getMsg());
			}
		}
		
		
		//-----------------amount-------------------------
		System.out.println("enter your amount");
		double amount = scanner.nextDouble();
		bankUserDetails.setAmount(amount);
		
		bankUserDAO.insertBankUserDetails(bankUserDetails);
		
		
	}

	@Override
	public void userLogin() {
		// TODO Auto-generated method stub
		System.out.println("Enter Emailid : ");
		String emailid = scanner.next();
		System.out.println("Enter the pin number : ");
		int pin = scanner.nextInt();
		BankUserDetails bankUserDetails = bankUserDAO.getUserDetailsByUsingEmailAndPassword(emailid, pin);
		if(bankUserDetails!=null)
		{
			if(bankUserDetails.getGender().equalsIgnoreCase("male"))
			{
				forSleep("Hello Mr. "+bankUserDetails.getName());
				userOption(emailid,pin);
			}
			if(bankUserDetails.getGender().equalsIgnoreCase("famale"))
			{
				forSleep("Hello Miss "+bankUserDetails.getName());
				userOption(emailid,pin);
			}
			
		}
		else
		{
			System.out.println("Invalied emailid and pin");
		}
		
	}

	

	@Override
	public void userOption(String emailid,int password) {
		// TODO Auto-generated method stub
		System.out.println("Enter \n 1. To Debit "
				+ "\n 2. To Credit "
				+ "\n 3. To Check Balance "
				+ "\n 4. Mobole Number Tranction "
				+ "\n 5. To Cancle Account Requst");
		switch(scanner.nextInt())
		{
		case 1 :
			System.out.println("Debit");
			debit(emailid,password);
			break;
		case 2 : 
			System.out.println("Cridet");
			credit(emailid, password);
			break;
		case 3 : 
			System.out.println("Check Balance");
			checkBalance(emailid,password);
			break;
		case 4 :
			System.out.println("Mobile Number Tranction");
			numberToNumber(emailid,password);
			break;
		case 5 :
		{
			System.out.println("To Cancle Account Requst");
			break;
		}
		default :
			System.out.println("Invalied option");
			break;
		}
		
	}

	@Override
	public void debit(String emailid,int password) {
		// TODO Auto-generated method stub
		BankUserDetails bankUserDetails = bankUserDAO.getUserDetailsByUsingEmailAndPassword(emailid, password);
		System.out.println("Enter your Account : ");
		double userammount = scanner.nextDouble();
		double databaseAmount = bankUserDetails.getAmount();
		double balanceAmount = databaseAmount-userammount;
		System.out.println("total amount "+databaseAmount);
		try
		{
			if(userammount>=0)
			{
				if(userammount<=databaseAmount)
				{
					
					
					int result = bankUserDAO.debit(emailid, balanceAmount);
					if(result>0)
					{
//						System.out.println("Amount deposit successfully");
						BankStatement bankStatement = new BankStatement();
						bankStatement.setBalanceamount(balanceAmount);
						bankStatement.setTransactionamount(userammount);
						bankStatement.setDateoftranction(LocalDate.now());
						bankStatement.setTimeoftranction(LocalTime.now());
						bankStatement.setTransactiontype("Debit");
						bankStatement.setUserid(bankUserDetails.getId());
						bankStatementDAO.insertStatementDetails(bankStatement);
						
						System.out.println("Amount debited Successfully");
					}
					else
					{
						throw new BankUserException("server 404");
					}
				}
				else
				{
					throw new BankUserException("IN-SUFFICIENT AMOUNT...");
				}
			}
			else
			{
				throw new BankUserException("INVALIED AMOUNT");
			}
		}
		catch(BankUserException e)
		{
			System.out.println(e.getMsg());
		}
		
		
	}

	@Override
	public void checkBalance(String email,int password) {
		// TODO Auto-generated method stub
		BankUserDetails bankUserDetails = bankUserDAO.getUserDetailsByUsingEmailAndPassword(email, password);
		System.out.println("Account holder name is :"+bankUserDetails.getName());
		System.out.println("Account balance is : "+bankUserDetails.getAmount());
		
	}

	@Override
	public void numberToNumber(String email,int password) {
		// TODO Auto-generated method stub
		BankUserDetails bankUserDetails = bankUserDAO.getUserDetailsByUsingEmailAndPassword(email, password);
		System.out.println("Enter the number where u want to transfor : ");
		long number = scanner.nextLong();
		BankUserDetails bankUserDetaails1 = bankUserDAO.phoneNumberDetails(number);
		
		System.out.println("enter the amount u want to transfor : ");
		double amount = scanner.nextDouble();
		double databaseAmount = bankUserDetails.getAmount();
		if(databaseAmount>0)
		{
			double balanceAmount = databaseAmount-amount;
			double updateamount1 = bankUserDetaails1.getAmount();
			double updateammount2 = updateamount1+amount;
			if(amount<=databaseAmount)
			{
				int result1 = bankUserDAO.debit(email, balanceAmount);
				int result = bankUserDAO.phoneAmountTranfor(number, updateammount2);
				if(result>0&&result1>0)
				{
					BankStatement bankStatement = new BankStatement();
					bankStatement.setBalanceamount(balanceAmount);
					bankStatement.setTransactionamount(amount);
					bankStatement.setDateoftranction(LocalDate.now());
					bankStatement.setTimeoftranction(LocalTime.now());
					bankStatement.setTransactiontype("Debit");
					bankStatement.setUserid(bankUserDetaails1.getId());
					bankStatementDAO.insertStatementDetails(bankStatement);
					System.out.println("tranfor successfull");
				}
				else
				{
					System.out.println("transfor fail");
				}
			}
			else
			{
				System.out.println("insaficent amount");
			}
			
		}
		else
		{
			System.out.println("amount 0");
		}
		
		
		
	}

	@Override
	public void credit(String emailid, int password) {
		// TODO Auto-generated method stub
		BankUserDetails bankUserDetails = bankUserDAO.getUserDetailsByUsingEmailAndPassword(emailid, password);
		System.out.println("Enter your Account : ");
		double userammount = scanner.nextDouble();
		double databaseAmount = bankUserDetails.getAmount();
		double balanceAmount = databaseAmount+userammount;
		System.out.println("total amount "+databaseAmount);
		try
		{
			if(userammount>=0)
			{
				if(userammount<=databaseAmount)
				{
					
					
					int result = bankUserDAO.debit(emailid, balanceAmount);
					if(result>0)
					{
//						System.out.println("Amount deposit successfully");
						BankStatement bankStatement = new BankStatement();
						bankStatement.setBalanceamount(balanceAmount);
						bankStatement.setTransactionamount(userammount);
						bankStatement.setDateoftranction(LocalDate.now());
						bankStatement.setTimeoftranction(LocalTime.now());
						bankStatement.setTransactiontype("Debit");
						bankStatement.setUserid(bankUserDetails.getId());
						bankStatementDAO.insertStatementDetails(bankStatement);
						
						System.out.println("Amount debited Successfully");
					}
					else
					{
						throw new BankUserException("server 404");
					}
				}
				else
				{
					throw new BankUserException("IN-SUFFICIENT AMOUNT...");
				}
			}
			else
			{
				throw new BankUserException("INVALIED AMOUNT");
			}
		}
		catch(BankUserException e)
		{
			System.out.println(e.getMsg());
		}
	}

}
