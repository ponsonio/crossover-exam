angular.
  module('siga').
  config(['$locationProvider', '$routeProvider',
    function config($locationProvider, $routeProvider) {
      $locationProvider.hashPrefix('!');
      $routeProvider.
      	when('/login', {
          template: '<login-form></login-form>'
        }).when('/createairport', {
          template: '<createairport></createairport>'
        }).
        when('/convertidor', {
          template: '<convertidor></convertidor>'
        }).
        when('/airportlist', {
            template: '<airportlist></airportlist>'
          }).otherwise('/login');
    }
  ]);