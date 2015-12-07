'use strict';

/**
 * @ngdoc service
 * @name oauth2Provider
 *
 * @description
 * Service that holds the OAuth2 information shared across all the pages.
 *
 */
app.factory('oauth2Provider', function ($modal) {
    var oauth2Provider = {
        CLIENT_ID: '879138721526-tf0r3mr9jmmeicckb8jcvri4gnajrc1k.apps.googleusercontent.com',
        SCOPES: 'https://www.googleapis.com/auth/userinfo.email profile',
        signedIn: false
    };

    /**
     * Calls the OAuth2 authentication method.
     */
    oauth2Provider.signIn = function (callback) {
        gapi.auth.signIn({
            'clientid': oauth2Provider.CLIENT_ID,
            'cookiepolicy': 'single_host_origin',
            'accesstype': 'online',
            'approveprompt': 'auto',
            'scope': oauth2Provider.SCOPES,
            'callback': callback
        });
    };

    /**
     * Logs out the user.
     */
    oauth2Provider.signOut = function () {
        gapi.auth.signOut();
        // Explicitly set the invalid access token in order to make the API calls fail.
        gapi.auth.setToken({access_token: ''})
        oauth2Provider.signedIn = false;
    };

    /**
     * Shows the modal with Google+ sign in button.
     *
     * @returns {*|Window}
     */
    oauth2Provider.showLoginModal = function() {
        var modalInstance = $modal.open({
            templateUrl: '/partials/login.modal.html',
            controller: 'OAuth2LoginModalCtrl'
        });
        return modalInstance;
    };

    return oauth2Provider;
});
