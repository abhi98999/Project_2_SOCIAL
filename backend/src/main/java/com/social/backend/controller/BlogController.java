package com.social.backend.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.social.backend.DAO.BlogDao;
import com.social.backend.model.Blog;
import com.social.backend.model.User;



@RestController
public class BlogController {
	
	private static final Logger log = LoggerFactory.getLogger(BlogController.class);
	
	@Autowired
	BlogDao blogDao;
	
	
	@RequestMapping(value = "/BlogList", method = RequestMethod.GET)
	public ResponseEntity<List<Blog>> listAllBlogs(){
		log.debug("**********Starting of Method listAllBlogs**********");
		List<Blog> blogList = blogDao.getAllBlogs();
		if(blogList.isEmpty() || blogList == null){
			return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
		}else{
			log.debug("**********Size found :- "+blogList.size()+"**********");
			log.debug("**********Ending of Method listAllBlogs**********");
			return new ResponseEntity<List<Blog>>(blogList,HttpStatus.OK);
		}
	}
	
	
	@RequestMapping(value = "/getMyBlogList", method = RequestMethod.GET)
	public ResponseEntity<List<Blog>> getMyBlogList(HttpSession session){
		try {
			log.debug("**********Starting of Method getMyBlogList**********");
			User loggedInUser = (User) session.getAttribute("loggedInUser");
			List<Blog> blogList = blogDao.blogListByUserId(loggedInUser.getuUsername());
			if(blogList.isEmpty()){
				return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
			}else{
				log.debug("**********Size found :- "+blogList.size()+"**********");
				log.debug("**********Ending of Method getMyBlogList**********");
				return new ResponseEntity<List<Blog>>(blogList,HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
		}
	}
	
	
	@RequestMapping(value = "/PendingBlogList", method = RequestMethod.GET)
	public ResponseEntity<List<Blog>> listPendingBlogs(){
		log.debug("Starting of Method listPendingBlogs");
		List<Blog> blogList = blogDao.blogListForApproval();
		if(blogList.isEmpty()){
			return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
		}else{
			log.debug("Size found :- "+blogList.size());
			log.debug("Ending of Method listPendingBlogs");
			return new ResponseEntity<List<Blog>>(blogList,HttpStatus.OK);
		}
	}
	

	@RequestMapping(value = "/CreateBlog", method = RequestMethod.POST)
	public ResponseEntity<Blog> createBlog(@RequestBody Blog blog,HttpSession session){
		log.debug("**********Starting of Method create blog**********");
		if(blogDao.getBlogById(blog.getBlogId(),"0") == null){

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String blogCreatedAt = (dateFormat.format(date));
            
			DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date2 = new Date();
            String blogModifiedAt = (dateFormat2.format(date2));
            
            User loggedInUser = (User) session.getAttribute("loggedInUser");
            blog.setUserId(loggedInUser.getuUsername());
           
            blog.setBlogCreatedAt(blogCreatedAt);
            blog.setBlogModifiedAt(blogModifiedAt);
            blog.setApprovalStatus('P');
            blog.setBlogStatus('0');
            blog.setBlogLike(0);
            blog.setBlogDislike(0);
            
			blogDao.saveBlog(blog);
			log.debug("**********New Blog Created Successfully**********");
			blog = new Blog();
			blog.setErrorMessage("Blog Created Successfully..!!!Wait for the Admin Approval.");
			return new ResponseEntity<Blog>(blog , HttpStatus.OK);
		}
		log.debug("**********Blog already Exist with ID :-"+blog.getBlogId()+" **********");
		blog.setErrorMessage("Blog Already Exist With ID:-"+blog.getBlogId());
		return new ResponseEntity<Blog>(blog , HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/UpdateBlog/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Blog> updateBlog(@PathVariable("id") String blogId,@RequestBody Blog blog){
		log.debug("**********Starting of Method updateBlog**********" + blogId);
		if(blogDao.getBlogById(blogId,"1") == null){
			log.debug("**********Blog Does not Exist with this ID :-"+blogId+"**********");
			blog = new Blog();
			blog.setErrorCode("404");
			blog.setErrorMessage("Blog Does not Exist with this ID :-"+blogId);
			return new ResponseEntity<Blog>(blog , HttpStatus.NOT_FOUND);
		}else{
			blog.setBlogId(blogId);
			blogDao.updateBlog(blog);
			log.debug("**********Blog Updated Successfully WITH ID:- "+blogId+"**********");
			return new ResponseEntity<Blog>(blog , HttpStatus.OK);
		}
	}
	

	@RequestMapping(value = "/RemoveBlog/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Blog> removeBlog(@PathVariable("id") String blogId){
		log.debug("**********Starting of Method removeUser**********");
		Blog blog = blogDao.getBlogById(blogId,"1");
		if(blog == null){
			log.debug("**********Blog Does not Exist with this ID :-"+blogId+"**********");
			blog = new Blog();
			blog.setErrorCode("404");
			blog.setErrorMessage("Blog Does not Exist with this ID :-"+ blogId);
			return new ResponseEntity<Blog>(blog , HttpStatus.NOT_FOUND);
		}else{
			blogDao.removeBlog(blogId);
			log.debug("**********Blog Deleted Successfully WITH ID:- "+blogId+"**********");
			return new ResponseEntity<Blog>(blog , HttpStatus.OK);
		}
	}

	
	@RequestMapping(value = "/GetBlogById/{id}/{status}",method = RequestMethod.GET)
	public ResponseEntity<Blog> getBlogById(@PathVariable("id") String blogId,@PathVariable("status") String status){
		log.debug("**********Starting of Method getBlogById**********");
		Blog blog = blogDao.getBlogById(blogId,status); //Send Status in URL .***
		if(blog == null){
			log.debug("**********Blog Does not Exist with this ID :-"+blogId+"**********");
			blog = new Blog();
			blog.setErrorCode("404");
			blog.setErrorMessage("Blog Does not Exist with this ID :-"+ blogId);
			return new ResponseEntity<Blog>(blog , HttpStatus.NOT_FOUND);
		}else{
			log.debug("**********Blog Found Successfully WITH ID:- "+blogId+"**********");
			return new ResponseEntity<Blog>(blog , HttpStatus.OK);
		}
	}
	
	
	@RequestMapping(value = "/ApproveBlog/{blogId}/{status}", method = RequestMethod.GET)
	public ResponseEntity<Blog> approveBlog(@PathVariable("blogId") String blogId,@PathVariable("status") String status){
		log.debug("**********Starting of Method approveBlog WITH BLOG_ID :-**********" + blogId);
		Blog blog = blogDao.getBlogById(blogId,"0");
		if(blog == null){
			log.debug("**********Blog Does not Exist with this ID :-"+blogId+"**********");
			blog = new Blog();
			blog.setErrorCode("404");
			blog.setErrorMessage("Blog Does not Exist with this ID :-"+blogId);
			return new ResponseEntity<Blog>(blog , HttpStatus.NOT_FOUND);
		}else{
			blog.setBlogId(blogId);
			blogDao.approveBlog(blogId,status);
			log.debug("**********Blog Approved Successfully WITH ID:- "+blogId+"**********");
			return new ResponseEntity<Blog>(blog , HttpStatus.OK);
		}
	}
	
	
	@RequestMapping(value = "/Like/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Blog> likeBlog(@PathVariable("id") String blogId){
		log.debug("**********Starting of Method updateBlog**********" + blogId);
		
			blogDao.bloglikes(blogId);
			log.debug("**********Blog Updated Successfully WITH ID:- "+blogId+"**********");
			return new ResponseEntity<Blog>(HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/DisLike/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Blog> disLikeBlog(@PathVariable("id") String blogId){
		log.debug("**********Starting of Method updateBlog**********" + blogId);
			blogDao.blogdislikes(blogId);
			log.debug("**********Blog Updated Successfully WITH ID:- "+blogId+"**********");
			return new ResponseEntity<Blog>(HttpStatus.OK);
	}
}
