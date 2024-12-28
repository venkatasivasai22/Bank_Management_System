package com.bank;

import java.util.Scanner;

import com.bank.service.AdminService;
import com.bank.service.AdminServiceImplementation;
import com.bank.service.BankUserService;
import com.bank.service.BankUserServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	BankUserService bankUserService = new BankUserServiceImpl();
    	Scanner scanner = new Scanner(System.in);
    	AdminService adminService = new AdminServiceImplementation();
        bankUserService.forSleep("Welcome To Bank Management System");
        boolean cont = true;
        while(cont)
        {
        	 System.out.println("Enter 1 for user Registration");
             System.out.println("Enter 2 for Admin Login");
             System.out.println("Enter 3 for User Login");
             switch (scanner.nextInt()) 
             {
	     		case 1:
	     		{
	     			bankUserService.forSleep("User Registration");
	     			bankUserService.userRegistration();
	     		}break;
	     		
	     		case 2:
	     		{
//	     			bankUserService.forSleep("Admin login");
	     			adminService.adminLogin();
	     		}break;
	     		
	     		case 3 : 
	     		{
	     			bankUserService.forSleep("User login");
	     			bankUserService.userLogin();
	     		}break;
	
	     		default: 
	     		{
	     			bankUserService.forSleep("invalid choice1");
	     		}break;
	     			
     		}
             System.out.println("Do u want to continue (enter yes (or) no) :");
	 			if(!scanner.next().equalsIgnoreCase("yes"))
	 			{
	 				cont = false;
	 				System.out.println("Thank you visit again.........");
	 			}
        	
        }
       
       
        
    }
}
