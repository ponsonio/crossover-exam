'use strict';

// Implementation of the airportlist view (component) controller
angular.
  module('AirportList').
  component('airportlist', {
    templateUrl: 'airportlist/airportlist.template.html',
    controller: ['$route','$location','LoginService','AirportService',
    function AirportListController($route,$location,LoginService, AirportService) {
        
        var self = this; //don't erase this!!
    	var token ;
        //Get the token
    	LoginService.getSessionToken().then(function (data) {
              //self.rates  = data;
            	self.token = data.token;
            	token = data.token;
            	console.log('data.token'+data.token);
            	console.log('self.token'+self.token);
          });
    	
    	//Get the aiport list
    	
    	AirportService.airports(token).then(function (data) {
            //self.rates  = data;
    		self.airports = data;
    	});
        

        this.deleteAirport = function(id){

        	//id = 1;
            //Get the token
        	LoginService.getSessionToken().then(function (data) {
                  //self.rates  = data;
                	self.token = data.token;
              });
        	
        	//Delete the airport
        	AirportService.deleteAirport(id, self.token).then(function (data) {
                //self.rates  = data;
        		//self.airports = data;
        		//alert('Airport Deleted');
        	});

        	//Get the aiport list
        	AirportService.airports(self.token).then(function (data) {
                //self.rates  = data;
        		//self.airports = data;
        	});
        	$location.path('/airportlist/');
       }
    	
    	
      }    

    ]      

  });