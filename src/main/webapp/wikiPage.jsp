<!DOCTYPE html>
<html ng-app="app">
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="https://jqueryvalidation.org/files/demo/site-demos.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
</head>

<body>

<div class="container" ng-controller="wikiController" ng-cloak>
    <div class="row layout-padding" style="padding-top: 10px;">
        <button class="btn btn-info" type="button" id="search-wiki-button" ng-click="searchWiki()"><span class="fa fa-search" style="font-size: 12px;"></span></button>
        <button class="btn btn-info pull-right" type="button" id="edit-wiki-button" ng-click="editWiki()"><span  class="fa fa-pencil-square-o" style="font-size: 12px;"></span></button>
    </div>

    <div class="container" style="text-align: center;"><h3 style="font-weight: bold; color: blue;">{{title}}</h3></div>
    <br>
    <div class="container">
        <p>
            {{content}}
        </p>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular.min.js"></script>
<script src="js/mmd.min.js"></script>
<script src="js/wikiPage.js"></script>

</body>
</html>