'use strict';

angular.
  module('core.ftocservice').
  factory('Ftocservice',['$resource', '$q', '$http',
    function($resource,$q, $http) 
    {

      function rates() {
        
        var deferred = $q.defer();
        $http.get('../services/exchange/rates')
          .success(function (data) {
            deferred.resolve(data);
          }).error(function(data, status) {
        	  alert("An happened getting available rates :"+ status);
        	  console.log("data -->"+data,"status -->"+status);
          });  

        return deferred.promise;
      
      }

      function exchage(from, to, amount) {
        var deferred = $q.defer();
        $http.get('../services/exchange/change', {params:{"from": from, "to": to, "amount": amount }})
          .success(function (data) {
            deferred.resolve(data);
            //data.message = "Operation Ok";
            console.log("data -->"+data);
          }).error(function(data, status) {
        	  alert("An error happened doing the exchange :"+ status);
        	  console.log("data -->"+data,"status -->"+status);
          }); 
        return deferred.promise;
      }

      return {
          rates: rates ,
          exchage: exchage
        };
      
      }
  ]);