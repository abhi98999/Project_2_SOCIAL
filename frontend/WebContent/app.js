'use strict';

var app = angular.module('myApp', [ 'ngRoute']);

app.config(function($routeProvider) {
	$routeProvider
	.when('/register',{
		
		templateUrl : 'c_user/register.html',
		controller  : 'UserController'
		
		
	})
	.when('/login',{
		
		templateUrl : 'c_user/login.html',
		controller  : 'UserController'
		
		
	});
	
});