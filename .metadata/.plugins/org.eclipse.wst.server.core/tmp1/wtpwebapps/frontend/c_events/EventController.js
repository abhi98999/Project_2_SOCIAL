'use strict';

app.controller('EventController',[
	'$scope',
	'EventService',
	'$cookieStore',
	'$location',
    '$rootScope',
    '$http',
	function($scope,EventService,$cookieStore,$location,$rootScope,$http){
    	console.log("Event Controller")
    	
    	var self = this;               
    	
    	self.event = {
    			e_eventTitle : '',
    			e_eventDescription : '',
    			e_eventDate : '',
    			e_eventVenue : ''
    	};
    	
    	self.events = [];  
    	
    	self.fetchAllEvents = function(){
    		EventService.fetchAllEvents()
    			.then(function(d){
    						self.events = d;
    				},function(errResponse){
    					console.error('Error While Fatching Events.');
    			});
    	};
    	    	    	
    	self.createEvent = function(event){
    		EventService.createEvent(event)
    			.then(
    					function(d){
    				self.event = d;
    			},
    					function(errResponse){
    					console.error('Error While Creating Event.');
    			});
    	};
    	    	
    	//calling the Method
    	self.fetchAllEvents();
    	
    	self.submit = function(){
    		{
    			console.log('Post a New Event',self.event);
    			self.createEvent(self.event);           			
    		}
    		self.reset();
    	}
    	
    	self.reset = function(){
    		self.event  = {
    				e_eventId : '',
        			e_eventTitle : '',
        			e_eventDescription : '',
        			e_eventDate : '',
        			e_eventVenue : '',
        			e_eventStatus : '',
        			errorCode : '',
        			errorMessage : ''
    		};
    		$scope.form.$setPristine();
    	}
}]);