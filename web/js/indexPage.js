/**
 * Created by sourabh.su on 21/01/17.
 */

$(document).ready(function () {
        $('#create-wiki-button').click(function () {
            window.location = '/createWiki.jsp';
        });

        $('#search-wiki-button').click(function () {
            $.ajax({url: "/search", success: function(result){
                $("#div1").html(result);
            }});
        });

    }
);

