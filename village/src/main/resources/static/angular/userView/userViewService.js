'use strict';

projectApp.factory('userViewFactory',['$http','$q',function ($http,$q) {

    var uri="http://tastysupplies.com";
    var factory={
        getPersonalData:getPersonalData,
        personChange: personChange,
        writeMessageCeo:writeMessageCeo,
        downloadFile:downloadFile
    };
    return factory;

    function personChange(customer) {
        var defered=$q.defer();
        $http.post(uri+"/updateCustomer",customer)
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason)
            });
        return defered.promise;
    }
    function downloadFile(file) {
        var fd = new FormData();
        fd.append('file', file[0]);
        var defered=$q.defer();
        $http.post(uri+"/downloadFile",fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason)
            });
        return defered.promise;
    }
    function getPersonalData() {
        var defered=$q.defer();
        $http.get(uri+"/adminName")
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason)
            });
        return defered.promise;
    }
    function writeMessageCeo(message) {
        var defered=$q.defer();
        $http.post(uri+"/writeCEO",message)
            .then(function (value) {
                defered.resolve(value.data);
            },function (reason) {
                defered.reject(reason)
            });
        return defered.promise;
    }

}]);