package com.example.trans.entity;

public class Transaction {
	private int transactionid;
	private String date;
	private double amount;
	private double debit;
	//private double credit;
	private int accountid;
	
	
	public Transaction(String date,double amount, double debit, int accountid) {
		super();
		this.date = date;
		this.amount = amount;
		this.debit = debit;
		//this.credit = credit;
		this.accountid = accountid;
	}


	public int getTransactionid() {
		return transactionid;
	}


	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public double getDebit() {
		return debit;
	}


	public void setDebit(double debit) {
		this.debit = debit;
	}



	public int getAccountid() {
		return accountid;
	}


	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}


	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionid + ",date=" + date + ",amount=" + amount + ", debit="
				+ debit + ", accountid=" + accountid + "]";
	}
	

}
