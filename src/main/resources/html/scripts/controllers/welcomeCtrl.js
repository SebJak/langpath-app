// var app = angular.module('langpath', [
//     'ngRoute'
// ]);

app.controller('WelcomeCtrl', function ($scope, $http) {

    console.log("Welcome Ctrl");

    // $scope.initData = function () {
    //
    //     $http.get("wordGroup.json",{
    //         "Content-Type": "application/json"}).success(function (response) {
    //         $scope.wordGroups = response;
    //         console.log(response);
    //
    //     });
    //
    // }

    $scope.init = function () {

        $http({
            method: 'POST',
            url: '/langpath//query/userInfo',
            data: {"id": "580e4757112f5a14ff495aae"},
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function (response) {
            console.log("Success", response);
            var data = {
                datasets: response.data.chartDatas
            };

            var ctx = document.getElementById("myChart").getContext("2d");
            var myBubbleChart = new Chart(ctx, {
                type: 'bubble',
                data: data,
                options: {
                    yAxes: [{
                        ticks: {
                            max: 10,
                            min: 0,
                            stepSize: 2
                        }
                    }],
                    xAxes: [{
                        time: {
                            unit: 'day'
                        },
                        ticks: {
                            min: 0,
                            max: 30
                        }
                    }],
                    responsive: true,
                    title: {
                        display: true,
                        text: 'Your word groups'
                    }
                }
            });
        });
    };
   // $scope.initData();
    $scope.init();
});
