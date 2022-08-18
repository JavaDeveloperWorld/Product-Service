'use strict';

projectApp.controller('myController', ['$scope', 'myFactory', function ($scope, myFactory) {

    getAllActiveCustomer();
    getAllDeactiveCustomer();
    getRegCustomers();
    getNewCustomers();
    getAllDeactiveSubService();
    getAllActiveSubService();
    getAllDeactiveService();
    getAllActiveService();
    getUsername();
    UnreadySellingCount();
    ReadySellingCount();
    getUnreadMessageCount();

    var deactiveID;

    $scope.getDeactiveCustomID = function (id) {
        deactiveID = id;
    };

    function getAllActiveCustomer() {
        myFactory.getAllActiveCustomer()
            .then(function (value) {
                $scope.allActiveCustomer = value;
            }, function (reason) {
                console.log(reason);
            });
    }

    function getUsername() {
        myFactory.getUsername()
            .then(function (value) {
                $scope.getUser = value[0];
                checkUserGender();
            }, function (reason) {
                console.log(reason);
            });
    }

    function checkUserGender() {
        if ($scope.getUser.gender === "Qadın") {
            $scope.photo = "../img/admin/emptyPersonLady.png"
        } else {
            $scope.photo = "../img/admin/emptyPerson.png"
        }
    }

    function getAllDeactiveCustomer() {
        myFactory.getAllDeactiveCustomer()
            .then(function (value) {
                $scope.allDeactiveCustomer = value;
            }, function (reason) {
                console.log(reason);
            });
    }

    function getRegCustomers() {
        myFactory.CustomerCount()
            .then(function (value) {
                $scope.countCustomer = value;
            }, function (reason) {
                console.log(reason)
            });
    }

    function getUnreadMessageCount() {
        myFactory.getUnreadMessageCount()
            .then(function (value) {
                $scope.getUnreadListCount=value;
            },function (reason) {
                console.log(reason);
            })
    }

    function getNewCustomers() {
        myFactory.newCustomerCount()
            .then(function (value) {
                $scope.countNCustomer = value;
            }, function (reason) {
                console.log(reason)
            });
    }

    function getAllDeactiveSubService() {
        myFactory.getAllDeactiveSubService()
            .then(function (value) {
                $scope.allDeactiveSubService = value;
            }, function (reason) {
                console.log(reason)
            })
    }

    function getAllActiveSubService() {
        myFactory.getAllActiveSubService()
            .then(function (value) {
                $scope.allActiveSubService = value;
            }, function (reason) {
                console.log(reason)
            })
    }

    function getAllDeactiveService() {
        myFactory.getAllDeactiveService()
            .then(function (value) {
                $scope.allDeactiveProduct = value;
            }, function (reason) {
                console.log(reason)
            })
    }

    function getAllActiveService() {
        myFactory.getAllActiveService()
            .then(function (value) {
                $scope.allActiveProduct = value;
            }, function (reason) {
                console.log(reason)
            })
    }

    function UnreadySellingCount() {
        myFactory.UnreadySellingCount()
            .then(function (value) {
                $scope.unreadySellCount = value;
            }, function (reason) {
                console.log(reason)
            })
    }

    function ReadySellingCount() {
        myFactory.ReadySellingCount()
            .then(function (value) {
                $scope.readySellCount = value;
            }, function (reason) {
                console.log(reason)
            })
    }

    $scope.acceptResult = function changeCustomerStatus(role) {
        var list = [];
        list.push(deactiveID);
        list.push(role);

        myFactory.changeCustomerStatusRole(list)
            .then(function (value) {
                getAllActiveCustomer();
                getAllDeactiveCustomer();
                window.alert("ID=" + deactiveID + " customer's information was accepted")
            }, function (reason) {
                console.log(reason)
            })

    };
    $scope.deleteCustomer = function (scope) {
        myFactory.deleteCustomer(scope)
            .then(function (value) {
                getAllActiveCustomer();
                getAllDeactiveCustomer();
                window.alert("ID=" + scope + " customer's information was deleted")
            }, function (reason) {
                console.log(reason)
            })


    }
    $scope.getCustomer = function getCustomer(scope) {
        myFactory.getCustomerById(scope)
            .then(function (value) {
                $scope.listCustomer = value;
            }, function (reason) {
                console.log(reason)
            })
    }

    $scope.updateNewCustomer=function (value) {
        myFactory.updateNewCustomer(value);
        alert("Müştərinin məlumatları dəyişdirildi!!!");
        window.location.reload();
    }
}]);