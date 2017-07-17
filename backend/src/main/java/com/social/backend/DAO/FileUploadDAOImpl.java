package com.social.backend.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.social.backend.model.FileUpload;

@EnableTransactionManagement
@Transactional
@Repository("fileUploadDao")
public class FileUploadDAOImpl implements FileUploadDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(FileUpload fileUpload) {
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(fileUpload);
		session.flush();
		session.close();		
	}

	public FileUpload getFileUploaded(String username) {
		Session session=sessionFactory.openSession();
		FileUpload file=(FileUpload)
		session.get(FileUpload.class, username);
		session.close();
		return file;
	}

	
	
}
