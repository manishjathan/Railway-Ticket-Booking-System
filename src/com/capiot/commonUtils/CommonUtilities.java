package com.capiot.commonUtils;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capiot.entity.Customer;
import com.capiot.entity.Ticket;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class CommonUtilities {
	
	final static String url = "jdbc:mysql://localhost:3306/railway_ticket_management_system";
    final static String uname = "springstudent";
    final static String pass = "springstudent";
    static Connection con;
	
	public static void saveImage(String imageUrl, String destinationFile) throws IOException {
		URL url = new URL(imageUrl);
		InputStream is = url.openStream();
		String finalDestinationFile = "C:\\Users\\capiot\\eclipse-workspace2\\railway-ticket-mgmt-system\\WebContent\\resources\\"+destinationFile;
		OutputStream os = new FileOutputStream(finalDestinationFile);
		
		byte[] b = new byte[2048];
		int length;
		System.out.println("Saving Image....");
		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}
		System.out.println("Image Saved!");
		is.close();
		os.close();
	}
	
	public static Ticket setTotalFare(Ticket ticket) throws ClassNotFoundException, SQLException {
		String source = ticket.getSource();
		String dest = ticket.getDestination();
		String journeyType = ticket.getJourneyType();
		int fare = CommonUtilities.fetchFareDetails(source, dest, journeyType);
		ticket.setTotalFare(fare);
		return ticket;
	}
	
	public static int fetchFareDetails(String source, String dest, String journeyType) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver"); 
    	con = (Connection) DriverManager.getConnection(url,uname,pass); 
    	
    	String query = "select * from faredetails where source = ? AND destination = ? AND journeyType = ?";
    	PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
    	ps.setString(1, source);
    	ps.setString(2, dest);
    	ps.setString(3, journeyType);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int fare = rs.getInt(5);
		return fare;
	}
	
	public static Customer deductWalletMoney(Customer customer, int totalFare) {
		// TODO Auto-generated method stub
		int walletMoney = customer.getWallet().getAmount();
		if(totalFare < walletMoney) {
		int newWalletMoney = walletMoney - totalFare;
		customer.getWallet().setAmount(newWalletMoney);
		}
		return customer;
	}
}