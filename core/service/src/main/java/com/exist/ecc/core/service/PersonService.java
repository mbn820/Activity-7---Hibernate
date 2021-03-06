package com.exist.ecc.core.service;

import com.exist.ecc.core.model.Person;
import com.exist.ecc.core.model.Role;
import com.exist.ecc.core.dao.PersonDao;
import java.util.List;
import java.util.Set;

public class PersonService {
	public Integer addPerson(Person person) {
		return new PersonDao().addPerson(person);
	}

	public Person getPerson(int id) {
		return new PersonDao().getPerson(id);
	}

	public List<Person> getAllPerson(String orderBy) {
		return new PersonDao().getAllPerson(orderBy);
	}

	public void deletePerson(int id) {
		new PersonDao().deletePerson(id);
	}

	public void updatePerson(Person person) {
		new PersonDao().updatePerson(person);
	}

	public boolean isEmpty() {
		return new PersonDao().getAllPerson("id").isEmpty();
	}

}
