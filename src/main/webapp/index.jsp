<%@ page import="beans.RequestParams" %>
<%
  RequestParams params= (RequestParams) request.getAttribute("requestParams");
  String userId = params.getUserId();
  String userName = params.getUserName();
  String groupName = params.getGroup();
%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/searchBar.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
<input id="userId" value="<%=userId%>" type="hidden" />
<input id="userName" value="<%=userName%>" type="hidden" />
<input id="group" value="<%=groupName%>" type="hidden" />
<div class="container" style="text-align: center">
  <br>
    <input style="margin-bottom: 1px;" type="text" id="search-wiki-text"/>
    <button class="btn btn-success" type="button" id="search-wiki-button">Search</button>
  <br/> <br/>
  <div id="wrapper" style="text-align: center">
    <button class="btn btn-success" type="button" style="margin: auto;" id="create-wiki-button">Create Wiki</button>
  </div>

</div>
<script src="js/indexPage.js"></script>
</body>
</html>