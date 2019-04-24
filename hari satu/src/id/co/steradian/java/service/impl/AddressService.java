package id.co.steradian.java.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.co.steradian.java.domain.Person;
import id.co.steradian.java.service.IAddressService;

public class AddressService implements IAddressService {
	
    private Map<String, Person> addressMap = new HashMap<String, Person>();


	@Override
	public Person findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> findAll() {
		final List<Person> result = new ArrayList<Person>(addressMap.values());
		
		//methode result di implementasikan disini
		
		return null;
	}

	@Override
	public void save(Person person) {
		// TODO Auto-generated method stub
		
	}

}
