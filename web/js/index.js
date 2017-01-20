/**
 * Created by sourabh.su on 18/01/17.
 */

$(document).ready(function () {
    $('#content').liveEdit({
        height: 350,
        css: ['bootstrap/css/bootstrap.min.css', 'bootstrap/bootstrap_extend.css'] /* Apply bootstrap css into the editing area */,
        groups: [
            ["group1", "", ["Bold", "Italic", "Underline", "ForeColor", "RemoveFormat"]],
            ["group2", "", ["Bullets", "Numbering", "Indent", "Outdent"]],
            ["group3", "", ["Paragraph", "FontSize", "FontDialog", "TextDialog"]],
            ["group4", "", ["LinkDialog", "ImageDialog", "TableDialog", "Emoticons", "Snippets"]],
            ["group5", "", ["Undo", "Redo", "FullScreen", "SourceDialog"]]
        ] /* Toolbar configuration */
    });

    $('#content').data('liveEdit').startedit();
});

function save() {
    var sHtml = $('#content').data('liveEdit').getXHTMLBody(); //Use before finishedit()
    alert(sHtml); /*You can use the sHtml for any purpose, eg. saving the content to your database, etc, depend on you custom app */
}

