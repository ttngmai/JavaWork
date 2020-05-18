$(document).ready(function(){
    // 사이드 메뉴바
    var $menuIcon = $("input:checkbox#menuIcon");
    var $sidebar = $("#menuIcon+label+#sidebar")

    $menuIcon.prop("checked", false); // 다른 페이지로 이동했다가 돌아왔을 때 체크되있는 것을 방지

    $menuIcon.click(function(){
        if ($menuIcon.is(":checked") == true) {
            $sidebar.animate({
                left: 0
            }, 350);
        } else {
            $sidebar.animate({
                left: '-300px'
            }, 350);
        }
    });
    //--------------------------------------------------    
});