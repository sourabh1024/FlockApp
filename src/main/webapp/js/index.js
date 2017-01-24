/**
 * Created by sourabh.su on 18/01/17.
 */
function getParameterByName(name,url) {
    url = typeof url !== 'undefined' ? url : location.search;
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(url);
    return results === null ? null : decodeURIComponent(results[1].replace(/\+/g, " "));
}

var app = app || angular.module('app', []);

app.controller('searchController', function ($scope, $http, $location, $rootScope, $window, $q) {
    console.log("hello");
    $scope.searchEnabled = false;
    $scope.searchResults = [];

    $scope.searchResponse = function () {
        console.log("search kro");
        var userId = jQuery('#userId').val();
        if(userId == "null"){
            userId = getParameterByName("userId");
        }
        console.log("userId: ", userId);
        var keyword = jQuery('#search-wiki-text').val();
        $scope.searchEnabled = true;
        $scope.searchWiki(keyword, userId).then(function (data) {
            console.log("data has come!");
            $scope.searchResults = data;
            console.log("array : ", $scope.searchResults);
        });
    };

    $scope.goToWikiPage = function (id) {
        var userId = jQuery('#userId').val();
        if(userId == "null"){
            userId = getParameterByName("userId");
        }
        window.location = '/wikiPage.jsp?userId='+userId+'&id='+id;
    };

    $scope.createWiki = function () {
        var userId = jQuery('#userId').val();
        if(userId == "null"){
            userId = getParameterByName("userId");
        }
        window.location = '/createWiki.jsp?userId='+userId;
    };

    $scope.getWiki = function () {

    };

    $scope.searchWiki = function (keyword, userId) {
        var def = $q.defer();
        var response = $http({
            url: "/search",
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