'use strict';

// Register `phoneDetail` component, along with its associated controller and template
angular.
  module('Convertidor').
  component('convertidor', {
    templateUrl: 'convertidor/convertidor.template.html',
    controller: ['$http','Ftocservice',
      function ConvertidorController($http,Ftocservice) {
        
         this.calculate = function(){
        	 self.message = "Procesing Request";
            Ftocservice.exchage(this.rate_from ,this.rate_to , this.amount ).then(function (data) {
              //self.rates  = data;
            self.result = data.result;
            self.current_rate = data.rate;
            self.message = data.message;
          });
        }


         var self = this;



        Ftocservice.rates().then(function (data) {
          self.rates  = data;
        });
       

      }    
    ]      
  });
