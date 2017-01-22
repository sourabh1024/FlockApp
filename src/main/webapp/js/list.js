/**
 * Created by vishal.p on 21/01/17.
 */
var groupSelect = function () {
    var groupList = [];
    var defaultValues = [];
    groupList.push( { value : 'all', text : 'All'});
    groupList.push( { value : 'team', text : 'Team'});
    try{
        $('#groupSelect').selectize()[0].selectize.destroy();
    } catch(e) {};

    var $groupSelect  = $('#groupSelect').selectize({
        options: groupList,
        items: defaultValues,
        delimter: ',',
        persist: false,
        selectOnTab: true
    });
};

groupSelect();