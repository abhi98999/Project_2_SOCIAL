'use strict';

app.controller('UserController', [
		'$scope',
		'UserService',
		'$location',
		'$rootScope',
		'$http',
		function($scope, UserService, $location, $rootScope,$http) {
			console.log("UserController.....")
			var self = this;
			self.user = {
					
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

			self.submit = function()
				{
					console.log('Saving new user', self.user);
					self.addUser(self.user);
				}
			
			self.addUser = function(user) {
				UserService.createUser(user).then(
						function(errResponse) {
							console.error('Error while creating user');
						});

			};
			
			self.login = function(){
        		{
        			console.log('In Login Authenticate User.',self.user);
        			self.authenticate(self.user);
        		}
        	 
        	};
        	
        	/*self.logout = function(){
        		$rootScope.currentUser = {};
        		UserService.logout()
        			.then(function(d){
        				console.error('Logout And Navigate IndexPage.');
        				$location.path('/');
        				console.error('Not Logout And Navigate IndexPage.');
        			},
        			function(errResponse){
                    	console.error('Error While Logout Users.');
                    });*/
			
			self.authenticate = function(user){
        		console.log("In Authenticate...");
        		UserService.authenticate(user)
        			.then(function(d){
        				self.user = d;
        				console.log("user.errorCode :- " + self.user.errorCode)
        				if(self.user.errorCode == "404"){
        					self.user.uUsername = "";
        					self.user.upassword = "";
        				}else{
        					console.log("Valid Credentials. Navigating to Home Page.")
   			   				$rootScope.currentUser = {
			   						fullName : self.user.uFullName,
			   						username : self.user.uUsername,
			   						userRole : self.user.uRole
			   				};
        					$http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.currentUser;
        					$location.path('/profile');
        				}
        			},
        			function(errResponse){
        				console.error('Error While Authenticate Users.');
        			});
        	};
			
			
	
			
			
}])