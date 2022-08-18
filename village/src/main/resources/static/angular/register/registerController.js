'use strict';

projectApp.controller('registerController',['$scope','myFactory',function ($scope,myFactory) {

    var checking;

    $scope.checkPassword=function(value){
        if(value!==$scope.customer.password){
            checking=1;
        }else{
            checking=0;
        }
    };

    $scope.register=function (scope) {
        if (checking !==1) {
            if($scope.customer.name!==undefined && $scope.customer.surname!==undefined && $scope.customer.age!==undefined && $scope.customer.phone!==undefined && $scope.customer.email!==undefined && $scope.customer.gender!==undefined &&
                $scope.customer.password!==undefined && $scope.customer.confirmPassword!==undefined) {
                myFactory.insertCustomer(scope)
                    .then(function (value) {
                        window.alert("Məlumatlarınız bazaya daxil edilmişdir. Admin məlumatlarınızı təsdiqlədikdən sonra sistemə daxil ola bilərsiniz");
                        window.location.href="/";
                    }, function (reason) {
                        window.alert(reason);
                    })
            }
            else
            {
                window.alert("Bütün məlumatları doldurmağınız xahiş olunur!!!")
            }
        }else{
            window.alert("Daxil etdiyiniz parolun uyğunluğunu bir daha yoxlayın")
        }
    }

}]);