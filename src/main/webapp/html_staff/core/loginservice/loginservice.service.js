'use strict';

angular.
  module('core.loginservice').
  factory('LoginService',['$resource', '$q', '$http',
    function($resource,$q, $http) 
    {

      function login(user, password) {
        
        var deferred = $q.defer();
        $http.get('../services/security/login/'
        		, {params:{"user": user, "password" : password }} )
          .success(function (data) {
            deferred.resolve(data);
          }).error(function(data, status) {
        	  alert("An error happpen login user :"+ status);
        	  console.log("data -->"+data,"status -->"+status);
          });  

        return deferred.promise;
      
      }

      //TODO : Change this to obtain it from browser ,memory
      function getSessionToken() {
          var staff = 'staff';
          var deferred = $q.defer();
          $http.get('../services/security/login/'
        		  , {params:{"user": staff, "password" : staff }} )
            .success(function (data) {
            	data.token = 'QWERTY'; 
            	console.log('getSessionToken()'+data.token);
              deferred.resolve(data);
            }).error(function(data, status) {
          	  alert("An error happpen login user :"+ status);
          	  console.log("data -->"+data,"status -->"+status);
            });  
          return deferred.promise;
        
        }
      
      return {
          login: login ,
          getSessionToken, getSessionToken
        };
      
      }
  ]);