'use strict';

 projectApp.controller('userViewController',['$scope','userViewFactory',function ($scope,userViewFactory) {

  getPersonalData();

  var temp;

  function getPersonalData() {
     userViewFactory.getPersonalData()
         .then(function (value) {
          $scope.userData=value;
          temp=value[0];
         },function (reason) {
          console.log(reason);
         })
  }


     $scope.personChange=function (value) {
      if(value.name && value.surname && value.age && value.password && value.confirmPassword && value.address && value.phone && value.gender && value.email !=null ){
            userViewFactory.personChange(value)
                .then(function (value1) {
                    alert("Şəxsi məlumatlarınızda uğurla dəyişiklik edildi")
                },function (reason) {
                    console.log(reason)
                });
          window.location.reload();
      }else
      {
          alert("Sahələri boş buraxmayın!!!")
      }

     };

    $scope.uploadFileChange= function(files){
        $scope.files = files;
     };

    $scope.downloadFile=function (){
      userViewFactory.downloadFile($scope.files);
      md.showSuccesNotification('top','center');
    };

     $scope.write=function (message) {
         var value=message;
         userViewFactory.writeMessageCeo(value);
          alert("Mesaj uğurla göndərildi");
         window.location.reload();
     }
 }]);