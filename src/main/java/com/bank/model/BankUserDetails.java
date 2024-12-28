package com.bank.model;

public class BankUserDetails {
	private int id;
	private String name;
	private String emailid;
	private long aadharnumber;
	private String pannumber;
	private long mobilenumber;
	private String address;
	private String gender;
	private double amount;
	private int pin;
	private int accountnumber;
	private String status;
	public BankUserDetails() {
		
	}
	public BankUserDetails(int id, String name, String emailid, long aadharnumber, String pannumber, long mobilenumber,
			String address, String gender, double amount, int pin, int accountnumber, String status) {
		super();
		this.id = id;
		this.name = name;
		this.emailid = emailid;
		this.aadharnumber = aadharnumber;
		this.pannumber = pannumber;
		this.mobilenumber = mobilenumber;
		this.address = address;
		this.gender = gender;
		this.amount = amount;
		this.pin = pin;
		this.accountnumber = accountnumber;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public long getAadharnumber() {
		return aadharnumber;
	}
	public void setAadharnumber(long aadharnumber) {
		this.aadharnumber = aadharnumber;
	}
	public String getPannumber() {
		return pannumber;
	}
	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}
	public long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(long mobileNumber2) {
		this.mobilenumber = mobileNumber2;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public int getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BankUserDetails [id=" + id + ", name=" + name + ", emailid=" + emailid + ", aadharnumber="
				+ aadharnumber + ", pannumber=" + pannumber + ", mobilenumber=" + mobilenumber + ", address=" + address
				+ ", gender=" + gender + ", amount=" + amount + ", pin=" + pin + ", accountnumber=" + accountnumber
				+ ", status=" + status + "]";
	}
	

}
