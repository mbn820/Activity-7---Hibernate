package com.exist.ecc.core.dao;

import com.exist.ecc.core.model.Role;
import java.util.List;

public class RoleDao {

	public Integer addRole(Role role) {
		return (Integer) new HibernateUtil().transact(session -> session.save(role));
	}

	public Role getRole(int id) {
		return (Role) new HibernateUtil().transact(session -> session.get(Role.class, id));
	}

	public List<Role> getAllRoles() {
		return (List<Role>) new HibernateUtil().transact(session -> session.createQuery("FROM Role").list());
	}

	public void updateRole(Role role) {
		new HibernateUtil().transact( session -> { session.update(role); return null; } );
	}

	public void deleteRole(int id) {
		new HibernateUtil().transact( session -> { session.delete(getRole(id)); return null; } );
	}

}
