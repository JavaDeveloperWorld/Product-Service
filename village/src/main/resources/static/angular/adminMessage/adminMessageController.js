'use strict';

projectApp.controller('messageController',['$scope','messageFactory',function ($scope,messageFactory) {

    getAllMessage();
    getUnreadMessage();

    var temp;

    function getUnreadMessage() {
        messageFactory.getUnreadMessage()
            .then(function (value) {
                $scope.getUnreadList=value;
            },function (reason) {
                console.log(reason);
            })
    }
    $scope.writeMessage=function (id) {
        for(var i=0;i<$scope.getUnreadList.length;i++){
            if(id===$scope.getUnreadList[i].id){
                $scope.realMessage=$scope.getUnreadList[i].message;
                temp=id;
            }
        }
    };
    $scope.writeAnswer=function (message) {
        var writeData=[];
        writeData.push(temp);
        writeData.push(message);
        messageFactory.writeAnswer(writeData);
        alert("Message answered!!");
        window.location.reload();
    };
    function getAllMessage() {
        messageFactory.getAllMessage()
            .then(function (value) {
                $scope.getAllList=value;
            },function (reason) {
                console.log(reason);
            })
    }

}]);