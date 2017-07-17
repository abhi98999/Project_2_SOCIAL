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

import com.social.backend.model.AppliedJobs;
import com.social.backend.model.JobOpportunities;
import com.social.backend.model.User;
import com.social.backend.DAO.JobOpportunitiesDao;
@RestController
public class JobController {
	
	private static final Logger log = LoggerFactory.getLogger(JobController.class);
	
	@Autowired
	JobOpportunitiesDao jobDao;
	
	
	@RequestMapping(value = "/JobList/", method = RequestMethod.GET)
	public ResponseEntity<List<JobOpportunities>> listAllJobOpportunitiess(){
		log.debug("**********Starting of Method listAllJobOpportunitiess**********");
		List<JobOpportunities> jobList = jobDao.getAllJobList();
		if(jobList.isEmpty()){
			return new ResponseEntity<List<JobOpportunities>>(HttpStatus.NO_CONTENT);
		}else{
			log.debug("**********Size found :- "+jobList.size()+"**********");
			log.debug("**********Ending of Method listAllJobOpportunitiess**********");
			return new ResponseEntity<List<JobOpportunities>>(jobList,HttpStatus.OK);
		}
	}
		
	@RequestMapping(value = "/CreateJob/", method = RequestMethod.POST)
	public ResponseEntity<JobOpportunities> createJobOpportunities(@RequestBody JobOpportunities job){
		log.debug("**********Starting of Method createUser**********");
		if(jobDao.getJobById(job.getJobId()) == null){
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String jobPostedOn = (dateFormat.format(date));
            job.setPostedOn(jobPostedOn);
            job.setJobStatus('1');
			jobDao.saveJob(job);
			log.debug("**********New JobOpportunities Created Successfully**********");
			job = new JobOpportunities();
			job.setErrorMessage("New Job Posted Successfully....!!!");
			return new ResponseEntity<JobOpportunities>(job , HttpStatus.OK);
		}
		log.debug("**********JobOpportunities already Exist with ID :-"+job.getJobId()+" **********");
		job.setErrorMessage("JobOpportunities Already Exist With ID:-"+job.getJobId());
		return new ResponseEntity<JobOpportunities>(job , HttpStatus.OK);
	}
	

	@RequestMapping(value = "/UpdateJob/{id}", method = RequestMethod.PUT)
	public ResponseEntity<JobOpportunities> updateJobOpportunities(@PathVariable("id") String jobId,@RequestBody JobOpportunities job){
		log.debug("**********Starting of Method updateJobOpportunities**********" + jobId);
		if(jobDao.getJobById(job.getJobId()) == null){
			log.debug("**********JobOpportunities Does not Exist with this ID :-"+jobId+"**********");
			job = new JobOpportunities();
			job.setErrorCode("404");
			job.setErrorMessage("JobOpportunities Does not Exist with this ID :-"+jobId);
			return new ResponseEntity<JobOpportunities>(job , HttpStatus.NOT_FOUND);
		}else{
			job.setJobId(jobId);
			jobDao.updateJob(job);
			log.debug("**********JobOpportunities Updated Successfully WITH ID:- "+jobId+"**********");
			return new ResponseEntity<JobOpportunities>(job , HttpStatus.OK);
		}
	}
	

	@RequestMapping(value = "/RemoveJob/{id}", method = RequestMethod.PUT)
	public ResponseEntity<JobOpportunities> removeJobOpportunities(@PathVariable("id") String jobId){
		log.debug("**********Starting of Method removeUser**********");
		JobOpportunities job = jobDao.getJobById(jobId);
		if(job == null){
			log.debug("**********JobOpportunities Does not Exist with this ID :-"+jobId+"**********");
			job = new JobOpportunities();
			job.setErrorCode("404");
			job.setErrorMessage("JobOpportunities Does not Exist with this ID :-"+ jobId);
			return new ResponseEntity<JobOpportunities>(job , HttpStatus.NOT_FOUND);
		}else{
			jobDao.removeJob(jobId);
			log.debug("**********JobOpportunities Deleted Successfully WITH ID:- "+jobId+"**********");
			return new ResponseEntity<JobOpportunities>(job , HttpStatus.OK);
		}
	}


		@RequestMapping(value = "/ApplyForJob/{id}", method = RequestMethod.GET)
		public ResponseEntity<AppliedJobs> applyforjob(@PathVariable("id") String jobId,HttpSession session){
			log.debug("**********Starting of Method applyforjob**********");
			User loggedInUser = (User) session.getAttribute("loggedInUser");
			AppliedJobs job = new AppliedJobs();
			job.setJobId(jobId);
			job.setUserId(loggedInUser.getuUsername());
			job.setJobStatus('1');
			jobDao.applyJob(job);
			return new ResponseEntity<AppliedJobs>(job , HttpStatus.OK);
		}
	
		@RequestMapping(value = "/MyJobList/", method = RequestMethod.GET)
		public ResponseEntity<List<AppliedJobs>> myJobList(HttpSession session){
			try {
				log.debug("**********Starting of Method listAllJobOpportunitiess**********");
				User loggedInUser = (User) session.getAttribute("loggedInUser");
				List<AppliedJobs> jobList = jobDao.getMyAppliedJobs(loggedInUser.getuUsername());
				if(jobList.isEmpty()  ){
					return new ResponseEntity<List<AppliedJobs>>(jobList,HttpStatus.NO_CONTENT);
				}else{
					log.debug("**********Size found :- "+jobList.size()+"**********");
					log.debug("**********Ending of Method listAllJobOpportunitiess**********");
					return new ResponseEntity<List<AppliedJobs>>(jobList,HttpStatus.OK);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<List<AppliedJobs>>(HttpStatus.NO_CONTENT);
			}
		}
}
