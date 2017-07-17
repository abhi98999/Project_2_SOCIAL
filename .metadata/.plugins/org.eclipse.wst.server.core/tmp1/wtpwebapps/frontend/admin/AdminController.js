'use strict';

app.controller('AdminController',[
	'$scope',
	'AdminService',
	'BlogService',
	'UserService',
	'$location',
	'$rootScope',
	'$cookieStore',
    '$http',
	function($scope,AdminService,BlogService,UserService,$location,$rootScope,$cookieStore,$http){
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
    	
    			self.blog={
    					
    					blogId : '',
    	    			blogTitle : '',
    	    			blogDescription : '',
    	    			blogCreatedAt : '',
    	    			blogModifiedAt : '',
    	    			approvalStatus : '',
    	    			blogStatus : '',
    	    			errorCode : '',
    	    			errorMessage : ''
    					
    			}
    	
    	self.users = [];
    	self.pendingUsers = [];
    	self.pendingBlogs=[];
    	
  	
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
    	
    	self.fetchAllPendingUsers();
    	
    	self.fetchAllUsers = function(){
     		 console.log("FetchAllUsers");
     		 UserService.fetchAllUsers()
     			 .then(function(d){
     				 self.users = d;
     			 		},function(errResponse){
     				 console.error('Error while fetching Users');
     			 });
     	};   	
    	self.fetchAllUsers();

    	
    	//Blog Related
    	
    	self.fetchAllPendingBlogs = function(){
    		console.log("in fectchingblog method");
    		 AdminService.fetchAllPendingBlogs()
    		 .then(
    				 function(d){
    					self.pendingBlogs = d;
    					},
    					 function(errResponse){
    					 console.error('Error While Fatching Pending Blogs.');
    			 });
    		}; 	 
    	
    		self.fetchAllPendingBlogs();
    	
    	function getBlog(blogId,status){
    			console.log("->->Getting Blog with ID :-"+blogId+"AND Status :-"+status);
        		BlogService.getBlog(blogId,status)
        		.then(
        				function(d){
        				$rootScope.selectedBlog = d;
            			$http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.selectedBlog;
            			$cookieStore.put('selectedBlog',$rootScope.selectedBlog);
        				$location.path('/view_blog');
        				 },
        				 function(errResponse){
        					 console.error('Error While fetching Blogs.');
        					 });
        		};
        	
        	
        self.SelectedapproveBlog = approveBlog 
        
        function approveBlog(blogId,status){
        console.log("approveBlog Blog with ID :-"+blogId+" "+status);
        	AdminService.approveBlog(blogId,status)
        	.then(
        			self.fetchAllPendingBlogs,
        			function(errResponse){
        			console.error('Error While approve Blogs.');
        			});
        		};
        	

    	
}]);