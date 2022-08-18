'use strict';

projectApp.factory('myFactory',['$http','$q',function ($http, $q) {
    var uri="http://tastysupplies.com";
    var factory={
        getActiveProduct:getActiveProduct,
        showSubProduct:showSubProduct,
        getMaxSubProduct:getMaxSubProduct,
        showAllSubProduct:showAllSubProduct,
        getActiveSubProduct:getActiveSubProduct,
        getAllProductSub:getAllProductSub,
        insertSubscribe:insertSubscribe,
        setSingleSubProduct:setSingleSubProduct,
        getPageInfo:getPageInfo
    };
    return factory;


    function getPageInfo() {
        var defered=$q.defer();
        $http.get(uri+"/myMainPageDetails")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function getActiveProduct() {
        var defered=$q.defer();
        $http.get(uri+"/getActiveProduct")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function getAllProductSub(value) {
        var defered=$q.defer();
        $http.put(uri+"/getAllProductSub",value)
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function getActiveSubProduct() {
        var defered=$q.defer();
        $http.get(uri+"/getActiveSubProduct")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function getMaxSubProduct() {
        var defered=$q.defer();
        $http.get(uri+"/getMaxSubProduct")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function showSubProduct(id) {
        var defered=$q.defer();
        $http.post(uri+"/setProductID",id)
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function setSingleSubProduct(name) {
        var defered=$q.defer();
        $http.post(uri+"/setSingleSub",name)
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function insertSubscribe(mail) {
        var defered=$q.defer();
        $http.post(uri+"/insertSubscribe",mail)
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function showAllSubProduct(id) {
        var defered=$q.defer();
        $http.post(uri+"/setProductID",id)
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
}]);



