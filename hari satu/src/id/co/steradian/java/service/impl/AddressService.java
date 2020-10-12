package id.co.steradian.java.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import id.co.steradian.java.domain.Address;
import id.co.steradian.java.domain.Person;
import id.co.steradian.java.service.IAddressService;

public class AddressService implements IAddressService {
	

	private static final Logger logger =Logger.getLogger(AddressService.class.getName());
	
    private final Map<String, Person> addressMap = new HashMap<String, Person>();

	@Override
	public Person findById(Long id) {
		List<Person> result = findAll();
		System.out.println("CarService:findById : " + id);
		for (Person p : result) {
			if (id.equals(p.getId())) {
				return p;
			}
			
		}
		return result.get(0);
	}
	
	@Override
	public Person findBy(Integer kodepos) {
		
		return null;
	}
	
	@Override
	public Person findBy(Address address) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Person> findAll() {
		final List<Person> result = new ArrayList<Person>(addressMap.values());
		
		return result;
	}

	@Override
	public void save(Person person) {
		long n = addressMap.size();
		n = n + 1;
		
		Person p = new Person();
		//Address a = new Address();
		person.setId(n);
		p.setId(n);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		logger.info("input nama");
		String input;
		try {
			input = br.readLine();
			p.setNama(input);
			logger.info("input status");
			input = br.readLine();
			p.setStatus(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addressMap.put("person" + person.getId(), p);
		System.out.println("AddressService:save" + n);
		
	}

}
