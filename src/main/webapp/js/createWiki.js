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
            url: "/getdoc",
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
                var visibleTo = jQuery('#'+ data.visible_to).prop("checked", true);
            });
        }
    };

    $scope.init();

    $scope.saveWiki = function () {
        var title = jQuery('#wikiTitle').val();
        $scope.htmlContent = simplemde.options.previewRender(simplemde.value());
        $scope.content = simplemde.value();
        var visibleTo = jQuery("input[name='optradio']:checked").val();
        var userId = getParameterByName("userId");
        $scope.saveWikiApi(title, visibleTo, userId).then(function (data) {
            if(data.flag == "-1") {
                alert("Error!");
                return;
            }
            $scope.goToWikiPage(data.flag);
        });
    };

    $scope.goToWikiPage = function (id) {
        var userId = getParameterByName("userId");
        window.location = '/wikiPage.jsp?userId='+userId+'&id='+id;
    };

    $scope.home = function () {
        var userId = getParameterByName("userId");
        window.location = '/index.jsp?userId='+userId;
    };

    $scope.saveWikiApi = function (title, visible, userId) {
        var def = $q.defer();
        var documentId = getParameterByName("documentId") == null ? -1 : getParameterByName("documentId");
        var response = $http({
            url: "/savewiki",
            method: "POST",
            params: {
                title : title,
                content : $scope.content,
                visibleTo : visible,
                userId : userId,
                htmlContent : $scope.htmlContent,
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