$(document).ready(function(){
    // 로그인
    var $login = $(".login")[0];
    var $modal = $("#loginModal");
    var $close = $(".close")[0];
    
    $login.onclick = function(){
        $modal.css("display", "block");
    }
    
    $close.onclick = function(){
        $modal.css("display", "none");
    }
    
    $(document).on("click", function(event){
        if($("#loginModal").is(event.target)){
            $("#loginModal").css("display", "none");
        }
    })
    //--------------------------------------------------
});