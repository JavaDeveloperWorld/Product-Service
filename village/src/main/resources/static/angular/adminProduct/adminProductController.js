'use strict';

projectApp.controller('adminProductController',['$scope','myFactory',function ($scope,myFactory) {

    startPageLoad();


    function startPageLoad() {
        getAllProduct();
        getActiveProducts();
        getDeactiveProducts();
        getAllSubProduct();
    }


var selectedArray=[];
var service_id;

     function getAllProduct() {
         myFactory.getAllProduct()
             .then(function (value) {
                 $scope.allProducts = value;
             }, function (reason) {
                 console.log(reason);
             });
     }
    function getDeactiveProducts() {
        myFactory.getDeactiveProducts()
            .then(function (value) {
                $scope.allDeactive = value;
            }, function (reason) {
                console.log(reason);
            });
    }
    function getActiveProducts() {
        myFactory.getActiveProducts()
            .then(function (value) {
                $scope.allActive = value;
            }, function (reason) {
                console.log(reason);
            });
    }
    function getAllSubProduct() {
        myFactory.getAllSubProduct()
            .then(function (value) {
                $scope.allSubProduct = value;
            }, function (reason) {
                console.log(reason);
            });
    }
    $scope.insertProduct=function (scope) {
        if(scope.status=="Active"){
            scope.status=1;
        }else
        {
            scope.status=0;
        }
        myFactory.insertProduct(scope)
        window.alert("Information was added");
        window.location.reload();
    };
    $scope.updateService=function (scope) {
        if(scope.status=="Aktiv"){
            scope.status=1;
        }else
        {
            scope.status=0;
        }
        alert(scope.status);
        myFactory.updateService(scope);
        window.alert("Məlumat dəyişdirildi");
        window.location.reload();
    };
    $scope.clearField=function clearField() {
        $scope.service.name="";
        $scope.service.note="";
    };

    $scope.getProduct=function (scope) {
        myFactory.getProductById(scope)
            .then(function (value) {
            if(value[0].status==1){
                value[0].status="Active";
            }else
            {
                value[0].status="Deactive";
            }
                $scope.searchProduct=value;
                service_id = scope;
            },function (reason) {
                console.log(reason)
            });

    };
    $scope.getNonConnectionSubProduct=function (service) {
        myFactory.getNonConnectionSubProduct()
            .then(function (value) {
                try {
                    if (value[0].status == 1) {
                        value[0].status = "Active";
                    } else {
                        value[0].status = "Deactive";
                    }

                    $scope.nonConnectSub = value;
                    service_id = service;
                }catch (e) {

                }
            },function (reason) {
                console.log(reason)
            });

    };
    $scope.getIndex=function getIndex(id,isTrue){
        if(isTrue){
            selectedArray.push(id);
        }else
        {
            var index=selectedArray.indexOf(id);
            selectedArray.splice(index,1);
        }
    };
    $scope.clickClose=function clickClose(){
      selectedArray=[];
      var checkboxs=document.getElementsByTagName("input");
      for(var i=0;i<checkboxs.length;i++){
          if(checkboxs[i].type=="checkbox"){
              checkboxs[i].checked=false;
          }
      }
    };
    $scope.makeConnectSub=function makeConnectSub() {
        alert(service_id);
        selectedArray.push(service_id);
        myFactory.makeConnectSub(selectedArray);
        window.alert("Sub Product was connected");
        window.location.reload();
    };

    $scope.deleteService=function deleteService() {
        myFactory.deleteService(service_id);
        window.alert("Product was deleted successfully");
        window.location.reload();
    };

    $scope.deleteServiceSubService=function deleteServiceSubService() {
        myFactory.deleteServiceSubService(service_id);
        window.alert("Service and all dependent Sub Services was deleted successfully")
        window.location.reload();
    }


}]);