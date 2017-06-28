'use strict';

app.controller('AdminController',[
	'$scope',
	'AdminService',
	'$location',
	'$rootScope',
    '$http',
	function($scope,AdminService,$location,$rootScope,$http){
    	console.log("Admin Controller")
    	var self = this; 
    	self.user={
    		uFullName : '',
			uUsername : '',
			uPassword : '',
			uEmailId:'',
			uIsOnline:'',
			uRole:'',
			approveStatus : '',
			accountStatus : '',
			errorCode:'',
			errorMessage:''
				};

    	self.users = [];
    	self.pendingUsers = [];
    	self.pendingBlogs = [];
  	
    	//User Functions
     	
    	self.fetchAllPendingUsers = function(){
    		console.log("FetchAll Pending Users List.");
    		AdminService.fetchAllPendingUsers()
    			.then(function(d){
    				self.pendingUsers = d;
    		
    			},function(errResponse){
    				console.error('Error while fetching Users');
    			});
    	};
    	
    	self.fetchAllPendingUsers();
    	
    	
    	self.SelectedapproveUser = approveUser;
    	function approveUser(Username,status){
    		console.log("->->approveUser User with ID :-"+Username+" "+status);
    		AdminService.approveUser(Username,status)
    			.then(
    					self.fetchAllPendingUsers,
    					function(errResponse){
    						console.error('Error While approve Users.');
    					});
    	};
    	
    	// Blog Functions
    	
    	 	 
	   

    	
}]);