'use strict';

projectApp.factory('userFactory',['$http','$q',function ($http,$q) {
    var uri="http://tastysupplies.com";
    var factory={
        getAllMainServices: getAllMainServices,
        getServiceById:getServiceById,
        getUserData:getUserData,
        getUserBalans:getUserBalans,
        usedService:usedService,
        unUsedService:unUsedService,
        userBonus:userBonus,
        getMaxSellSubProduct:getMaxSellSubProduct,
        getTopStar:getTopStar,
        getBigStar:getBigStar,
        getMiddleStar:getMiddleStar,
        getNewStar:getNewStar
    };
    return factory;

    function userBonus() {
        var defered=$q.defer();
        $http.get(uri+"/userBonus")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }

    function getUserBalans() {
        var defered=$q.defer();
        $http.get(uri+"/customerBalans")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function usedService() {
        var defered=$q.defer();
        $http.get(uri+"/usedSubProductCount")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function unUsedService() {
        var defered=$q.defer();
        $http.get(uri+"/unUsedSubProductCount")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }

    function getUserData() {
        var defered=$q.defer();
        $http.get(uri+"/adminName")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }

    function getAllMainServices() {
        var defered=$q.defer();
        $http.get(uri+"/getActiveSubProduct")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }

    function getServiceById(id) {
        var defered=$q.defer();
        $http.put(uri+"/getSubProductById",id)
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function getMaxSellSubProduct() {
        var defered=$q.defer();
        $http.get(uri+"/getMaxSubProduct")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }

    function getTopStar() {
        var defered=$q.defer();
        $http.get(uri+"/getTopStar")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function getBigStar() {
        var defered=$q.defer();
        $http.get(uri+"/getBigStar")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function getMiddleStar() {
        var defered=$q.defer();
        $http.get(uri+"/getMiddleStar")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function getNewStar() {
        var defered=$q.defer();
        $http.get(uri+"/getNewStar")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }

}]);