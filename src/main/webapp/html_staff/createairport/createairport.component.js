'use strict';

// Implementation of the airportlist view (component) controller
angular.
  module('CreateAirport').
  component('createairport', {
    templateUrl: 'createairport/createairport.template.html',
    controller: ['$route','$location','LoginService','AirportService',
    function AirportListController($route,$location,LoginService, AirportService) {
        
        var self = this; //don't erase this!!    	
        

        this.createAirport = function(){

            //Get the token
        	LoginService.getSessionToken().then(function (data) {
                	self.token = data.token;
              });
        	
        	//Create the airport
        	AirportService.createAirport(this.code,this.name,this.city,this.country,this.adress ,this.token).then(function (data) {
        		console.log('airport created');
        		
        	});

        	$location.path('/airportlist/');
           
       }
    	
    	
      }    

    ]      

  });