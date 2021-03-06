package com.capiot.qrcodegenerator;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class QrCodeGenerator {
	
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
}