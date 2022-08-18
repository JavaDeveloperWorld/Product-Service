'use strict';

projectApp.factory('storeFactory',['$http','$q',function ($http,$q) {

    var uri="http://tastysupplies.com";

    var factory={
        getAllStoreProduct:getAllStoreProduct,
        getMinStoreProduct:getMinStoreProduct,
        updateStore:updateStore,
        insertStore:insertStore,
        getAllSubProduct:getAllSubProduct,
        deleteStore:deleteStore
    };
    return factory;

    function getAllStoreProduct() {
        var defered=$q.defer();
        $http.get(uri+"/getAllStoreProduct")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function getAllSubProduct() {
        var defered=$q.defer();
        $http.get(uri+"/getActiveSubProduct")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function getMinStoreProduct() {
        var defered=$q.defer();
        $http.get(uri+"/getMinStoreProduct")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function insertStore(value) {
        var defered=$q.defer();
        $http.post(uri+"/insertStore",value)
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function deleteStore(id) {
        var defered=$q.defer();
        $http.post(uri+"/deleteStore",id)
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function updateStore(value) {
        var defered=$q.defer();
        $http.post(uri+"/updateStore",value)
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
}]);