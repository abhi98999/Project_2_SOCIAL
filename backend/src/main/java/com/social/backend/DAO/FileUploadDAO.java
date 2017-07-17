package com.social.backend.DAO;

import com.social.backend.model.FileUpload;

public interface FileUploadDAO {

	
	void save(FileUpload fileUpload);
	FileUpload getFileUploaded(String username);
}
