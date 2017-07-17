package com.social.backend.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.social.backend.model.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	
	@Autowired
	SessionFactory sessionfactory;
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);


	
	public boolean addUser(User user) {
		try{
		Session sf= sessionfactory.getCurrentSession();
		System.out.println("in dao");
		sf.persist(user);
		logger.debug("successfully added");
		return true;
		}
		catch(Exception e){
			System.out.println("in exception");
			return false;}
	}
		
	public boolean approveUser(String uUsername, String status) {
		char accountStatus;
		try {
			logger.debug("Starting Method approveUser.");
			if(status.equals("A")){
				accountStatus = '1';
			}else{
				accountStatus = '0';
			}
				sessionfactory.getCurrentSession().createQuery("Update User set accountStatus = '"+accountStatus+"' , approveStatus = '"+status+"' where uUsername = '"+uUsername+"'").executeUpdate();
			logger.debug("User approved with USERNAME:-"+uUsername);
			logger.debug("Ending Method approveUser.");
			return true;
		} catch (HibernateException e) {
			logger.error("Error Occured in approving user with (USERNAME = '"+uUsername+"') "+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public List<User> getAllUsersForApproval() {
		try {
		
			logger.debug("Starting of Method getAllUsersForApproval");
				Query query = sessionfactory.getCurrentSession().createQuery("FROM User WHERE approveStatus = 'P'");
				logger.debug("Starting of get UsersList for Approval");
				@SuppressWarnings("unchecked")
				List<User> list = query.list();
				if(list==null || list.isEmpty()){
					logger.debug("No User's are Availible");
				}
				for(User u:list)
				{
					System.out.println(u.getuEmailId());
					
				}
			logger.debug("Ending of Method getAllUsersForApproval");
			logger.debug("Number of Records Found :-" + list.size());
			return list;
		}catch (HibernateException e) {
			logger.error("Error Occured in Method getAllUsersForApproval :-"+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public User userGetById(String uUsername) {
		try {
				logger.debug("Starting of Method userGetById :- "+uUsername);
					Query query = sessionfactory.getCurrentSession().createQuery("FROM User WHERE uUsername='"+uUsername+"' AND accountStatus = '1'");
					logger.debug("Starting of get UsersList");
					@SuppressWarnings("unchecked")
					List<User> list = query.list();
					if(list==null || list.isEmpty()){
						logger.debug("No User's are Availible");
						return null;
					}else{
						logger.debug("Ending of Method userGetById");
						return list.get(0);
					}
			}catch (HibernateException e) {
				logger.error("Error Occured in Method userGetById :-"+e.getMessage());
				e.printStackTrace();
				return null;
			}
		}

	public User isValidUser(String uUsername, String uPassword) {
		try {
			logger.debug("Starting of Method isValidUser");
				Query query = sessionfactory.getCurrentSession().createQuery("FROM User WHERE uUsername = '"+uUsername+"' AND uPassword = '"+uPassword+"' AND accountStatus = 1");
				logger.debug("Starting of get UsersList");
				@SuppressWarnings("unchecked")
				List<User> list = query.list();
				if(list != null && !list.isEmpty()){
					logger.debug("Ending of Method isValidUser");
					return list.get(0);
				}else{
					logger.debug("No User's are Availible");
					logger.debug("Ending of Method isValidUser");
					return null;
				}
		}catch (HibernateException e) {
			logger.error("Error Occured in Method isValidUser :-"+e.getMessage()+".");
			e.printStackTrace();
			return null;
		}
	}

	public void setOnLine(String username) {
		try {
				logger.debug("**********Starting of Method setOnLine.With Id **********"+username);
				sessionfactory.getCurrentSession().createQuery("UPDATE User SET uIsOnline = 'Y' WHERE uUsername = '"+username+"'").executeUpdate();
				logger.debug("Ending of Method setOnLine");
			} catch (Exception e) {
					e.printStackTrace();
					logger.debug("Error Occuring while SetOnline Finction");
			}		
		}

	public void setOffLine(String username) {
		try {
			logger.debug("Starting of Method setOnLine. with Id : **********"+username);
				sessionfactory.getCurrentSession().createQuery("UPDATE User SET uIsOnline = 'N' WHERE uUsername = '"+username+"'").executeUpdate();
				logger.debug("**********Ending of Method setOnLine.**********");
		} catch (Exception e) {
				e.printStackTrace();
				logger.debug("**********Error Occuring while SetOnline Finction..**********");
		}
		
	}

	public List<User> getAllUsers() {
		try {
			logger.debug("**********Starting of Method getAllUsers.**********");
				Query query = sessionfactory.getCurrentSession().createQuery("FROM User WHERE accountStatus = 1");
				logger.debug("**********Starting of get UsersList.**********");
				@SuppressWarnings("unchecked")
				List<User> list = query.list();
				if(list==null || list.isEmpty()){
					logger.debug("**********No User's are Availible.**********");
				}
			logger.debug("**********Ending of Method getAllUsers.**********");
			logger.debug("**********Number of Records Found :-" + list.size()+".**********");
			return list;
		}catch (HibernateException e) {
			logger.error("**********Error Occured in Method getAllUsers :-"+e.getMessage()+".**********");
			e.printStackTrace();
			return null;
		}
	}

	public boolean updateUser(User user) {
		try {
			logger.debug("Starting Method updateUser.");
				sessionfactory.getCurrentSession().update(user);
				sessionfactory.getCurrentSession().flush();
			logger.debug("Ending Method updateUser");
			return true;
		} catch (HibernateException e) {
			logger.error("Error Occured in Method updateUser:-"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteUser(String uUsername) {
		try {
			logger.debug("Starting Method deleteUser.");
				sessionfactory.getCurrentSession().createQuery("Update User set accountStatus = 0 where uUsername = '"+uUsername+"'").executeUpdate();
			logger.debug("UserDetail removed with Id:-"+uUsername);
			logger.debug("Ending Method deleteUser.");
			return true;
		} catch (HibernateException e) {
			logger.error("Error Occured in deleteUser with (id = '"+uUsername+"') "+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	
}




