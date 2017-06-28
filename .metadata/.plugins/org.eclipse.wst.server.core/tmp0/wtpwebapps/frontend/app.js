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
	})
	
	.when('/profile',{
		
		templateUrl : 'c_user/profile.html',
		controller  : 'UserController'
	})
	
	//ADMIN RELATED
	

	.when('/manageUsers',{
		templateUrl: 'admin/manageUsers.html',
		controller :'AdminController'		
	})
	
	.when('/manageBlogs',{
		templateUrl: 'admin/manageBlogs.html',
		controller :'AdminController'		
	})
	 
	//Blog related
	.when('/addBlog',{
		templateUrl: 'c_blog/create_blog.html',
		controller :'BlogController'		
	})

	//Events Related
	.when('/createEvent',{
		templateUrl: 'c_events/createEvent.html',
		controller :'EventController'		
	})
	.when('/listOfEvents',{
		templateUrl: 'c_events/listOfEvents.html',
		controller :'EventController'		
	})
	
});