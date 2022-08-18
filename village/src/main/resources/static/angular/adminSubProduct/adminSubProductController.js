'use strict';

projectApp.controller('subProductController',['$scope','myFactory',function ($scope,myFactory) {

    getAllSubProduct();
    getDeactiveSubProducts();
    getActiveSubProduct();
    noConnectedWithService();

var subService;

    function getAllSubProduct() {
        myFactory.getAllSubProduct()
            .then(function (value) {
                $scope.service=value;
            },function (reason) {

            })
    }
    $scope.insertSubProduct=function (service) {
        if(service.status==="Aktiv"){
            service.status=2;
        }else
        {
            service.status=0;
        }
        myFactory.insertSubProduct(service);

                window.alert("Məhsul əlavə edildi!!!");
                window.location.reload();

    }
    function getDeactiveSubProducts() {
        myFactory.getDeactiveSubProducts()
            .then(function (value) {
                $scope.allDeactive = value;
            }, function (reason) {
                console.log(reason);
            });
    }
    function getActiveSubProduct() {
        myFactory.getActiveSubProduct()
            .then(function (value) {
                $scope.allActive = value;
            }, function (reason) {
                console.log(reason);
            });
    }
    function noConnectedWithService() {
        myFactory.noConnectedWithService()
            .then(function (value) {
                $scope.allNonConnect = value;
            }, function (reason) {
                console.log(reason);
            });
    }
    $scope.clearField=function clearField() {
      $scope.newService.name="";
      $scope.newService.price="";
      $scope.newService.type="";
      $scope.newService.description="";
    };
    $scope.checkSubService=function (id) {
        myFactory.getSubProductById(id)
            .then(function (value) {
                if(value[0].status===1){
                    value[0].status="Aktiv";
                }else
                {
                    value[0].status="Deaktiv";
                }
                $scope.subServices = value;
                subService = id;
            }, function (reason) {
                console.log(reason);
            });
    };
    $scope.deleteSubProduct=function () {
        myFactory.deleteSubProduct(subService);
        window.alert("Məhsul uğurla silindi");
        window.location.reload();
    };
    $scope.updateSubProduct=function (scope) {
        if(scope.status==="Aktiv"){
            scope.status=2;
        }else
        {
            scope.status=0;
        }
        myFactory.updateSubProduct(scope);
        window.alert("Məlumatlar dəyişdirildi");
        window.location.reload();
    };

}]);