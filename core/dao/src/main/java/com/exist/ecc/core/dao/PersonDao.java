package com.exist.ecc.core.dao;

import java.util.List;
import com.exist.ecc.core.model.Person;
import com.exist.ecc.core.model.Role;

public class PersonDao implements PersonDaoInterface {

	public Integer addPerson(Person person) {
		return (Integer) new HibernateUtil().transact(session -> session.save(person));
	}

	public Person getPerson(int id) {
		return (Person) new HibernateUtil().transact(session -> session.get(Person.class, id));
	}

	public List<Person> getAllPerson(String orderBy) {
		return (List<Person>) new HibernateUtil().transact(session -> session.createQuery("FROM Person p ORDER BY p." + orderBy).list());
	}

	public void updatePerson(Person person) {
		new HibernateUtil().transact(session -> { session.update(person); return null; });
	}

	public void deletePerson(int id) {
		new HibernateUtil().transact( session -> { session.delete(getPerson(id)); return null; } );
	}

	public List<Role> getRoles() {
		return (List<Role>) new HibernateUtil().transact(session -> session.createQuery("FROM Role").list());
	}

	public void addRole(Role role) {
		new HibernateUtil().transact(session -> { session.saveOrUpdate(role); return null; });
	}

	public List<Role> getAllRoles() {
		return (List<Role>) new HibernateUtil().transact(session -> session.createQuery("FROM Role").list());
	}
}
