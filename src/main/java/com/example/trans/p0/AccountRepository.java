package com.example.trans.p0;

import com.example.trans.entity.Account;
public interface AccountRepository {
	
	void save(Account account);
	void transfer(int money1);
	
}
