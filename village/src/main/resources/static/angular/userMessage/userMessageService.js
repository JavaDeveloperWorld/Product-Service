'use strict';

projectApp.factory('userMessageFactory',['$http','$q',function ($http,$q) {

    var uri="http://tastysupplies.com";
    var factory={
        getUserMessage:getUserMessage,
        getUserLastMessage:getUserLastMessage
    };
    return factory;



    function getUserMessage(limit,offset) {
        var defered=$q.defer();
        $http.get(uri+"/getMessage",{
            params:{limit: limit, offset:offset}
        })
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function getUserLastMessage(value) {
        var defered=$q.defer();
        $http.put(uri+"/writeCEO",value)
            .then(function (value) {
                console.log(value);
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }



}]);