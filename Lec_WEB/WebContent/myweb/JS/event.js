$(document).ready(function(){
    var $banner = $("#banner");
    var $bannerImg = $("#bannerImg");

    (function(){
        var windowWidth = $(window).width();

        if (windowWidth >= 600) {
            $bannerImg.attr("src", "https://k.kakaocdn.net/dn/oy265/btqEbaE8TKo/vzJ5FLTfEf0kiBzBwygIg0/img.jpg");
        }

        $banner.fadeIn(1500); // 배너 fadeIn
    })();

    // 화면 폭에 따른 배너 이미지 변경
    $(window).resize(function(){ 
        var windowWidth = $(window).width();

        if (windowWidth >= 600) {
            $bannerImg.attr("src", "https://k.kakaocdn.net/dn/oy265/btqEbaE8TKo/vzJ5FLTfEf0kiBzBwygIg0/img.jpg");
        } else {
            $bannerImg.attr("src", "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FbnfdLw%2FbtqD6PHt0BC%2FOKaNnZlpVkAg1S1impPUg0%2Fimg.jpg");    
        }
    });
    //--------------------------------------------------

});

