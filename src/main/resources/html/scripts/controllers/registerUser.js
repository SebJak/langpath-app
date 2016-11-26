app.controller('RegisterUserCtrl', function ($scope, $http) {
    $scope.user = {};
    
    $scope.createNewUser = function () {
        $scope.messages[0] = {type: "INFO", value: "User created. Please confirm email address."};
    }
})