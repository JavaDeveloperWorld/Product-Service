'use strict';

projectApp.controller('userMController',['$scope','userMessageFactory',function ($scope,userMessageFactory) {

    getMessage();


    $scope.messageLimit=10;
    $scope.messageOffset=0;

    $scope.goNext=function () {
      $scope.messageOffset=$scope.messageOffset+$scope.messageLimit;
      getMessage();
    };

    $scope.goPrevious=function () {
        $scope.messageOffset=$scope.messageOffset-$scope.messageLimit;
        getMessage();
    };
    function getMessage() {
        $scope.doIt=true;
        userMessageFactory.getUserMessage($scope.messageLimit,$scope.messageOffset)
            .then(function (value) {
                $scope.userMessage=value;
                for(var i=0;i<$scope.userMessage.length;i++){
                    if($scope.userMessage[i].read===1){
                        $scope.userMessage[i].read="Oxunub";
                    }else{
                        $scope.userMessage[i].read="Oxunmayıb";
                    }
                }
            },function (reason) {
                console.log(reason);
            })
    }
    $scope.makeActive=function(){
        $scope.message.trim();
        if($scope.message===""){
            $scope.doIt=true;
        }else{
            $scope.doIt=false;
        }
    };
    $scope.writeNewMessage=function (value) {
        userMessageFactory.getUserLastMessage(value)
            .then(function (value) {
                md.showMessageNotification('top','center');
            },function (reason) {
                md.showMessageErrorNotification('top','center');
            });
        window.location.reload();
    };


}]);