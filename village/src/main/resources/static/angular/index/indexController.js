'use strict';

projectApp.controller('indexController',['$scope','myFactory',function ($scope, myFactory) {
    getPagInformation();
    getAllList();
    getAllSubProductList();
    getAllSubList();




    function getPagInformation() {
        myFactory.getPageInfo()
            .then(function (value) {
                $scope.pageInfo=value[0];
            },function (reason) {
                console.log(reason);
            })
    }
    function getAllList() {
        myFactory.getActiveProduct()
            .then(function (value) {
                $scope.products=value;
            },function (reason) {
                console.log(reason);
            })
    }
    function getAllSubList() {
        myFactory.getActiveSubProduct()
            .then(function (value) {
                $scope.subProducts=value;
            },function (reason) {
                console.log(reason);
            })
    }
    $scope.getSubSelected=function(value){
       if(value!=="Ana məhsullar" && value!==null) {
           myFactory.getAllProductSub(value)
               .then(function (value) {
                   $scope.allSubSearch = value;
               }, function (reason) {
                   console.log(reason);
               })
       }
    };
    $scope.getSubProduct=function (id) {
        myFactory.showSubProduct(id);
        window.location.href="/details";
    };
    $scope.setSingleSubProduct=function (name) {
        myFactory.setSingleSubProduct(name);
        window.location.href="/details";
    };
    $scope.subscribe=function (mail) {
        myFactory.insertSubscribe(mail);
        $scope.newMail="";
    };
    $scope.getAllSubProduct=function () {
        myFactory.showAllSubProduct(-1);
        window.location.href="/details";
    };
    function getAllSubProductList() {
        myFactory.getMaxSubProduct()
            .then(function (value) {
                $scope.subproducts=value;
            },function (reason) {
                console.log(reason);
            })
    }

}]);