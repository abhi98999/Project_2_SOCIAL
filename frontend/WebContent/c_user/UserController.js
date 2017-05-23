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
	
			
			
}])