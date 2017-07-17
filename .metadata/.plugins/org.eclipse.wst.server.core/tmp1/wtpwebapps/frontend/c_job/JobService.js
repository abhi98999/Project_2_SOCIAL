'use strict';

app.factory('JobService',[
           '$http',
           '$q',
           '$rootScope',
           function($http,$q,$rootScope){
        	   console.log("Job Service...");
        	   
        	   var BASE_URL = 'http://localhost:8084/backend'
        	   return{
        		   
        		   fetchAllJobs: function(){
        			   return $http.get(BASE_URL+'/JobList/')
        			   		.then(
        			   				function(response){
        			   					return response.data;
        			   				},
        			   				function(errResponse){
        			   					console.error('Error While Fatching JobList.');
        			   					return $q.reject(errResponse);
        			   				}
        			   		);
        			   
        		   },

        		   fetchMyJobs: function(){
        			   return $http.get(BASE_URL+'/MyJobList/')
        			   		.then(
        			   				function(response){
        			   					console.log('Return list of myjobs'+response.data.length)
        			   					return response.data;
        			   					
        			   				},
        			   				function(errResponse){
        			   					console.error('Error While Fatching MyJobList.');
        			   					return $q.reject(errResponse);
        			   				}
        			   		);
        			   
        		   },
        		   
        		   createJob: function(job){
        			   return $http.post(BASE_URL+'/CreateJob/',job)
        			   		.then(
        			   				function(response){
        			   					return response.data;
        			   				},
        			   				function(errResponse){
        			   					console.error('Error While Creating User');
        			   					return $q.reject(errResponse);
        			   				}
        			   		);
        		   },
        		   
        		   applyForJob: function(jobId){
        			   return $http.get(BASE_URL+'/ApplyForJob/'+jobId)
        			   		.then(
        			   				function(response){
        			   					return response.data;
        			   				},
        			   				function(errResponse){
        			   					console.error('Error While Applying For Job.');
        			   					return $q.reject(errResponse);
        			   				}
        			   		);
        			   
        		   },      
        		  
        		   removejob : function(jobId){
        			   return $http.put(BASE_URL+'/RemoveJob/'+jobId)
        			   .then(
        					   function(response){
        						   return response.data;
        					   },
        				   function(errResponse)
        				   {
        					 console.error('Error while calling rest Controller for Removing job') ;
        					 return $q.reject(errResponse);
        				   }
        			   );
        			   
        		   },

         }
}]);