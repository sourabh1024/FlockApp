
<!DOCTYPE html>
<html ng-app="app">
<head>
    <title>Wiki</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.css">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="https://jqueryvalidation.org/files/demo/site-demos.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
</head>

<body>

<div class="container" ng-controller="createWikiCont" ng-cloak>

    <form id="wikiForm">
        <div class="layout-padding" style="padding-bottom: 10px; padding-top: 10px;">
            <div class="input-group">
                <span class="input-group-addon">Title</span>
                <input type="text" class="form-control" placeholder="Title" aria-describedby="wikiTitle" id="wikiTitle" required>
            </div>
        </div>

        <div class="layout-padding">
            <textarea id="wiki" placeholder="Write Something..." required></textarea>
        </div>

        <div class="layout-padding">
            <h5> Visible To </h5>
            <label class="radio-inline">
                <input type="radio" name="optradio" id="all" value="all">All
            </label>
            <label class="radio-inline">
                <input type="radio" name="optradio" id="team" value="team" checked>Team
            </label>

            <button class="btn btn-info pull-right layout-padding" type="button" id="home-button" style="margin-left: 5px;" ng-click="home()"><span class="fa fa-home"></span> Home</button>
            <button class="btn btn-info pull-right layout-padding" type="button" id="save-wiki-button" ng-click="saveWiki()"><span class="fa fa-floppy-o"></span> Save</button>
        </div>
    </form>

</div>

<script src="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.0/additional-methods.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="js/selectize.min.js"></script>
<script src="js/list.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular.min.js"></script>
<script src="js/mmd.min.js"></script>
<script src="js/createWiki.js"></script>
<script>
    var simplemde = new SimpleMDE();

    jQuery.validator.setDefaults({
        debug: true,
        success: "valid"
    });
    var form = $( "#wikiForm" );
    form.validate();
</script>
</body>
</html>