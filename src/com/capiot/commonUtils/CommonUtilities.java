package com.capiot.commonUtils;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import com.capiot.dao.FareDetailsDAOImpl;
import com.capiot.entity.Customer;
import com.capiot.entity.FareDetails;
import com.capiot.entity.Ticket;

public class CommonUtilities {
	
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
	
	public static Ticket setTotalFare(Ticket ticket) {
		String source = ticket.getSource();
		String dest = ticket.getDestination();
		String journeyType = ticket.getJourneyType();
		FareDetailsDAOImpl fareDetailsDAOImpl = new FareDetailsDAOImpl();
		FareDetails fareDetails = fareDetailsDAOImpl.fetchFareDetails(source, dest, journeyType);
		int fare = fareDetails.getFareValue();
		ticket.setTotalFare(fare);
		return ticket;
	}
	

	public static Customer deductWalletMoney(Customer customer, int totalFare) {
		// TODO Auto-generated method stub
		int walletMoney = customer.getWallet().getAmount();
		int newWalletMoney = walletMoney - totalFare;
		customer.getWallet().setAmount(newWalletMoney);
		return customer;
	}
}