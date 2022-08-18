'use strict';

projectApp.factory('myFactory',['$http','$q',function ($http,$q) {

    var uri="http://tastysupplies.com";

    var factory={
        getAllSubProduct:getAllSubProduct,
        insertSubProduct:insertSubProduct,
        getActiveSubProduct:getActiveSubProduct,
        getDeactiveSubProducts:getDeactiveSubProducts,
        noConnectedWithService:noConnectedWithService,
        getSubProductById:getSubProductById,
        deleteSubProduct:deleteSubProduct,
        updateSubProduct:updateSubProduct
    };
    return factory;

    function getAllSubProduct() {
        var defered=$q.defer();
        $http.get(uri+'/getAllSubProduct')
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                console.log(reason);
            })
        return defered.promise;
    }

    function insertSubProduct(service) {
        var defered=$q.defer();
        $http.post(uri+"/insertSubProduct",service)
            .then(function (value) {
                defered.resolve(value);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }

    function getActiveSubProduct() {
        var defered=$q.defer();
        $http.get(uri+"/allActiveSubProducts")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            })
        return defered.promise;
    }
    function getDeactiveSubProducts() {
        var defered=$q.defer();
        $http.get(uri+"/allDeactiveSubProducts")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            })
        return defered.promise;
    }
    function noConnectedWithService() {
        var defered=$q.defer();
        $http.get(uri+"/allNonConnectionWithService")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            })
        return defered.promise;
    }
    function getSubProductById(id) {
        var defered=$q.defer();
        $http.put(uri+"/getSubProductById",id)
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function deleteSubProduct(id) {
        var defered=$q.defer();
        $http.post(uri+"/deleteSubProduct",id)
            .then(function (value) {
                defered.resolve(value);
            },function (reason) {
                defered.reject(reason);
            })
    }
    function updateSubProduct(data) {
        var defered=$q.defer();
        $http.put(uri+"/updateSubProduct",data)
            .then(function (value) {
                defered.resolve(value);
            },function (reason) {
                defered.reject(reason);
            })
    }

}]);