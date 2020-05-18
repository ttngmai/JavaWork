$(document).ready(function(){
    var $banner = $("#banner");
    var $bannerImg = $("#bannerImg");
    var $recommend = $("#recommend");
    var $special = $("#special");

    (function(){
        var windowWidth = $(window).width();

        if (windowWidth >= 600) {
            $bannerImg.attr("src", "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FDdACf%2FbtqD3d7URVh%2FBfJaoFhfnDRSPXIhJbvVi1%2Fimg.jpg");
        }
        
        $banner.fadeIn(1500); // 배너 fadeIn

        // 상품 목록이 좌우에서 슬라이드 하면서 나타남
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
    })();

    // 화면 폭에 따른 배너 이미지 변경
    $(window).resize(function(){ 
        var windowWidth = $(window).width();

        if (windowWidth >= 600) {
            $bannerImg.attr("src", "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FDdACf%2FbtqD3d7URVh%2FBfJaoFhfnDRSPXIhJbvVi1%2Fimg.jpg");
        } else {
            $bannerImg.attr("src", "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FP7HqX%2FbtqD5JFZ4G9%2FAdLzVfu42dABNgtvnI2qik%2Fimg.jpg");    
        }
    });
    //--------------------------------------------------
});