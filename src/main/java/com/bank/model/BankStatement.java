package com.bank.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class BankStatement {
	private int transaction;
	private double transactionamount;
	private double balanceamount;
	private LocalDate dateoftranction;
	private LocalTime timeoftranction;
	private String transactiontype;
	private int userid;
	public BankStatement()
	{
		
	}
	
	public BankStatement(int transaction, double transactionamount, double balanceamount, LocalDate dateoftranction,
			LocalTime timeoftranction, String transactiontype, int userid) {
		super();
		this.transaction = transaction;
		this.transactionamount = transactionamount;
		this.balanceamount = balanceamount;
		this.dateoftranction = dateoftranction;
		this.timeoftranction = timeoftranction;
		this.transactiontype = transactiontype;
		this.userid = userid;
	}
	public int getTransaction() {
		return transaction;
	}
	public void setTransaction(int transaction) {
		this.transaction = transaction;
	}
	public double getTransactionamount() {
		return transactionamount;
	}
	public void setTransactionamount(double transactionamount) {
		this.transactionamount = transactionamount;
	}
	public double getBalanceamount() {
		return balanceamount;
	}
	public void setBalanceamount(double balanceamount) {
		this.balanceamount = balanceamount;
	}
	public LocalDate getDateoftranction() {
		return dateoftranction;
	}
	public void setDateoftranction(LocalDate dateoftranction) {
		this.dateoftranction = dateoftranction;
	}
	public LocalTime getTimeoftranction() {
		return timeoftranction;
	}
	public void setTimeoftranction(LocalTime timeoftranction) {
		this.timeoftranction = timeoftranction;
	}
	public String getTransactiontype() {
		return transactiontype;
	}
	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	

}
