'use strict';

projectApp.factory('userTableFactory',['$http','$q',function ($http,$q) {

    var uri="http://tastysupplies.com";
 var factory={
     allUserService:allUserService,
     setService:setService,
     getActiveProject:getActiveProject,
     getUserData:getUserData,
     confirmOrder:confirmOrder
 };
 return factory;

    function getUserData() {
        var defered=$q.defer();
        $http.get(uri+"/adminName")
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
     function getActiveProject(limit,offset) {
         var defered=$q.defer();
         $http.get(uri+"/getAllSell", {
             params:{limit:limit,offset:offset}
         })
             .then(function (value) {
                 defered.resolve(value.data);
             },function (reason) {
                 defered.reject(reason);
             });
         return defered.promise;
     }
    function confirmOrder(sell) {
        var defered=$q.defer();
        $http.put(uri+"/insertOrder",sell)
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
}]);