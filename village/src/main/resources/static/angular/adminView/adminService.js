'use strict';

projectApp.factory('myFactory',['$http','$q',function ($http,$q) {

    var uri="http://tastysupplies.com";
    var factory={
        getAllDeactiveCustomer: getAllDeactiveCustomer,
        getAllActiveCustomer:getAllActiveCustomer,
        CustomerCount:CustomerCount,
        newCustomerCount:newCustomerCount,
        changeCustomerStatusRole:changeCustomerStatusRole,
        deleteCustomer:deleteCustomer,
        getCustomerById:getCustomerById,
        getAllDeactiveSubService:getAllDeactiveSubService,
        getAllActiveSubService:getAllActiveSubService,
        getAllDeactiveService:getAllDeactiveService,
        getAllActiveService:getAllActiveService,
        getUsername:getUsername,
        UnreadySellingCount:UnreadySellingCount,
        ReadySellingCount:ReadySellingCount,
        updateNewCustomer:updateNewCustomer,
        getUnreadMessageCount:getUnreadMessageCount

    };
    return factory;

    function getUsername() {
        var defered=$q.defer();
        $http.get(uri+"/adminName")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function getUnreadMessageCount() {
        var defered=$q.defer();
        $http.get(uri+"/getAllUnreadMessageCount")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function getAllDeactiveCustomer() {
        var defered=$q.defer();
        $http.get(uri+"/adminDeactiveCustomer")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            })
        return defered.promise;
    }
    function getAllActiveCustomer() {
        var defered=$q.defer();
        $http.get(uri+"/adminActiveCustomer")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            })
        return defered.promise;
    }
    function getAllDeactiveSubService() {
        var defered=$q.defer();
        $http.get(uri+"/allDeactiveSubProducts")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            })
        return defered.promise;
    }
    function getAllActiveSubService() {
        var defered=$q.defer();
        $http.get(uri+"/allActiveSubProducts")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            })
        return defered.promise;
    }
    function getAllDeactiveService() {
        var defered=$q.defer();
        $http.get(uri+"/getDeactiveProductCount")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            })
        return defered.promise;
    }
    function getAllActiveService() {
        var defered=$q.defer();
        $http.get(uri+"/getActiveProductCount")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            })
        return defered.promise;
    }
    function UnreadySellingCount() {
        var defered=$q.defer();
        $http.get(uri+"/getUnreadySellCount")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function ReadySellingCount() {
        var defered=$q.defer();
        $http.get(uri+"/getReadySellCount")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function CustomerCount() {
        var defered=$q.defer();
        $http.get(uri+"/adminCount")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            })
        return defered.promise;
    }
    function newCustomerCount() {
        var defered=$q.defer();
        $http.get(uri+"/adminNCount")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            })
        return defered.promise;
    }
    function changeCustomerStatusRole(id) {
        var defered=$q.defer();
        $http.put(uri+"/changeCustomerStatusRole",id)
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function deleteCustomer(id) {
        var defered=$q.defer();
        $http.put(uri+"/deleteCustomer",id)
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            })
        return defered.promise;
    }
    function getCustomerById(id) {
        var defered=$q.defer();
        $http.put(uri+"/getListbyId",id)
            .then(function (value) {
                console.log(value.data);
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function updateNewCustomer(customer) {
        var defered=$q.defer();
        $http.post(uri+"/updateCustomerByAdmin",customer)
            .then(function (value) {
                console.log(value.data);
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }

}]);