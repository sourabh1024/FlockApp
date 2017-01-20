
<!DOCTYPE html>
<html ng-app="app">
<head>
  <title>Wiki</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.css">
<%--<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.1.1/css/bootstrap.min.css" />--%>
  <%--<link rel="stylesheet" href="css/simditor.css" />--%>
  <%--<link rel="stylesheet" href="css/font-awesome.css" />--%>
  <%--<style type="text/css">--%>
    <%--.header h2{font-size:16px;font-weight: normal;}--%>
    <%--.header p span,.header p pre{display:inline-block;float: left;line-height: 40px;}--%>
  <%--</style>--%>
</head>
<body>
  <%--<div class="container" ng-controller="mainController">--%>
    <%--<div simditor ng-model="editor"></div>--%>
  <%--</div>--%>
  <div class="container">
    <textarea id="demo1">This is text.</textarea>
  </div>
  <%--<script src="https://cdn.staticfile.org/jquery/2.1.1-rc2/jquery.min.js"></script>--%>
  <%--<script src="https://cdn.staticfile.org/angular.js/1.3.0-beta.3/angular.min.js"></script>--%>
  <%----%>
  <%--<script src="js/simditor-all.js"></script>--%>
  <%--<script src="js/doc_directive.js"></script>--%>
  <%--<script src="js/application.js"></script>--%>
  <script src="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.js"></script>
  <script>
    var simplemde = new SimpleMDE();
  </script>
</body>
</html>