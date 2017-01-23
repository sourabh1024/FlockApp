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

    $scope.getDocument = function (userId, id) {
        var def = $q.defer();
        var response = $http({
            url: "/testweb/getdoc",
            method: "GET",
            params: {
                documentId : id,
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

    $scope.init = function () {
        if(getParameterByName("documentId") != null){
            var documentId = getParameterByName("documentId");
            var userId = getParameterByName("userId");
            $scope.getDocument(userId, documentId).then(function (data) {
                var title = jQuery('#wikiTitle').val(data.title);
                var content = simplemde.value(data.content);
                var visibleTo = jQuery("input[name='optradio']:checked").val(data.visibleTo);
            });
        }
    };

    $scope.init();

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
        var documentId = getParameterByName("documentId") == null ? -1 : getParameterByName("documentId");
        var response = $http({
            url: "/testweb/savewiki",
            method: "POST",
            params: {
                title : title,
                content : content,
                visibleTo : visible,
                userId : userId,
                userName : userName,
                groupName : groupName,
                documentId : documentId
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