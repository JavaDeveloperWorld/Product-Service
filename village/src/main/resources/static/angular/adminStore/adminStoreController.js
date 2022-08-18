'use strict';

projectApp.controller('storeController',['$scope','storeFactory',function ($scope,storeFactory) {

     var selected={};

    getAllStoreProduct();
    getMinStoreProduct();
    pieChart();
    getAllSubProduct();

    function getAllStoreProduct() {
        storeFactory.getAllStoreProduct()
            .then(function (value) {
                $scope.allData=value;
                setChartData();
            },function (reason) {
                console.log(reason);
            })
    }
    function getAllSubProduct() {
        storeFactory.getAllSubProduct()
            .then(function (value) {
                $scope.allSubData=value;
                setChartData();
            },function (reason) {
                console.log(reason);
            })
    }
    $scope.insertProduct=function () {
        var objectData=[];
        if($scope.Pselected!=null && $scope.Sselected!=null){
            for (var i=0;i<$scope.allSubData.length;i++){
                if($scope.allSubData[i].name===$scope.Pselected){
                   objectData.push($scope.allSubData[i].id);
                }
            }
            if($scope.Sselected==="Active"){
                objectData.push("1");
            }else {
                objectData.push("0")
            }
            objectData.push($scope.dataMin);
            objectData.push($scope.dataCount);
            objectData.push($scope.dataMax);
            storeFactory.insertStore(objectData);
            alert("New dataset was added to base");
            window.location.reload();
        }else
        {
            alert("Please select any field of Product or select any status of Product");
        }

    };
    $scope.deleteStore=function () {
        storeFactory.deleteStore($scope.elementId);
        alert("Element was successfully deleted!!!");
        window.location.reload();
    };
    function getMinStoreProduct() {
        storeFactory.getMinStoreProduct()
            .then(function (value) {
                $scope.minData=value;
                setChartData();
            },function (reason) {
                console.log(reason);
            })
    }
    function setChartData() {
        var series=[];
        var data=[];
        for (var i=0;i<$scope.allData.length;i++){
            var object={};
            object.name=$scope.allData[i].subProduct.name;
            object.y=$scope.allData[i].count;
            data.push(object);
        }
        var seriesObject={
            name:"Products",
            colorByPoint: true,
            data:data
        };
        series.push(seriesObject);
        myDrawing(series)
    }
    $scope.checkPie=function (id) {
        var series=[];
        var data=[];
        for (var i=0;i<$scope.allData.length;i++){
            if(id===$scope.allData[i].id){
                var temp={}
                var temp1={};
                temp.name="Recently count";
                temp.y=$scope.allData[i].count;
                data.push(temp);
                temp1.name="Need to add count";
                temp1.y=$scope.allData[i].maxCount-$scope.allData[i].count;
                data.push(temp1);
            }
        }
        var seriesObject={
            name:"Store situation",
            colorByPoint: true,
            data:data
        };
        series.push(seriesObject);
        pieChart(series);
    };

    $scope.insertData=function(value){
        selected.count=selected.count+value;
        storeFactory.updateStore($scope.checkData);
        alert("Information was added to store");
        window.location.reload();
    };

    $scope.addValue=function (id) {
         $scope.checkData=[];
        for (var i=0;i<$scope.allData.length;i++){
            if(id===$scope.allData[i].id){
                selected.id=$scope.allData[i].id;
                selected.name=$scope.allData[i].subProduct.name;
                selected.minCount=$scope.allData[i].minCount;
                selected.count=$scope.allData[i].count;
                selected.maxCount=$scope.allData[i].maxCount;
                $scope.checkData.push(selected);
            }
        }
        // $scope.searchData=selected;
        // alert($scope.searchData[0]);
        // alert($scope.searchData[0].id)
    };

    function pieChart(series) {
        Highcharts.chart('pie', {
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false,
                type: 'pie'
            },
            title: {
                text: 'Browser product situation in store'
            },
            tooltip: {
                pointFormat: '{series.name}: <b>{point.y:.1f}</b>'
            },
            accessibility: {
                point: {
                    valueSuffix: '%'
                }
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        format: '<b>{point.name}</b>: {point.y:.1f} '
                    }
                }
            },
            series: series
        });
    }
    function myDrawing(series) {
        Highcharts.chart('container', {
            chart: {
                type: 'column'
            },
            title: {
                text: 'All Products in store'
            },
            subtitle: {
                text: 'All products and their count in store'
            },
            accessibility: {
                announceNewData: {
                    enabled: true
                }
            },
            xAxis: {
                type: 'category'
            },
            yAxis: {
                title: {
                    text: 'Total count of product in store'
                }

            },
            legend: {
                enabled: false
            },
            plotOptions: {
                series: {
                    borderWidth: 0,
                    dataLabels: {
                        enabled: true,
                        format: '{point.y:.1f}'
                    }
                }
            },

            tooltip: {
                headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
                pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}</b> of total<br/>'
            },

            series: series
        });
    }

}]);