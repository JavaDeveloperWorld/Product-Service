'use strict';

projectApp.factory('myFactory',['$http','$q',function ($http,$q) {

    var uri="http://tastysupplies.com";
    var factory={
        insertCustomer: insertCustomer
    };

    return factory;




    function insertCustomer(customer) {
        var defered=$q.defer();
        $http.post(uri+"/registerSuccess",customer)
            .then(function (value) {
                defered.resolve(value.data)
            },function (reason) {
                defered.reject(reason)
            });
        return defered.promise;
    }


}]);