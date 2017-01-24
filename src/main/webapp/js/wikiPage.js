/**
 * Created by sourabh.su on 24/01/17.
 */
function getParameterByName(name,url) {
    url = typeof url !== 'undefined' ? url : location.search;
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(url);
    return results === null ? null : decodeURIComponent(results[1].replace(/\+/g, " "));
}

var app = app || angular.module('app', []);

app.controller('wikiController', function ($scope, $http, $location, $rootScope, $window, $q) {

    $scope.getDocument = function (id) {
        var def = $q.defer();
        var response = $http({
            url: "/testweb/getdoc",
            method: "GET",
            params: {
                documentId : id,
                userId : $scope.userId
            }
        });

        response.success(function(data, status, headers, config) {
            def.resolve(data);
            console.log(data);
        });
        response.error(function(data, status, headers, config) {
            def.reject("Error While Fetching Results!");
        });
        return def.promise;
    };

    $scope.init = function () {
        $scope.userId = getParameterByName("userId");
        $scope.documentId = getParameterByName("id");
        $scope.getDocument($scope.documentId).then(function (data) {
            $scope.title = data.title;
            document.getElementById('content').innerHTML = data.content;
        });
    };

    $scope.init();

    $scope.searchWiki = function () {
        window.location = '/testweb/index.jsp?userId='+$scope.userId;
    };

    $scope.editWiki = function () {
        window.location = '/testweb/createWiki.jsp?userId='+$scope.userId+'&documentId='+$scope.documentId;
    };
});