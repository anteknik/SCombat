package id.co.steradian.java.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Logger;

import id.co.steradian.java.domain.Person;
import id.co.steradian.java.service.IAddressService;
import id.co.steradian.java.service.impl.AddressService;

public class BukuAlamatApp {

	private static final Logger logger = Logger.getLogger(BukuAlamatApp.class.getName());

	public static void main(String[] args) {

		IAddressService service = new AddressService();
		Person person = new Person();

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

					service.save(person);
				}

				if (selection.equals("2")) {
					logger.info("You selected " + selection);

					List<Person> result = service.findAll();
					System.out.println("isi list : " + result.size());

					for (Person p : result) {

						System.out.println("person : " + "" + p.getId() + "==" + p.getNama() + " " + p.getStatus());
					}

				}
				
				if (selection.equals("4")) {
					logger.info("input id");
					String input = br.readLine();
					Long in = Long.valueOf(input);
					Person p = service.findById(in);
					System.out.println(
							"model : " + p.getId() + "==" + p.getId() + "==" + p.getNama() + " " + p.getStatus());
				}
				
				if (selection.equals("5")) {
					logger.info("search jalan : ");
					String input = br.readLine();
					Person p = service.findByAddress(input);
					System.out.println("model : " + p.getId() + "==" + p.getId() + "==" + p.getNama() + " "
							+ p.getStatus() + " " + p.getAlamat().getJalan());
				}
			}
			logger.info("Thank you and goodbye!");

		} catch (final Exception ex) {
			logger.info("Exception occured :" + ex.getMessage());
		}
	}

}
