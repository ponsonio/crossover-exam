'use strict';

// Implementation of the Login controller
angular.
  module('Login').
  component('loginForm', {
    templateUrl: 'login/login.template.html',
    controller: ['$route','$location','LoginService',
    function LoginController($route,$location,LoginService) {
        
        this.irNotas = function(){
        	if (LoginService.login (this.user , this.password) ) {
        		$location.path('/airportlist/');
        	}else{
        		alert('Login Incorrecto');
        	}
           
        }
      }    

    ]      

  });