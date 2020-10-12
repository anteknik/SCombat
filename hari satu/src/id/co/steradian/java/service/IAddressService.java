package id.co.steradian.java.service;

import java.util.List;

import id.co.steradian.java.domain.Person;

public interface IAddressService {

	Person findById(Long id);
	
	Person findByAddress(String address);
	
	Person findBy(Integer kodepos);

	List<Person> findAll();

	void save(Person person);

}
