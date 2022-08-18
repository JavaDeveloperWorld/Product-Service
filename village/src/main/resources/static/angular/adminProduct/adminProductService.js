'use strict';

projectApp.factory('myFactory',['$http','$q',function ($http,$q) {

    var uri="http://tastysupplies.com";
    var factory={
        getAllProduct: getAllProduct,
        getDeactiveProducts:getDeactiveProducts,
        getActiveProducts: getActiveProducts,
        insertProduct:insertProduct,
        getProductById:getProductById,
        updateService:updateService,
        getNonConnectionSubProduct:getNonConnectionSubProduct,
        makeConnectSub:makeConnectSub,
        deleteService:deleteService,
        deleteServiceSubService:deleteServiceSubService,
        getAllSubProduct:getAllSubProduct
    };
    return factory;

    function getAllProduct() {
        var defered=$q.defer();
        $http.get(uri+"/getAllProduct")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            })
        return defered.promise;
    }
    function getAllSubProduct() {
        var defered=$q.defer();
        $http.get(uri+"/getAllSubProductCount")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            })
        return defered.promise;
    }
    function getActiveProducts() {
        var defered=$q.defer();
        $http.get(uri+"/getActiveProductCount")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            })
        return defered.promise;
    }
    function getDeactiveProducts() {
        var defered=$q.defer();
        $http.get(uri+"/getDeactiveProductCount")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            })
        return defered.promise;
    }
    function getProductById(id) {
        var defered=$q.defer();
        $http.put(uri+"/getProductById",id)
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function insertProduct(data) {
        var defered=$q.defer();
        $http.post(uri+"/insertProduct",data)
            .then(function (value) {
                defered.resolve(value);
            },function (reason) {
                defered.reject(reason);
            })
    }
    function updateService(data) {
        var defered=$q.defer();
        $http.post(uri+"/updateProduct",data)
            .then(function (value) {
                defered.resolve(value);
            },function (reason) {
                defered.reject(reason);
            })
    }
    function getNonConnectionSubProduct() {
        var defered=$q.defer();
        $http.get(uri+"/getNonSub")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            })
        return defered.promise;
    }
    function makeConnectSub(list) {
        var defered=$q.defer();
        $http.post(uri+"/connectUpdateSubproduct",list)
            .then(function (value) {
                defered.resolve(value);
            },function (reason) {
                defered.reject(reason);
            })
    }
    function deleteService(id) {
        var defered=$q.defer();
        $http.post(uri+"/deleteService",id)
            .then(function (value) {
                defered.resolve(value);
            },function (reason) {
                defered.reject(reason);
            })
    }
    function deleteServiceSubService(id) {
        var defered=$q.defer();
        $http.post(uri+"/deleteServiceSubService",id)
            .then(function (value) {
                defered.resolve(value);
            },function (reason) {
                defered.reject(reason);
            })
    }
}]);