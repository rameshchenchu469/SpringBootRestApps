package com.nt.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PreparedStatementTest {

	public static void main(String[] args) {
		try
		{
		Scanner sc=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		PreparedStatement pst1=con.prepareStatement("insert into bank values (?,?,?,?,?)");
		PreparedStatement pst2=con.prepareStatement("select* from bank");
		PreparedStatement pst3=con.prepareStatement("select* from bank where custname=?");
		
		System.out.println("1.addCustomer" + " " + "2.showCustomer" + " "+"3.Show CustomerBy Name" +"4.exit");
		System.out.println("Enter your choice:");
		int choice=Integer.parseInt(sc.nextLine());
		//sc.nextLine();
		
		switch(choice) {
		case 1:
			System.out.println("Enter CustomerId:");
			int cId=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Customer Name:");
			String cName=sc.nextLine();
			System.out.println("Enter Customer AccNo :");
			long accNo=sc.nextLong();
			sc.nextLine();
			System.out.println("Enter Customer Desg:");
			String desg=sc.nextLine();
			System.out.println("Enter Customer deposit Amt:");
			float amt=sc.nextFloat();
			sc.nextLine();
			pst1.setInt(1, cId);
			pst1.setString(2, cName);
			pst1.setLong(3, accNo);
			pst1.setString(4, desg);
			pst1.setFloat(5, amt);
			
			int k = pst1.executeUpdate();
			if(k>0) {
				System.out.println("Customer added successfully......");
			}
			
		case 2:
			boolean flag=false;
			ResultSet rs=pst2.executeQuery();
			while(rs.next()) {
				flag=true;
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getLong(3)+" "+rs.getString(4)+" "+rs.getFloat(5));		
			}
			if(!(flag)) {
				System.out.println("No customers to show..........");
			}
		case 3:
			System.out.println("Enter Customer name to show details:");
			String name1=sc.next();
			pst3.setString(1, name1);
			
		ResultSet	rs1=pst3.executeQuery();
		boolean b=false;
			while(rs1.next()) {
				b=true;
				System.out.println(rs1.getInt(1)+" "+rs1.getString(2)+" "+rs1.getLong(3)+" "+rs1.getString(4)+" "+rs1.getFloat(5));
			}
			if(!(b)) {
				System.out.println("Entered customer name not found......");
			}
			
		case 4:
			System.out.println("program stopped........");
			System.exit(0);
        default:
        	System.out.println("Invalid choice........");
		}
		

	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
