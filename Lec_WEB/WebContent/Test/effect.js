$(document).ready(function(){
    var $menuIcon = $("input:checkbox[id='menuIcon']");
    var $sidebar = $("#menuIcon+label+.sidebar")

    $menuIcon.click(function(){
        if ($menuIcon.is(":checked") == true) {
            $sidebar.animate({
                left: '0px'
            }, 350);
        } else {
            $sidebar.animate({
                left: '-300px'
            }, 350);
        }
    });
});