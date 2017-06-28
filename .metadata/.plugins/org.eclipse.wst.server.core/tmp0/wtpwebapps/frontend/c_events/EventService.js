'use strict';

app.factory('EventService',[
           '$http',
           '$q',
           '$rootScope',
           function($http,$q,$rootScope){
        	   console.log("Event Service...");
        	   
        	   var BASE_URL = 'http://localhost:8084/backend'
        	   return{
        		   
        		   fetchAllEvents: function(){
        			   return $http.get(BASE_URL+'/EventList')
        			   		.then(
        			   				function(response){
        			   					return response.data;
        			   				},
        			   				function(errResponse){
        			   					console.error('Error While Fatching EventList.');
        			   					return $q.reject(errResponse);
        			   				}
        			   		);
        			   
        		   },

        		   createEvent: function(event){
        			   return $http.post(BASE_URL+'/CreateEvent',event)
        			   		.then(
        			   				function(response){
        			   					return response.data;
        			   				},
        			   				function(errResponse){
        			   					console.error('Error While Post a new Event.');
        			   					return $q.reject(errResponse);
        			   				}
        			   		);
        		   },

        	   }
}]);