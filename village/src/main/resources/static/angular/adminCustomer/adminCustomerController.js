'use strict';

projectApp.controller('customerController',['$scope','customerFactory',function ($scope,customerFactory) {

    var identification;

    $scope.balansLimit=5;
    $scope.balansOffset=0;



    activeCustomers();
    activeCustomerCount();
    deactiveCustomerCount();
    getBlockedCount();
    blockedCustomers();

    $scope.goNextBalans=function () {
        $scope.balansOffset=$scope.balansOffset+$scope.balansLimit;
        $scope.getUserBalansData(identification);
    };
    $scope.goBackBalans=function () {
        $scope.balansOffset=$scope.balansOffset-$scope.balansLimit;
        $scope.getUserBalansData(identification);
    };

    function activeCustomers() {
        customerFactory.activeCustomers()
            .then(function (value) {
                $scope.getActiveCustomers=value;
            },function (reason) {
                console.log(reason);
            });
    }
    function blockedCustomers() {
        customerFactory.blockedCustomers()
            .then(function (value) {
                $scope.getBlockedCustomers=value;
            },function (reason) {
                console.log(reason);
            })
    }
    $scope.setBlockCustomers=function (id) {
        customerFactory.setblockCustomers(id);
        alert("Müştəri blok edildi!!!");
        window.location.reload();
    };
    $scope.setUnlockCustomers=function (id) {
        customerFactory.setunlockCustomers(id);
        alert("Müştəri blokdan çıxarıldı!!!");
        window.location.reload();
    };
    $scope.setEditCustomer=function (id) {
       for(var i=0;i<$scope.getActiveCustomers.length;i++){
           if(id===$scope.getActiveCustomers[i].id){
               $scope.editCustomer=$scope.getActiveCustomers[i];
           }
       }
    };
    $scope.getCustomerSell=function (id) {
        customerFactory.lookCustomerSelling(id)
            .then(function (value) {
                $scope.lookCustomerSell=value;
            },function (reason) {
                console.log(reason);
            })
    }
    function activeCustomerCount() {
        customerFactory.activeCustomerCount()
            .then(function (value) {
                $scope.getActiveCount=value;
            },function (reason) {
                console.log(reason);
            })
    }
    function deactiveCustomerCount() {
        customerFactory.deactiveCustomerCount()
            .then(function (value) {
                $scope.getDeactiveCount=value;
            },function (reason) {
                console.log(reason);
            })
    }
    function getBlockedCount() {
        customerFactory.blockedCustomerCount()
            .then(function (value) {
                $scope.getBlockedCount=value;
            },function (reason) {
                console.log(reason);
            })
    }
    $scope.getUserBalansData=function (id) {
        identification=id;
        getUserBonus(id);
        customerFactory.getUserBalansData(id,$scope.balansLimit,$scope.balansOffset)
            .then(function (value) {
                $scope.userAllBalance=value;
            },function (reason) {
                console.log(reason);
            })
    };
    function getUserBonus(id) {
        customerFactory.getUserBonus(id)
            .then(function (value) {
                $scope.userBonus=value[0];
            },function (reason) {
                console.log(reason);
            })
    }

}]);