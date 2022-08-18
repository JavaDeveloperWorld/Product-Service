'use strict';

projectApp.controller('userBalanceController',['$scope','userBalanceFactory',function ($scope,userBalanceFactory) {

    $scope.projectLimit=5;
    $scope.projectOffset=0;

    $scope.balansLimit=5;
    $scope.balansOffset=0;

    getAllSell();
    getUserBalans();
    getUserBonus();
    getUserBalansData();
    userTableSelling();




    $scope.goNext=function () {
        $scope.projectOffset=$scope.projectOffset+$scope.projectLimit;
        getAllSell();
    };
    $scope.goBack=function () {
        $scope.projectOffset=$scope.projectOffset-$scope.projectLimit;
        getAllSell();
    };
    $scope.goNextBalans=function () {
        $scope.balansOffset=$scope.balansOffset+$scope.balansLimit;
        getUserBalansData();
    };
    $scope.goBackBalans=function () {
        $scope.balansOffset=$scope.balansOffset-$scope.balansLimit;
        getUserBalansData();
    };
    function getAllSell() {
        userBalanceFactory.getSell($scope.projectLimit,$scope.projectOffset)
            .then(function (value) {
                $scope.allSell=value;
                allCount();
            },function (reason) {
                console.log(reason);
            })
    }
    function userTableSelling() {
        userBalanceFactory.getUserSellingData()
            .then(function (value) {
                $scope.sellData=value[0];
                allCount();
            },function (reason) {
                console.log(reason);
            })
    }
    function allCount() {
        $scope.qiymeti=0;
        $scope.odenilmis=0;
        $scope.qaliq=0;
        for (var i=0;i<$scope.allSell.length;i++){
            $scope.qiymeti=$scope.qiymeti+$scope.allSell[i].sum_price;
            $scope.odenilmis=$scope.odenilmis+($scope.allSell[i].sum_price-$scope.allSell[i].unpaid);
            $scope.qaliq=$scope.qaliq+$scope.allSell[i].unpaid;
        }
    }


    function balansChart(value) {
        var gaugedOptions = {
            chart: {
                type: 'solidgauge'
            },

            title: null,

            pane: {
                center: ['50%', '85%'],
                size: '140%',
                startAngle: -90,
                endAngle: 90,
                background: {
                    backgroundColor:
                        Highcharts.defaultOptions.legend.backgroundColor || '#EEE',
                    innerRadius: '60%',
                    outerRadius: '100%',
                    shape: 'arc'
                }
            },

            exporting: {
                enabled: false
            },

            tooltip: {
                enabled: false
            },

            // the value axis
            yAxis: {
                stops: [
                    [0.1, '#55BF3B'], // green
                    [0.5, '#DDDF0D'], // yellow
                    [0.9, '#DF5353'] // red
                ],
                lineWidth: 0,
                tickWidth: 0,
                minorTickInterval: null,
                tickAmount: 2,
                title: {
                    y: -70
                },
                labels: {
                    y: 16
                }
            },

            plotOptions: {
                solidgauge: {
                    dataLabels: {
                        y: 5,
                        borderWidth: 0,
                        useHTML: true
                    }
                }
            }
        };

// The speed gauge
        var chartSpeed = Highcharts.chart('container-speed', Highcharts.merge(gaugedOptions, {
            yAxis: {
                min: 0,
                max: 1000,
                title: {
                    text: 'Balans'
                }
            },

            credits: {
                enabled: false
            },

            series: [{
                name: 'Speed',
                data: [value],
                dataLabels: {
                    format:
                        '<div style="text-align:center">' +
                        '<span style="font-size:25px">{y} AZN</span><br/>' +
                        '<span style="font-size:12px;opacity:0.4">Cari balans</span>' +
                        '</div>'
                },
                tooltip: {
                    valueSuffix: 'balans'
                }
            }]

        }));

    }
    function getUserBalans() {
        userBalanceFactory.getUserBalans()
            .then(function (value) {
                $scope.userBalans=value;
                balansChart($scope.userBalans)
            },function (reason) {
                console.log(reason);
            })
    }
    function getUserBonus() {
        userBalanceFactory.getUserBonus()
            .then(function (value) {
                $scope.userBonus=value[0];
            },function (reason) {
                console.log(reason);
            })
    }
    function getUserBalansData() {
        userBalanceFactory.getUserBalansData($scope.balansLimit,$scope.balansOffset)
            .then(function (value) {
                $scope.userAllBalance=value;
            },function (reason) {
                console.log(reason);
            })
    }
}]);