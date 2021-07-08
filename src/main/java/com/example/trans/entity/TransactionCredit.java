package com.example.trans.entity;

public class TransactionCredit {
	 private int transactonid;
	 private String date;
	 private Double amount;
	 private Double credit;
	 private int accountid;
	 
	public TransactionCredit(String date, Double amount, Double credit, int accountid) {
		super();
		this.date = date;
		this.amount = amount;
		this.credit = credit;
		this.accountid = accountid;
	}

	public int getTransactonid() {
		return transactonid;
	}

	public void setTransactonid(int transactonid) {
		this.transactonid = transactonid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getCredit() {
		return credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	@Override
	public String toString() {
		return "TransactionCredit [transactonid=" + transactonid + ", date=" + date + ", amount=" + amount + ", credit="
				+ credit + ", accountid=" + accountid + "]";
	}
	 
	 
	
}
