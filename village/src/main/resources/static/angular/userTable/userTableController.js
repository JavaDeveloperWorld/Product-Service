'use strict';

projectApp.controller('userTableController',['$scope','userTableFactory',function ($scope,userTableFactory) {


    allServices();
    getActiveProject();
    getUserData();

    $scope.getID=function(id) {
      for(var i=0;i<$scope.activeProject.length;i++){
          if($scope.activeProject[i].id===id){
              if($scope.activeProject[i].unpaid===0){
                  $scope.statusValue=100;
                  $scope.second={"background-color": "green"};
              }
              else if($scope.activeProject[i].unpaid===($scope.activeProject[i].price*$scope.activeProject[i].count)){
                  $scope.statusValue=0;
                  $scope.second={"background-color": "red"};
              }else {
                  $scope.statusValue=50;
                  $scope.second={"background-color": "yellow"};
              }
              if($scope.activeProject[i].status==="İcra edildi"){
                  $scope.adminCheck=100;
                  $scope.second={"background-color": "green"};
                  $scope.third={"background-color": "green"};
              }else {
                  $scope.adminCheck=0;
                  $scope.third={"background-color": "red"};
              }
          }
      }
    };
    function getUserData() {
        userTableFactory.getUserData()
            .then(function (value) {
                $scope.userData=value[0];
            },function (reason) {
                console.log(reason);
            })
    }
    $scope.setService=function (name) {
        userTableFactory.setService(name)
            .then(function (value) {
                $scope.subService=value;
            },function (reason) {
                console.log(reason)
            })
    };
    $scope.getPrice=function(value){
        if(value!=null){
            for (var i=0;$scope.subService.length;i++){
                if(value===$scope.subService[i].name){
                    $scope.price=$scope.subService[i].price;
                    break;
                }
            }
            $scope.inputValue="";
        }
    };

    $scope.change=function (value) {
      $scope.result=value*$scope.price;
    };
    $scope.projectLimit = 5;
    $scope.projectOffset = 0;

    $scope.onNextProjects= function () {
        $scope.projectOffset =  $scope.projectOffset +  $scope.projectLimit;
        getActiveProject();
    };
    $scope.onPreviousProjects=function () {
        $scope.projectOffset =  $scope.projectOffset -  $scope.projectLimit;
        getActiveProject();
    };
    function getActiveProject() {
        userTableFactory.getActiveProject( $scope.projectLimit, $scope.projectOffset)
            .then(function (value) {
                $scope.activeProject=value;
                for(var i=0;i<$scope.activeProject.length;i++){
                    if($scope.activeProject[i].status===1){
                        $scope.activeProject[i].status="İcra edildi";
                    }else{
                        $scope.activeProject[i].status="İcradadır"
                    }
                }
            },function (reason) {
                console.log(reason);
            })
    }

    $scope.confirm=function(){
        var sell=[];
            sell.push($scope.userData.id);

            for(var i=0;$scope.subService.length;i++){
                if($scope.selectedSub===($scope.subService[i].name)){
                    sell.push($scope.subService[i].id);
                    break;
                }
            }
            sell.push($scope.inputValue);
            sell.push($scope.price);
            sell.push($scope.result);
            sell.push($scope.result);
            var bonus=$scope.result*0.01;
            sell.push(bonus);
            sell.push($scope.address);
            sell.push($scope.phone);
            var today=new Date();
            var dateT=today.getDate();
            var month=today.getMonth()+1;
            var year=today.getFullYear();
            var date=year+'-'+month+'/'+dateT;

            sell.push(date);
            sell.push(2);
            alert("Sifarişiniz qeydə alındı");
        userTableFactory.confirmOrder(sell);
        window.location.reload();
    };

    function allServices() {
        userTableFactory.allUserService()
            .then(function (value) {
                $scope.services=value;
            },function (reason) {
                console.log(reason);
            })
    }
}]);