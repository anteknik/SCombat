package id.co.steradian.java.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class BukuAlamatApp {
	
	private static final Logger logger =Logger.getLogger(BukuAlamatApp.class.getName());

	public static void main(String[] args) {
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			logger.info("Welcome to the Steradian tutorial - Java!");

			logger.info("Please key in your choice:");

			String selection = "";

			while (selection != null && !"3".equals(selection)) {
				logger.info("1 - Create Person");
				logger.info("2 - List Persons");

				selection = br.readLine();
				
				if (selection.equals("1")) {
					logger.info("You selected " + selection);
					
					//panggil method instantiate person
				}
				
				if (selection.equals("2")) {
					logger.info("You selected " + selection);
					
					//pangill method service disini
				}
			}

			logger.info("Thank you and goodbye!");

		} catch (final Exception ex) {
			logger.info("Exception occured :"+ex.getMessage());
		}
	}

}
