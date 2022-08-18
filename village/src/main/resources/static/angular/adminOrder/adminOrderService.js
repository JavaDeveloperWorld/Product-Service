'use strict';

projectApp.factory('orderFactory',['$http','$q',function ($http,$q) {

    var uri="http://tastysupplies.com";

    var factory={
        getAllNewOrders:getAllNewOrders,
        getAllFinishOrders:getAllFinishOrders,
        getAllNewOrdersCount:getAllNewOrdersCount,
        getAllFinishOrdersCount:getAllFinishOrdersCount,
        allNewOrderById:allNewOrderById,
        allFinishOrderById:allFinishOrderById,
        deleteOrder:deleteOrder,
        deleteFinishOrder:deleteFinishOrder,
        payLoan:payLoan,
        confirmOrder:confirmOrder,
        setService:setService,
        buyProduct:buyProduct,
        allUserService:allUserService,
        activeCustomers:activeCustomers
    };
    return factory;


    function activeCustomers() {
        var defered=$q.defer();
        $http.get(uri+"/adminActiveCustomer")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function getAllNewOrders() {
        var defered=$q.defer();
        $http.get(uri+"/allNewOrders")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function allNewOrderById(id) {
        var defered=$q.defer();
        $http.put(uri+"/allNewOrderById",id)
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function allFinishOrderById(id) {
        var defered=$q.defer();
        $http.put(uri+"/allFinishOrderById",id)
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function deleteOrder(sell) {
        var defered=$q.defer();
        $http.post(uri+"/deleteOrder",sell)
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function deleteFinishOrder(sell) {
        var defered=$q.defer();
        $http.post(uri+"/deleteFinishOrder",sell)
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function payLoan(list) {
        var defered=$q.defer();
        $http.post(uri+"/payLoan",list)
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function confirmOrder(id) {
        var defered=$q.defer();
        $http.post(uri+"/confirmOrder",id)
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function getAllFinishOrders() {
        var defered=$q.defer();
        $http.get(uri+"/allFinishOrders")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function getAllNewOrdersCount() {
        var defered=$q.defer();
        $http.get(uri+"/allNewOrdersCount")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function getAllFinishOrdersCount() {
        var defered=$q.defer();
        $http.get(uri+"/allFinishOrdersCount")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function setService(name) {
        var defered=$q.defer();
        $http.put(uri+"/getActiveSubProductFromDepo",name)
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function buyProduct(sell) {
        var defered=$q.defer();
        $http.put(uri+"/insertOrder",sell)
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function allUserService() {
        var defered=$q.defer();
        $http.get(uri+"/getActiveProduct")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
}]);