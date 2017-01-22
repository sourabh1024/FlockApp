/**
 * Created by sourabh.su on 18/01/17.
 */

var app = app || angular.module('app', []);

app.controller('searchController', function ($scope, $http, $location, $rootScope, $window, $q) {
    console.log("hello");
    $scope.searchEnabled = false;

    $scope.searchWiki = function () {
        var userId = jQuery('#userId').val();
        var keyword = jQuery('#search-wiki-text').val();
        $scope.searchEnabled = true;
        $scope.searchWiki(keyword, userId).then(function (data) {
            console.log("data has come!");
        });
    };

    $scope.searchWiki = function (keyword, userId) {
        var def = $q.defer();
        var response = $http({
            url: "/testweb/search",
            method: "GET",
            params: {
                keyword : keyword,
                userId : userId
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
});