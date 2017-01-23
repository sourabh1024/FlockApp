<%@ page import="beans.RequestParams" %>
<%
  String userId = null;
  try {
    RequestParams params= (RequestParams) request.getAttribute("requestParams");
    if(params.getUserId() != null)
      userId = params.getUserId();
  } catch (Exception e){

  }

%>
<!DOCTYPE html>
<html ng-app="app">
<head>
  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
  <link rel="stylesheet" href="https://jqueryvalidation.org/files/demo/site-demos.css">
  <link rel="stylesheet" href="css/searchBar.css">
  <link rel="stylesheet" href="css/style.css">
</head>

<body>

<input id="userId" value="<%=userId%>" type="hidden" />

<div class="container" ng-controller="searchController" ng-cloak>
  <div class="row layout-padding" style="text-align: center; padding-top: 10px; padding-bottom: 10px;">
    <input style="margin-bottom: 1px;" type="text" id="search-wiki-text"/>
    <button class="btn btn-success" type="button" id="search-wiki-button" ng-click="searchResponse()">Search</button>
    <button class="btn btn-success pull-right" type="button" style="margin: auto;" id="create-wiki-side-button" ng-if="searchEnabled">Create Wiki</button>
  </div>
  <div class="row layout-padding" id="wrapper" style="text-align: center" ng-if="!searchEnabled">
    <button class="btn btn-success" type="button" style="margin: auto;" id="create-wiki-button">Create Wiki</button>
  </div>
  <div class="search-section1 layout-padding" id="searchDiv" ng-if="searchEnabled">
    <div class="list-group" ng-repeat="searchRow in searchResults">
      <div><a class="list-group" ng-click="goToWikiPage(searchRow.id)"><h4>{{searchRow.title}}</h4></a></div>
      <div class="list-group desc" ><p id="searchPara">{{searchRow.content}}</p></div>
    </div>
  </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular.min.js"></script>
<script src="js/indexPage.js"></script>
<script src="js/index.js"></script>
</body>
</html>