package com.social.backend.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.social.backend.configuration.AppConfig;
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
		user.setuIsOnline('N'); // online status can be yes (Y) or no(N)
		user.setAccountStatus('0'); //Account status can be either 0 or 1
		user.setApproveStatus('p'); //status can be approved(A),pending(p),rejected(R)
		sf.persist(user);
		logger.debug("successfully added");
		return true;
		}
		catch(Exception e){
			System.out.println("in exception");
			return false;}
	}

}
