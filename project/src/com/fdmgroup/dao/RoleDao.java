package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.Company;
import com.fdmgroup.model.CompanyType;
import com.fdmgroup.model.Role;
import com.fdmgroup.model.User;

public class RoleDao {

	private DbConnection con;
	private EntityManager em;
	public RoleDao() {
		super();
		// TODO Auto-generated constructor stub
		
		con = DbConnection.getInstance();
		}

	public boolean create(Role role)
	{
		em=con.getEntityManager();
		em.getTransaction().begin();
		em.persist(role);
		em.getTransaction().commit();
		em.close();
		return true;
		
		
	}
	
	public Role findByRoleName(String name){
        em=con.getEntityManager();
        TypedQuery<Role> query=em.createNamedQuery("role.RoleType", Role.class);
        query.setParameter("name", name);
        List<Role> roles=query.getResultList();
        em.close();
        if(roles!=null && roles.size()==1){
        	 return  roles.get(0);
        }
		return null;
        }
       
       

	
	
	public boolean delete(int id)
	{
		em=con.getEntityManager();
		em.getTransaction().begin();
		Role managedRole= em.find(Role.class, id);
		em.remove(managedRole);
		em.getTransaction().commit();
		em.close();
		return true;
		
		
	}
}
