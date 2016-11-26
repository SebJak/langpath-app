
app.service('SessionService', function ($cookieStore) {

    this.setAuthentication = function(authenticated) {
        console.log("Session service write authentication");
        this.user = authenticated;
        $cookieStore.put('userSession', authenticated);
    };

    this.isLogged = function () {
        this.user = $cookieStore.get('userSession');
        return(this.user)? this.user : false;
    };

    this.logOut = function () {
        $cookieStore.remove('userSession');
    };

});