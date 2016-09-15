'use strict';

angular.
  module('core.airportservice').
  factory('AirportService',['$resource', '$q', '$http',
    function($resource,$q, $http) 
    {
	 
	  
      function airports(token) {
        console.log("airport service token :"+token);
        token = "QWERTY"; //CHANGE THIS!!!
        var deferred = $q.defer();
        $http.get('../services/airport/?token='+token)
          .success(function (data) {
            deferred.resolve(data);
          }).error(function(data, status) {
        	  alert("An error happens getting airports :"+ status);
        	  console.log("data -->"+data,"status -->"+status);
          });  

        return deferred.promise;
      
      }

      function airport(id, token) {
          token = "QWERTY"; //CHANGE THIS!!!
          var deferred = $q.defer();
          $http.get('../services/airport/'+ id +"/" , {params:{"token": token}})
            .success(function (data) {
              deferred.resolve(data);
            }).error(function(data, status) {
          	  alert("An error happens getting airport information :"+ status);
          	  console.log("data -->"+data,"status -->"+status);
            });  

          return deferred.promise;
        
        }

      function deleteAirport(id, token) {
          token = "QWERTY"; //CHANGE THIS!!!
          var deferred = $q.defer();
          $http.delete('../services/airport/'+ id +'/' , {params:{"token": token}})
            .success(function (data) {
              deferred.resolve(data);
            }).error(function(status) {
          	  alert("An error happened deleting airport  :"+ status);
          	  console.log("data -->"+data,"status -->"+status);
            });  

          return deferred.promise;
        
        }
      
      
      function createAirport(code,name,city,country, adress , token) {
          token = "QWERTY"; //CHANGE THIS!!!
          
          var data = "token="+token+"&code="+code+"&city="+city+"&country="+country+"&adress="+adress+"&name="+name;
          
          var deferred = $q.defer();
          $http.put('../services/airport/?' + data)
            .success(function (data) {
              deferred.resolve(data);
            }).error(function(data, status) {
          	  alert("An error happened creating airport  :"+ status);
          	  console.log("data -->"+data,"status -->"+status);
            }); 

          return deferred.promise;
        
        }
      
      
      return {
    	  airports: airports ,
    	  airport: airport ,
    	  deleteAirport,deleteAirport,
    	  createAirport,createAirport
        };
      
      }
  ]);