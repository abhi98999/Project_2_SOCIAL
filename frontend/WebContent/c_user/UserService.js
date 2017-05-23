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
	

}}
])