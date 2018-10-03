package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.AdminUser;
import com.fdmgroup.model.Company;
import com.fdmgroup.model.CompanyType;
import com.fdmgroup.model.Role;
import com.fdmgroup.model.User;

public class UserDao {
	
	private DbConnection con;
	private EntityManager em;
	
	public UserDao() {
		super();
		// TODO Auto-generated constructor stub
		con=DbConnection.getInstance();
	}
	
/*public void create(User user)
{
	em=con.getEntityManager();
	em.getTransaction().begin();
	em.persist(user);
	em.getTransaction().commit();
	em.close();
	
	
}*/

public boolean create(User user)
{
	em=con.getEntityManager();
	em.getTransaction().begin();
	em.persist(user);
	em.getTransaction().commit();
	em.close();
	return true;
	
	
}

public List<User> findAll(){
	em=con.getEntityManager();
	TypedQuery<User> query= em.createNamedQuery("user.findAll", User.class);
	
	List<User> users=query.getResultList();
	em.close();
	return users;
	
	
}

public List<User> findByFirstName(String fname){
	em=con.getEntityManager();
	TypedQuery<User> query= em.createNamedQuery("user.findByFirstName", User.class);
	query.setParameter("fname", fname+"%");
	
	List<User> users=query.getResultList();
	em.close();
	return users;
	
	
}

public List<User> findByRoleName(Role role){
	em=con.getEntityManager();
	TypedQuery<User> query= em.createNamedQuery("user.findByRoleName", User.class);
	query.setParameter("rname", role);
	
	
	List<User> users=query.getResultList();
	em.close();
	return users;
	
	
}


public List<AdminUser> findAllAdmins(){
	em=con.getEntityManager();
	TypedQuery<AdminUser> query= em.createNamedQuery("user.findAllAdmins", AdminUser.class);
	query.setParameter("Adminuser", AdminUser.class);
	
	
	List<AdminUser> users=query.getResultList();
	if(users!=null && users.size()==1)
	{
		return users;
	}
	
	
	em.close();
	return users;
	
	
}


public User findById(int id){
	em=con.getEntityManager();
	
	User user= em.find(User.class, id);
	em.close();
	return user;
	
	
}


public List<User> findByUsername(String uname){
	em=con.getEntityManager();
	TypedQuery<User> query= em.createNamedQuery("user.findByUserName", User.class);
	query.setParameter("uname", uname);
	User user= query.getSingleResult();
	List<User> users= query.getResultList();
	if(users!=null && users.size()==1)
	{
		return users;
	}
	
	
	em.close();
	return users;
	
	
	
}


public List<Company> findByCompantType(CompanyType type){
	em=con.getEntityManager();
	TypedQuery<Company> query= em.createNamedQuery("company.findByCompanyType", Company.class);
	query.setParameter("ctype", type);
	Company company= query.getSingleResult();
	List<Company> types= query.getResultList();
	if(types!=null && types.size()==1)
	{
		return types;
	}
	
	
	em.close();
	return types;
	
	
	
}

public boolean delete(int id){
	em=con.getEntityManager();
	User managedUser= em.find(User.class, id);
	em.getTransaction().begin();
	em.remove(managedUser);
	em.getTransaction().commit();
	em.close();
	return true;
}

public boolean softdelete(int id) {
	// TODO Auto-generated method stub
	em=con.getEntityManager();
	User managedUser= em.find(User.class, id);
	em.getTransaction().begin();
	managedUser.setActive(false);
	em.remove(managedUser);
	em.getTransaction().commit();
	em.close();
	return true;
}
}
