
// email 패턴에 대한 정규표현식
var idPattern = /^[A-Za-z]{1}[A-Za-z0-9]{5,12}/ /* 영문으로 시작 6~12자 */
var pswdPattern = /(?=.*\d)(?=.*[a-z]).{8,15}/ /* 8~15자 숫자, 영문 조합 */
var emailPattern = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

function checkSubmit() {
    var frm = document.forms.signinForm;

    var userID = frm.userID.value.trim();
    var pswd = frm.pswd.value.trim();
    var pswd2 = frm.pswd2.value.trim();
    var email = frm.email.value.trim();

    document.getElementById("idWarn").innerHTML = "";
    document.getElementById("pswdWarn").innerHTML = "";
    document.getElementById("emailWarn").innerHTML = "";   
    
    if(!idPattern.test(userID)) {
        document.getElementById("idWarn").innerHTML = "잘못된 형식입니다"
        frm.userID.focus();
        return false;
    }
    
    if(!pswdPattern.test(pswd)) {
        document.getElementById("pswdWarn").innerHTML = "잘못된 형식입니다"
        frm.pswd.focus();
        return false;
    }
    if(!(pswd == pswd2)) {
        document.getElementById("pswdWarn").innerHTML = "<br>비밀번호가 일치하지 않습니다"
        frm.pswd.focus();
        return false;
    }

    if(!emailPattern.test(email)) {
        document.getElementById("emailWarn").innerHTML = "잘못된 형식입니다"
        frm.email.focus();
        return false;
    }
}