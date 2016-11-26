
app.controller('LoginCtrl',function ($scope, $window, $http, SessionService) {

    console.log("Welcome on langpath page");

    $scope.credentials = {
        email: '',
        password: ''
    };

    $scope.loginUser = function () {
        $http({
                method: 'POST',
                url: '/langpath/query/login',
                data: $scope.credentials,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).then(function (response) {
                if(response.status == 200 && response.data.token != undefined) {
                    SessionService.setAuthentication(response.data);
                    $window.location.href = '#weclome';
                }
        });
    };

    $(document).ready(function(){
        $('#inputPassword').keypress(function(e){
            if(e.keyCode==13)
                $('#loginButton').click();
        });
    });
});