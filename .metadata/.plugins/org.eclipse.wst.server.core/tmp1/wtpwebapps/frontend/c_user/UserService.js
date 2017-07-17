'use strict';
app.service('UserService', ['$http','$q','$rootScope', function($http,$q,$rootScope){
console.log("UserService")
	
var BASE_URL ='http://localhost:8084/backend'
	console.log("in service");

	return{
	createUser : function(user)
	{
		console.log("in service function");
		return $http.post(BASE_URL+'/adduser',user)
			.then(
				function(response){
					return response.data;
				},
				function(errResponse){
					console.error('Error while creating user');
					return $q.reject(errResponse);
				}
		     		
		);
		
		
	},
	
	 fetchAllPendingUsers: function(){
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
	   
	   authenticate : function(user){
		   console.log("authemticate in service controller");
		   return $http.post(BASE_URL+'/Authentication',user)
		   		.then(function(response){
	   				return response.data;
			   	},
			   	function(errResponse){
			   		console.error('Error While Authentication User.');
			   		return $q.reject(errResponse);
			   	});

	   },
	   
	   logout : function(){
		   return $http.get(BASE_URL+'/Logout')
		   	.then(function(response){
		   				return response.data;
		   	},
		   	function(errResponse){
		   		console.error('Error While Logging Out');
		   		return $q.reject(errResponse);
		   	});
	   },

	   fetchAllUsers: function(){
		   return $http.get(BASE_URL+'/Users')
		   		.then(
		   				function(response){
		   					return response.data;
		   				},
		   				function(errResponse){
		   					console.error('Error While Fatching UserDetail.');
		   					return $q.reject(errResponse);
		   				}
		   		);
		   
	   },
	   
}}])