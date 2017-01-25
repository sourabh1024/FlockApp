<%@ page import="beans.RequestParams" %>
<%
    String userId = null;
    try {
        RequestParams params = (RequestParams) request.getAttribute("requestParams");
        if (params.getUserId() != null)
            userId = params.getUserId();
    } catch (Exception e) {

    }

%>
<!DOCTYPE html>
<html ng-app="app">
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="https://jqueryvalidation.org/files/demo/site-demos.css">
    <link rel="stylesheet" href="css/searchBar.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
</head>

<body>

<input id="userId" value="<%=userId%>" type="hidden"/>

<div class="container" ng-controller="searchController" ng-cloak>
    <div class="row" style="text-align: center;">
        <img src="images/icon.png" style="width: 100px; height: 50px;"/>
    </div>

    <div class="row layout-padding" style="text-align: center; padding-top: 10px; padding-bottom: 10px;">
        <div id="custom-search-input">
            <div class="input-group col-md-12">
                <input type="text" class="form-control input-lg" placeholder="Search..." id="search-wiki-text"/>
                <span class="input-group-btn">
          <button class="btn btn-info btn-lg" type="button" id="search-wiki-button" ng-click="searchResponse()">
            <i class="fa fa-search"></i>
          </button>
        </span>
            </div>
        </div>
    </div>

    <div class="row layout-padding" id="wrapper" style="text-align: center; padding-bottom: 10px;">
        <button class="btn btn-info" type="button" style="margin: auto; margin-right: 5px;" id="create-wiki-button"
                ng-click="createWiki()"><span class="fa fa-plus-square-o"></span> Create Wiki
        </button>
        <button class="btn btn-info" type="button" style="margin: auto;" data-toggle="modal" data-target="#wiki"
                id="get-wiki-button"><span class="fa fa-file-text-o"></span> Get Document By Id
        </button>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="wiki" role="dialog">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Share With Others</h4>
                </div>
                <div class="modal-body" style="text-align: center">
                    <div id="custom-share-input">
                        <div class="input-group col-md-6">
                            <input type="text" class="form-control input-lg" placeholder="Copy Shareable Id..."
                                   ng-model="wikiId" id="share-wiki-text"/>
                            <span class="input-group-btn">
          <button class="btn btn-info btn-lg" type="button" id="wiki-button" ng-click="goToWikiPage(wikiId)">
            GetWiki
          </button>
        </span>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Done</button>
                </div>
            </div>
        </div>
    </div>
    <%--<div class="panel panel-default search-section1 layout-padding" id="searchDiv" ng-if="searchEnabled">--%>
        <%--<div class="panel-body" >--%>
            <div class="search-section1 layout-padding" id="searchDiv" ng-if="searchEnabled">
                <div class="list-group" ng-repeat="searchRow in searchResults">
                    <div class="panel panel-default" style="margin-left: -10px;">
                        <div class="panel-body container" id="content">
                            <div><a class="list-group" ng-click="goToWikiPage(searchRow.id)"><h4>
                                {{searchRow.title}}</h4></a>
                            </div>
                            <div class="list-group desc"><p id="searchPara">{{searchRow.description}}</p></div>
                        </div>
                    </div>
                </div>
            </div>
        <%--</div>--%>
    <%--</div>--%>

    <%--<div class="search-section1 layout-padding" id="searchDiv" ng-if="searchEnabled">--%>
    <%--<div class="list-group" ng-repeat="searchRow in searchResults">--%>
    <%--<div><a class="list-group" ng-click="goToWikiPage(searchRow.id)"><h4>{{searchRow.title}}</h4></a></div>--%>
    <%--<div class="list-group desc" ><p id="searchPara">{{searchRow.description}}</p></div>--%>
    <%--</div>--%>
    <%--</div>--%>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular.min.js"></script>
<script src="js/indexPage.js"></script>
<script src="js/index.js"></script>
</body>
</html>