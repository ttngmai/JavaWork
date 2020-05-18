$(document).ready(function(){

    (function openAtPc(){
        var windowWidth = $(window).width();
        if(windowWidth >= 600) {
            // 배너 fadeIn
            var $banner = $("#banner");

            $banner.fadeIn(1000);
            //--------------------------------------------------
            
            // 상품 목록이 좌우에서 슬라이드 하면서 나타남
            var $recommend = $("#recommend");
            var $special = $("#special");

            $recommend.css({
                left : "-100%",
                opacity : 0});
            $special.css({
                right : "-100%",
                opacity : 0});

            $.when($banner).then(function(){
                $recommend.animate({
                    left: 0,
                    opacity: 1
                }, 1000);
                $special.animate({
                    right: 0,
                    opacity: 1
                }, 1000)    
            })
            //--------------------------------------------------           
        }
    })();

    $('.slider').bxSlider(); // 슬라이더

    $(window).resize(function(){
        var windowWidth = $(window).width();
        var $banner = $("#banner");
        
        if (windowWidth < 600) {
            $banner.css("display", "none");
        } else {
            $banner.css("display", "block");
        }
    });

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