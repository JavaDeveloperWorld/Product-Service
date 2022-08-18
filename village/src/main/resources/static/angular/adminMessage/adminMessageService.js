'use strict';

projectApp.factory('messageFactory',['$http','$q',function ($http,$q) {

    var uri="http://tastysupplies.com";

    var factory={
        getAllMessage:getAllMessage,
        getUnreadMessage:getUnreadMessage,
        writeAnswer:writeAnswer
    };
    return factory;

    function getAllMessage() {
        var defered=$q.defer();
        $http.get(uri+"/getAllMessage")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }

    function getUnreadMessage() {
        var defered=$q.defer();
        $http.get(uri+"/getAllUnreadMessage")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }
    function writeAnswer(data) {
        var defered=$q.defer();
        $http.post(uri+"/writeAnswer",data)
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason);
            });
        return defered.promise;
    }


}]);