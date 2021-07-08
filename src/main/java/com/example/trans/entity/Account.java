package com.example.trans.entity;

public class Account {
	private int accountid;
	private long accountnumber;
	private double accountbalance;
	public Account(long accountnumber, double accountbalance) {
		super();
		//this.accountid = accountid;
		this.accountnumber = accountnumber;
		this.accountbalance = accountbalance;
	}
	
	public Account() {
		
	}
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	public long getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}
	public double getAccountbalance() {
		return accountbalance;
	}
	public void setAccountbalance(double accountbalance) {
		this.accountbalance = accountbalance;
	}
	
	@Override
	public String toString() {
		return "Account [accountid=" + accountid + ", accountnumber=" + accountnumber + ", accountbalance="
				+ accountbalance + "]";
	}
	
	
	
}
