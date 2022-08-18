'use strict';

projectApp.factory('customerFactory',['$http','$q',function ($http,$q) {

    var uri="http://tastysupplies.com";

    var factory={
        activeCustomerCount:activeCustomerCount,
        deactiveCustomerCount:deactiveCustomerCount,
        activeCustomers:activeCustomers,
        blockedCustomers:blockedCustomers,
        lookCustomerSelling:lookCustomerSelling,
        blockedCustomerCount:blockedCustomerCount,
        setblockCustomers:setblockCustomers,
        setunlockCustomers:setunlockCustomers,
        getUserBalansData:getUserBalansData,
        getUserBonus:getUserBonus
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
    function blockedCustomers() {
        var defered=$q.defer();
        $http.get(uri+"/adminBlockedCustomer")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function setblockCustomers(id) {
        var defered=$q.defer();
        $http.post(uri+"/setBlockCustomer",id)
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function setunlockCustomers(id) {
        var defered=$q.defer();
        $http.post(uri+"/setUnlockCustomer",id)
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function activeCustomerCount() {
        var defered=$q.defer();
        $http.get(uri+"/adminCount")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function lookCustomerSelling(id) {
        var defered=$q.defer();
        $http.put(uri+"/lookCustomerSelling",id)
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }

    function deactiveCustomerCount() {
        var defered=$q.defer();
        $http.get(uri+"/adminNCount")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function blockedCustomerCount() {
        var defered=$q.defer();
        $http.get(uri+"/adminBlCount")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function getUserBalansData(id,limit,offset) {
        var defered=$q.defer();
        $http.get(uri+"/adminUserBalance",{
            params:{id:id,limit:limit,offset:offset}
        })
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function getUserBonus(id) {
        var defered=$q.defer();
        $http.put(uri+"/getAdminUserBonus",id)
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }

}]);