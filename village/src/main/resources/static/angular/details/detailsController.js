'use strict';

projectApp.controller('detailsController',['$scope','myFactory',function ($scope, myFactory) {

    var inputPrice;
    var data;
 getSubProduct();

 function getSubProduct() {
     myFactory.getAllSubProduct()
         .then(function (value) {
             $scope.subproducts=value;
         },function (reason) {
             console.log(reason);
         })
 }

 $scope.changeInputPrice=function(val){
     inputPrice=val;
 };

  $scope.calculateResult=function () {
      for(var i=0;i<$scope.subproducts.length;i++){
          if($scope.subproducts[i].name===$scope.selectedValue){
            data=$scope.subproducts[i].price;
          }
      }
     data=data*inputPrice;
     $scope.result=data;
 }

}]);