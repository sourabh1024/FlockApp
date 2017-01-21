/**
 * Created by vishal.p on 21/01/17.
 */

var app = app || angular.module('app', []);

app.controller('createWikiCont', function ($scope, $http, $location, $rootScope, $window, $q) {
    $scope.saveWiki = function () {
        var title = jQuery('#wikiTitle').val();
        var content = simplemde.value();
        var visibleTo = jQuery("input[name='optradio']:checked").val();
        console.log("Title : ", title);
        console.log("Content : ", content);
        console.log("Visible To: ", visibleTo);
        $scope.saveWikiApi(title, content, visibleTo);
    };

    $scope.saveWikiApi = function (title, content, visible) {
        var def = $q.defer();
        var response = $http({
            url: "saveWiki",
            method: "POST",
            params: {
                title : title,
                content : content,
                visibleTo : visible
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