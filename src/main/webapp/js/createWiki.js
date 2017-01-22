/**
 * Created by vishal.p on 21/01/17.
 */

function getParameterByName(name,url) {
    url = typeof url !== 'undefined' ? url : location.search;
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(url);
    return results === null ? null : decodeURIComponent(results[1].replace(/\+/g, " "));
}

var app = app || angular.module('app', []);

app.controller('createWikiCont', function ($scope, $http, $location, $rootScope, $window, $q) {
    $scope.saveWiki = function () {
        var title = jQuery('#wikiTitle').val();
        var content = simplemde.value();
        var visibleTo = jQuery("input[name='optradio']:checked").val();
        var userId = getParameterByName("userId");
        var userName = getParameterByName("userName");
        var groupName = getParameterByName("groupName");
        console.log("Title : ", title);
        console.log("Content : ", content);
        console.log("Visible To: ", visibleTo);
        console.log("user Id : ", userId);
        console.log("userName : ", userName);
        console.log("groupName: ", groupName);
        $scope.saveWikiApi(title, content, visibleTo, userId, userName, groupName);
    };

    $scope.saveWikiApi = function (title, content, visible, userId, userName, groupName) {
        var def = $q.defer();
        var response = $http({
            url: "/testweb/savewiki",
            method: "POST",
            params: {
                title : title,
                content : content,
                visibleTo : visible,
                userId : userId,
                userName : userName,
                groupName : groupName
            }
        });

        response.success(function(data, status, headers, config) {
            def.resolve(data);
        });
        response.error(function(data, status, headers, config) {
            def.reject("Error while saving wiki!");
        });
        return def.promise;
    };
});