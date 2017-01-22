/**
 * Created by sourabh.su on 21/01/17.
 */

$(document).ready(function () {
        var userId = $('#userId').val();
        var userName = $('#userName').val();
        var groupName = $('#group').val();
        console.log("here ", userId, userName, groupName);
        $('#create-wiki-button').click(function () {
            window.location = '/testweb/createWiki.jsp?userId='+userId+'&userName='+userName+'&groupName='+groupName;
        });

        $('#search-wiki-button').click(function () {
            $.ajax({url: '/testweb/search?userId='+userId+'&userName='+userName+'&groupName='+groupName, success: function(result){
                $("#div1").html(result);
            }});
        });

    }
);

