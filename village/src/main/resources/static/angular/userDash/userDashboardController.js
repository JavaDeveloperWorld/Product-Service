'use strict';

projectApp.controller('userDashController',['$scope','userFactory',function ($scope,userFactory) {

    getAllServices();
    getUserData();
    getUserBalans();
    usedService();
    unUsedService();
    userBonus();
    getMaxSellSubProduct();
    getTopStar();
    getBigStar();
    getMiddleStar();
    getNewStar();

    function getUserData() {
        userFactory.getUserData()
            .then(function (value) {
                $scope.userData=value[0];
            },function (reason) {
                console.log(reason);
            })
    }

    function userBonus() {
        userFactory.userBonus()
            .then(function (value) {
                $scope.allUserBonus=value;
            },function (reason) {
                console.log(reason);
            })
    }

    function usedService() {
        userFactory.usedService()
            .then(function (value) {
                $scope.usedServiceCount=value;
            },function (reason) {
                console.log(reason);
            })
    }
    function unUsedService() {
        userFactory.unUsedService()
            .then(function (value) {
                $scope.unUsedServiceCount=value;
            },function (reason) {
                console.log(reason);
            })
    }
    function getMaxSellSubProduct() {
        userFactory.getMaxSellSubProduct()
            .then(function (value) {
                $scope.maxSellSubPro=value;
            },function (reason) {
                console.log(reason);
            })
    }

    function getUserBalans() {
        userFactory.getUserBalans()
            .then(function (value) {
                $scope.userBalans=value;
            },function (reason) {
                console.log(reason);
            })
    }

    function getAllServices() {
        userFactory.getAllMainServices()
            .then(function (value) {
                $scope.services=value;
            },function (reason) {
                console.log(reason);
            })
    }
    function getTopStar() {
        userFactory.getTopStar()
            .then(function (value) {
                $scope.topStar=value[0];
            },function (reason) {
                console.log(reason);
            })
    }
    function getBigStar() {
        userFactory.getBigStar()
            .then(function (value) {
                $scope.bigStar=value[0];
            },function (reason) {
                console.log(reason);
            })
    }
    function getMiddleStar() {
        userFactory.getMiddleStar()
            .then(function (value) {
                $scope.middleStar=value[0];
            },function (reason) {
                console.log(reason);
            })
    }
    function getNewStar() {
        userFactory.getNewStar()
            .then(function (value) {
                $scope.newStar=value[0];
            },function (reason) {
                console.log(reason);
            })
    }

    $scope.showValue=function (id) {
        userFactory.getServiceById(id)
            .then(function (value) {
                $scope.serviceValue=value;
            },function (reason) {
                console.log(reason);
            });
    }
}]);