package com.example.trans.p0;

import java.sql.Connection;





import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import org.gjt.mm.mysql.Driver;
//import java.sql.PreparedStatement;

import com.example.trans.db.ConnectionFactory;
import com.example.trans.entity.Account;
import com.example.trans.entity.Transaction;
import com.example.trans.entity.TransactionCredit;
//import com.example.trans.p0.TransactionRepository;
//import java.util.Date;
import java.time.LocalDate;
import java.sql.Date;
//import com.example.trans.p0.AccountRepository.save;
public class JdbcAccountRepository implements AccountRepository,TransactionRepository,TransactionCreditRepository{

	@Override
	public void save(Account account)  {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			// step-3 : create jdbc-statements with SQL
			String sql = "insert into account (accountnumber,accountbalance) values (?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, account.getAccountnumber());
			ps.setDouble(2, account.getAccountbalance());
			//ps.setInt(3, 1);
			//ps.setInt(3, todo.getUser().getId());
			// step-4 : excute jdbc-statements & process result-set
			int rowCount = ps.executeUpdate();
			if (rowCount == 1) {
				System.out.println("Todo saved.");
			}
			// step-7 : close connection
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//con.close();
	}
	@Override
	public void transfer(int money1) {
		Connection con = null;
		Savepoint sp1 = null;
		Savepoint sp2 = null;
		System.out.println(money1);
		try {
			//Load from Account
			con = ConnectionFactory.getConnection();
			//System.out.println("Hi");
			con.setAutoCommit(false);

			sp1 = con.setSavepoint("sp1");
			// step-3 : create jdbc-statements with SQL
			String sql1 = "select * from account where accountid=25";
			Statement st1 = con.createStatement();
			ResultSet rs1=st1.executeQuery(sql1);
			rs1.next();
			Account fromAccount = new Account(rs1.getInt(1),rs1.getDouble(3));
			//System.out.println(rs1.getInt(1));
			//System.out.println(rs1.getDouble(3));
			
			//Load to Account
			//con = ConnectionFactory.getConnection();
			// step-3 : create jdbc-statements with SQL
			String sql2 = "select * from account where accountid=31";
			Statement st2 = con.createStatement();
			ResultSet rs2=st2.executeQuery(sql2);
			rs2.next();
			Account toAccount = new Account(rs2.getInt(1),rs2.getDouble(3));
			//System.out.println(rs2.getInt(1));
			//System.out.println(rs2.getDouble(3));
			
			sp2 = con.setSavepoint("sp2");
			
			if (fromAccount.getAccountbalance() > 1) {

			//debit & credit
			
			fromAccount.setAccountbalance(fromAccount.getAccountbalance()-money1);
			toAccount.setAccountbalance(toAccount.getAccountbalance()+money1);
			System.out.println(fromAccount);
			System.out.println(toAccount);
			//update from Account
			
			String sql3 = "update account set accountbalance = ? where accountid=?";
			PreparedStatement pst1=con.prepareStatement(sql3);
			pst1.setDouble(1,fromAccount.getAccountbalance());
			pst1.setLong(2, fromAccount.getAccountnumber());
			int rowcount=pst1.executeUpdate();
			System.out.println(rowcount);
			
			/*boolean b = true;
			if (b) {
				throw new IllegalStateException("boo00000om");
			}*/
			
			//update to Account
			
			String sql4 = "update account set accountbalance = ? where accountid=?";
			PreparedStatement pst2=con.prepareStatement(sql4);
			pst2.setDouble(1,toAccount.getAccountbalance());
			pst2.setLong(2, toAccount.getAccountnumber());
			//pst2.executeUpdate();
			int rowcount1=pst2.executeUpdate();
			System.out.println(rowcount1);
			
			con.commit();
			System.out.println("Success");
			}else
			{
					System.out.println("No Balance");

			}
			
			// step-7 : close connection
		} catch (Exception e) {
			try {
				con.rollback(sp2);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void report(Transaction transaction)  {
		Connection con = null;
	
		 Date date=Date.valueOf(transaction.getDate());
		 System.out.println(date);
		 System.out.println(transaction.getAmount());
		 System.out.println(transaction.getDebit());
		 System.out.println(transaction.getAccountid());
		try {
			con = ConnectionFactory.getConnection();
			String sql = "insert into transaction (date,amount,debit,accountid) values (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDate(1, date);
			ps.setDouble(2,transaction.getAmount());
			ps.setDouble(3, transaction.getDebit());
			ps.setInt(4, transaction.getAccountid());
			int rowCount = ps.executeUpdate();
			if (rowCount == 1) {
				System.out.println("Todo saved.");
			}
			// step-7 : close connection
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//con.close();
	}
	
	@Override
	public void creditreport(TransactionCredit transactionCredit)  {
		Connection con = null;
	
		 Date date=Date.valueOf(transactionCredit.getDate());
		 System.out.println(date);
		 System.out.println(transactionCredit.getAmount());
		 System.out.println(transactionCredit.getCredit());
		 System.out.println(transactionCredit.getAccountid());
		try {
			con = ConnectionFactory.getConnection();
			String sql = "insert into transactioncredit (date,amount,credit,accountid) values (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDate(1, date);
			ps.setDouble(2,transactionCredit.getAmount());
			ps.setDouble(3, transactionCredit.getCredit());
			ps.setInt(4, transactionCredit.getAccountid());
			int rowCount = ps.executeUpdate();
			if (rowCount == 1) {
				System.out.println("Todo saved.");
			}
			// step-7 : close connection
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//con.close();
	}
	
	@Override
	public void transactionreport() {
		Connection con = null;
		try {
		con = ConnectionFactory.getConnection();
		//System.out.println("Hi");
		//con.setAutoCommit(false);
		
		//sp1 = con.setSavepoint("sp1");
		// step-3 : create jdbc-statements with SQL
		String sql1 = "select * from transaction where accountid=1";
		Statement st1 = con.createStatement();
		ResultSet rs=st1.executeQuery(sql1);
		while(rs.next()){
            //Display values
            System.out.print("transactionid: " + rs.getInt("transactionid"));
            System.out.print(", date: " + rs.getDate("date"));
            System.out.print(", amount: " + rs.getDouble("amount"));
            System.out.println(", debit: " + rs.getDouble("debit"));
            System.out.println(", accountid: " + rs.getInt("accountid"));
         }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}
	
}

