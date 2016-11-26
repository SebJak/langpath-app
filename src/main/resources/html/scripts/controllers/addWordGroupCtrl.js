app.controller('AddWordGroupCtrl', function ($scope, $http, $window) {
    console.log("Hello in add word controller");

    $scope.addRow = function () {
        $scope.wordGroup.words.push({});
        $scope.wordGroup.words.push({});
        $scope.wordGroup.words.push({});
        $scope.wordGroup.words.push({});
    };
    $scope.langs =[
        {id: 1,
        label: "English"},
        {id: 2,
            label: "Polish"},
        {id: 3,
            label: "German"},
        {id: 3,
            label: "Italian"}
    ];

    $scope.clearModel = function () {
        $scope.wordGroup = {
            userId: '580e4757112f5a14ff495aae',
            name: '',
            description: '',
            words: [{},{},{},{},{}],
            sourceLang:'',
            targetLang:''
        };
        $scope.messages = [];

    };

    $scope.clearModel();

    $scope.cancel = function () {
        $scope.clearModel();
        $window.location.href = '#weclome';
    };

    $scope.saveGroup = function() {
        //$scope.clearModel();
        //$scope.messages[0] = {type: "INFO", value: "The word group has been successfully created."};
        $http({
            method: 'POST',
            url: '/langpath/command/createWordGroup',
            data: $scope.wordGroup,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function (response) {
                console.log("Success", response);
                $scope.wordGroup = {
                    userId: '58093966112f5a1dd40fcbb7',
                    name: '',
                    description: '',
                    words: [{},{},{},{},{}]
                };
                $scope.messages[0] = {type: "INFO", value: "The word group has been successfully created."};
            });
        }

})