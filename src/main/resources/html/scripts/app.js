
var app = angular.module('langpath', [
    'ngCookies',
    'ngResource',
    'ngRoute'
]);

app.config(function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'views/loginView.html',
        controller: 'LoginCtrl'
    }).when('/login', {
        templateUrl: 'views/loginView.html',
        controller: 'LoginCtrl'
    }).when('/welcome', {
        templateUrl: 'views/welcome.html',
        controller: 'WelcomeCtrl'
    }).when('/learnWordGroup/:id', {
        templateUrl: 'views/learnWord.html',
        controller: 'LearnWordGroupCtrl'
    }).when('/viewWordGroup/:id', {
        templateUrl: 'views/wordGroupView.html',
        controller: 'WordGroupCtrl'
    }).when('/editWordGroup/:id', {
        templateUrl: 'views/editWordGroupView.html',
        controller: 'EditWordGroupCtrl'
    }).when('/addWordGroup', {
        templateUrl: 'views/addWordGroupView.html',
        controller: 'AddWordGroupCtrl'
    }).when('/wordGroupList', {
        templateUrl: 'views/wordGroupListView.html',
        controller: 'WordGroupListCtrl'
    }).when('/registerUser', {
        templateUrl: 'views/registerUserView.html',
        contoller: 'RegisterUserCtrl'
    }).otherwise({
        templateUrl: 'views/welcome.html',
        controller: 'WelcomeCtrl'
    });

});

app.run(function ($rootScope, $window, $location, SessionService) {
    $rootScope.$on('$routeChangeStart', function () {
        var requestedPath = $location.url();
        if (!SessionService.isLogged() && requestedPath !== '/' && requestedPath !== '/login') {
            console.log('DENY');
            $window.location.href = '/#';
        }
        else {
            console.log('ALLOW');
        }
    });
});


