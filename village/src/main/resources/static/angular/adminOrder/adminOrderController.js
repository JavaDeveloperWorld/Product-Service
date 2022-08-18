'use strict';

projectApp.controller('orderController',['$scope','orderFactory',function ($scope,orderFactory) {
    var temp,productId;
    var sample;
    var sample2,sample3;
    var list=[];

  allCustomers();
  allServices();
  getAllNewOrders();
  getAllFinishOrders();
  getAllFinishOrdersCount();
  getAllNewOrdersCount();

  function getAllNewOrders() {
      orderFactory.getAllNewOrders()
          .then(function (value) {
              $scope.allNewOrders=value;
          },function (reason) {
              console.log(reason);
          })
  }
    $scope.lookOrder=function (id) {
        orderFactory.allNewOrderById(id)
            .then(function (value) {
                $scope.orderInfo=value;
            },function (reason) {
                console.log(reason);
            })
    };
    $scope.lookFinishOrder=function (id) {
        orderFactory.allFinishOrderById(id)
            .then(function (value) {
                $scope.orderFinish=value;
            },function (reason) {
                console.log(reason);
            })
    };
    $scope.setService=function (name) {
        orderFactory.setService(name)
            .then(function (value) {
                $scope.subService=value;
            },function (reason) {
                console.log(reason)
            })
    };
    $scope.getPrice=function(value){
        if(value!=null){
            for (var i=0;$scope.subService.length;i++){
                if(value===$scope.subService[i].name){
                    productId=$scope.subService[i].id;
                    $scope.price=$scope.subService[i].price;
                    break;
                }
            }
            $scope.inputValue="";
        }
    };

    $scope.setPerson=function (name) {
        sample=name;
        $scope.selectedCustomer=[];
        for (var i=0;i<$scope.getActiveCustomers.length;i++){
            if(name===$scope.getActiveCustomers[i].name){
                $scope.selectedCustomer.push($scope.getActiveCustomers[i].surname);
            }
        }
    };
    $scope.setSurname=function (surname) {
        sample2=surname;
        $scope.selectedMail=[];
        for (var i=0;i<$scope.getActiveCustomers.length;i++){
            if(surname===$scope.getActiveCustomers[i].surname && $scope.getActiveCustomers[i].name===sample){
                $scope.selectedMail.push($scope.getActiveCustomers[i].email);
            }
        }
    };
    $scope.setEmail=function (selectMail) {
        sample3=selectMail;
    };

    function allCustomers() {
        orderFactory.activeCustomers()
            .then(function (value) {
                $scope.getActiveCustomers=value;
            },function (reason) {
                console.log(reason);
            });
    }
    function allServices() {
        orderFactory.allUserService()
            .then(function (value) {
                $scope.services=value;
            },function (reason) {
                console.log(reason);
            })
    }
    $scope.change=function (value) {
        $scope.result=value*$scope.price;
    };
    $scope.buyProduct=function(){
        var sell=[];
        for(var i=0;$scope.getActiveCustomers.length;i++){
            if((sample===$scope.getActiveCustomers[i].name) && (sample2===$scope.getActiveCustomers[i].surname)
            && (sample3===$scope.getActiveCustomers[i].email)){
                sell.push($scope.getActiveCustomers[i].id);
                break;
            }
        }
        sell.push(productId);
        sell.push($scope.inputValue);
        sell.push($scope.price);
        sell.push($scope.result);
        sell.push($scope.result);
        var bonus=$scope.result*0.01;
        sell.push(bonus);
        sell.push($scope.address);
        sell.push($scope.phone);
        var today=new Date();
        var dateT=today.getDate();
        var month=today.getMonth()+1;
        var year=today.getFullYear();
        var date=dateT+'/'+month+'/'+year;

        sell.push(date);
        sell.push(2);
        alert("Sifarişiniz qeydə alındı");
       orderFactory.buyProduct(sell);
       window.location.reload();
    };
    $scope.deleteOrder=function () {
        orderFactory.deleteOrder($scope.orderInfo);
        alert("Sifariş uğurla silinmişdir");
        window.location.reload();
    };
    $scope.deleteFinishOrder=function () {
        orderFactory.deleteFinishOrder($scope.orderFinish);
        alert("Sifariş uğurla silinmişdir");
        window.location.reload();
    };
    function getAllFinishOrders() {
        orderFactory.getAllFinishOrders()
            .then(function (value) {
                $scope.allFinishOrders=value;
            },function (reason) {
                console.log(reason);
            })
    }
    function getAllNewOrdersCount() {
        orderFactory.getAllNewOrdersCount()
            .then(function (value) {
                $scope.allNewOrdersCount=value;
            },function (reason) {
                console.log(reason);
            })
    }
    function getAllFinishOrdersCount() {
        orderFactory.getAllFinishOrdersCount()
            .then(function (value) {
                $scope.allFinishOrdersCount=value;
            },function (reason) {
                console.log(reason);
            })
    }

    $scope.payLoan=function (value) {
        list.push(value);
        temp=$scope.orderInfo[0].unpaid-temp;
        list.push(temp);
        orderFactory.payLoan(list);
        alert("Ödəniş uğurla həyata keçirildi!!!");
        window.location.reload();
    };
    $scope.$watch('payValue',function (newVal) {
        temp=newVal;
    });
    $scope.confirmOrder=function () {
       orderFactory.confirmOrder($scope.orderInfo[0].id);
       alert("Sifariş uğurla təsdiq edildi");
       window.location.reload();
    }

}]);