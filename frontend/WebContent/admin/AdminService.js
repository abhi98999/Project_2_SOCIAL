'use strict';

app.factory('AdminService',[
           '$http',
           '$q',
           '$rootScope',
           function($http,$q,$rootScope){
        	   console.log("Admin Service...");
        	   
        	   var BASE_URL = 'http://localhost:8084/backend'
        	   return{
        		   //user related
        		   fetchAllPendingUsers: function(){
        			   
        		console.log("in admin service fetching all pending user function")
    			   return $http.get(BASE_URL+'/PendingUsers')
    			   		.then(
    			   				function(response){
    			   					return response.data;
    			   				},
    			   				function(errResponse){
    			   					console.error('Error While Fatching Pending UserList.');
    			   					return $q.reject(errResponse);
    			   				}
    			   		);
    			   
    		   },
    		   
    		   approveUser: function(username,status){
       			console.log("in admin service  approve user function")
        			   return $http.get(BASE_URL+'/approveUsers/'+ username+'/'+status)
        			   		.then(
        			   				function(response){
        			   					return response.data;
        			   				},
        			   				function(errResponse){
        			   					console.error('Error While Fatching Pending BlogList.');
        			   					return $q.reject(errResponse);
        			   				}
        			   		);
        			   
        		 },
        		
        		 //blog related
        		
        	   
        	   
        	   
        	   
       }
}]);