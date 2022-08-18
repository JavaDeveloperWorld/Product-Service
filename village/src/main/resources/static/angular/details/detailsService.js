'use strict';

projectApp.factory('myFactory',['$http','$q',function ($http, $q) {
    var uri="http://tastysupplies.com";
    var factory={
        getAllSubProduct:getAllSubProduct
    };
    return factory;

    function getAllSubProduct() {
        var defered=$q.defer();
        $http.get(uri+"/getSubProductByID")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }

}]);