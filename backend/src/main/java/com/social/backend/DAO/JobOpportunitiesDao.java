package com.social.backend.DAO;


import java.util.List;

import com.social.backend.model.AppliedJobs;
import com.social.backend.model.JobOpportunities;

public interface JobOpportunitiesDao {

	public boolean saveJob(JobOpportunities job);
	
	public boolean updateJob(JobOpportunities job);
	
	public boolean removeJob(String jobId);
	
	public List<JobOpportunities> getAllJobList();
	
	public boolean applyJob(AppliedJobs job);
	
	public JobOpportunities getJobById(String jobId);
	
	public List<AppliedJobs> getMyAppliedJobs(String userId);
}
