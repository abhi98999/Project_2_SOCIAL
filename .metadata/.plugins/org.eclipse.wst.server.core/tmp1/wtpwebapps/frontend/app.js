'use strict';

var app = angular.module('myApp', [ 'ngRoute','ngCookies']);

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
	
	.when('/manageBlog',{
		templateUrl: 'admin/manageBlogs.html',
		controller :'AdminController'		
	})
	 
	//Blog related
	
	.when('/addBlog',{
		templateUrl: 'c_blog/create_blog.html',
		controller :'BlogController'		
	})
	.when('/blog_list',{
		templateUrl: 'c_blog/blog_list.html',
		controller :'BlogController'		
	})
	.when('/MyBlogList',{
		templateUrl: 'c_blog/MyBlogList.html',
		controller :'BlogController'		
	})
	.when('/MyRejectedBlog',{
		templateUrl: 'c_blog/MyRejectedBlog.html',
		controller :'BlogController'		
	})
	.when('/pendingBlog',{
		templateUrl: 'c_blog/pendingBlog.html',
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
	
	//Job Related
	.when('/listOfJobs',{
		templateUrl: 'c_job/ListOfJobs.html',
		controller :'JobController'		
	})
		.when('/listOfMyJobs',{
		templateUrl: 'c_job/MyAppliedJobs.html',
		controller :'JobController'		
	})
		.when('/create_job',{
		templateUrl: 'c_job/PostNewJob.html',
		controller :'JobController'		
	})
		.when('/remove_job',{
		templateUrl: 'c_job/manageJobs.html',
		controller :'JobController'		
	})
	
	//file upload related
	.when('/fileUpload',{
		templateUrl: 'c_fileUpload/fileUpload.html',
	})
	
	//Friend
	.when('/showUsersList', {
		templateUrl : 'c_friend/UserList.html',
		controller : 'FriendController'
	})
	
	.when('/myFriendList', {
		templateUrl : 'c_friend/myfriends.html',
		controller : 'FriendController'
	})
	
	.when('/newFriendRequest', {
		templateUrl : 'c_friend/newFriendsRequest.html',
		controller : 'FriendController'
	})	
	
	//Chat
	
	.when('/chat_forum', {
		templateUrl : 'Chat/chat_forum.html',
		controller : 'ChatController'
	})
	
	.when('/chat', {
		templateUrl : 'Chat/chat.html',
		controller : 'ChatController'
	})
	
});

app.run(function($rootScope, $location, $cookieStore, $http) {
	$rootScope.$on('$locationChangeStart',
			function(event, next, current) {
				console.log("$locationChangeStart")
				var restrictedPage = $.inArray($location.path(),
						[ '/create_Blog']) === 0;

				console.log("RestrictedPage :-" + restrictedPage)
				var loggedIn = $rootScope.currentUser.username;
				console.log("LoggedIn :-" + loggedIn)
				if (restrictedPage && !loggedIn) {
					console.log("Navigating to login Page :")
					$location.path('c_user/login');
				}
			});

	$rootScope.currentUser = $cookieStore.get('currentUser') || {};
	if ($rootScope.currentUser) {
		$http.defaults.headers.common['Authorization'] = 'Basic'
				+ $rootScope.currentUser;
	}
	
	
});