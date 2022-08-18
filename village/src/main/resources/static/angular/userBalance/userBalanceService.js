'use strict';

projectApp.factory('userBalanceFactory',['$http','$q',function ($http,$q) {
    var uri="http://tastysupplies.com";
    var factory={
        getSell:getSell,
        getUserBalans:getUserBalans,
        getUserBonus:getUserBonus,
        getUserBalansData:getUserBalansData,
        getUserSellingData:getUserSellingData
    };
    return factory;

    function getSell(limit,offset) {
        var defered=$q.defer();
        $http.get(uri+"/getAllSell",{
            params:{limit:limit,offset:offset}
        })
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
    function getUserSellingData() {
        var defered=$q.defer();
        $http.get(uri+"/userSellingData")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function getUserBonus() {
        var defered=$q.defer();
        $http.get(uri+"/getUserBonus")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function getUserBalansData(limit,offset) {
        var defered=$q.defer();
        $http.get(uri+"/userBalans",{
            params:{limit:limit,offset:offset}
        })
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }

}]);