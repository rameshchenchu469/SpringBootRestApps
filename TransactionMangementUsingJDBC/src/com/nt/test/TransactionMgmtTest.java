package com.nt.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.util.Scanner;

public class TransactionMgmtTest {

	public static void main(String[] args) {
		try {
			
		Scanner sc = new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
        PreparedStatement pst1=con.prepareStatement("select*from bank where accno=?");
        PreparedStatement pst2=con.prepareStatement("update bank set amount=amount+? where accno=? ");
        if(con.getAutoCommit()==true) {
        	con.setAutoCommit(false);
        }
        Savepoint sp=con.setSavepoint();
        System.out.println("Enter withdraw account number:");
        long wAccNo=sc.nextLong();
        pst1.setLong(1, wAccNo);
        ResultSet rs=pst1.executeQuery();
        if(rs.next()) {
        	Float bal=rs.getFloat(5);
        	System.out.println("avialable balance:"+bal);
        	
        	System.out.println("enter deposit accno:");
        	long dAccNo=sc.nextLong();
            pst1.setLong(1,dAccNo);
            ResultSet rs2=pst1.executeQuery();
            if(rs2.next()) {
            System.out.println("Enter amount to be transfer:");
            float amt=sc.nextFloat();
            
            if(amt<=bal) {
            pst2.setFloat(1, -amt);
            pst2.setLong(2, wAccNo);
            int k=pst2.executeUpdate();
            
            pst2.setFloat(1, amt);
            pst2.setLong(2, dAccNo);
            int i=pst2.executeUpdate();
            
            if(i==1 && k==1) {
            	System.out.println("Transaction successfil........");
            	con.commit();
            }
            else {
            	System.out.println("Transaction failed.......");
            }
            
        } 
            else {
            	System.out.println("Insufficient balance.......");
            }
	}
        else {
        	System.out.println("Invalid deposit account number.......");
        }
		}
        else {
        	System.out.println("Invalid Account Number.......");
        }
		}
        
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
