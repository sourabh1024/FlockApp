
<!DOCTYPE html>
<html ng-app="app">
<head>
    <title>Wiki</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.css">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
</head>
<body>
<div class="container layout-padding" style="padding-bottom: 10px; padding-top: 10px;">
    <div class="input-group">
        <span class="input-group-addon" id="wikiTitle">Title</span>
        <input type="text" class="form-control" placeholder="Title" aria-describedby="wikiTitle">
    </div>
</div>
<div class="container layout-padding">
    <textarea id="wiki" placeholder="Write Something..."></textarea>
</div>
<div class="container">
    <h5> Visible To </h5>
    <label class="radio-inline">
        <input type="radio" name="optradio">All
    </label>
    <label class="radio-inline">
        <input type="radio" name="optradio">Team
    </label>
</div>
<script src="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="js/selectize.min.js"></script>
<script src="js/list.js"></script>
<script>
    var simplemde = new SimpleMDE();
</script>
</body>
</html>