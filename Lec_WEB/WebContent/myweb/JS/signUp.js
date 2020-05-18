var idPattern = /^[A-Za-z]{1}[A-Za-z0-9]{5,12}/ /* 영문으로 시작 6~12자 */
var pswdPattern = /(?=.*\d)(?=.*[a-z]).{8,15}/ /* 8~15자 숫자, 영문 조합 */
var birthYearPattern = /^(19[0-9][0-9]|20\d{2})$/ /* 1900~2099 */
var birthMonthPattern = /^([1-9]|1[0-2])$/ /* 1~12 */
var birthDatePattern = /^([1-9]|[1-2][0-9]|3[0-1])$/ /* 1~31 */
var emailPattern = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/
var phoneNumPattern = /^\d{3}-\d{3,4}-\d{4}/

function checkSubmit() {
    var frm = document.forms.signupForm;

    var userID = frm.userID.value.trim();
    var pswd = frm.pswd.value.trim();
    var pswd2 = frm.pswd2.value.trim();
    var birthYear = frm.birthYear.value.trim();
    var birthMonth = frm.birthMonth.value.trim();
    var birthDate = frm.birthDate.value.trim();
    var email = frm.email.value.trim();
    var phoneNum = frm.phoneNum.value.trim();

    document.getElementById("idWarn").innerHTML = "";
    document.getElementById("pswdWarn").innerHTML = "";
    document.getElementById("emailWarn").innerHTML = ""; 
    document.getElementById("birthDateWarn").innerHTML = "";  
    document.getElementById("phoneNumWarn").innerHTML = "";  
    
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

    if(!birthYearPattern.test(birthYear)) {
        document.getElementById("birthDateWarn").innerHTML = "잘못된 형식입니다"
        frm.birthYear.focus();
        return false;
    }
    if(!birthMonthPattern.test(birthMonth)) {
        document.getElementById("birthDateWarn").innerHTML = "잘못된 형식입니다"
        frm.birthMonth.focus();
        return false;
    }
    if(!birthDatePattern.test(birthDate)) {
        document.getElementById("birthDateWarn").innerHTML = "잘못된 형식입니다"
        frm.birthDate.focus();
        return false;
    }

    if(!emailPattern.test(email)) {
        document.getElementById("emailWarn").innerHTML = "잘못된 형식입니다"
        frm.email.focus();
        return false;
    }

    if(!phoneNumPattern.test(phoneNum)) {
        document.getElementById("phoneNumWarn").innerHTML = "잘못된 형식입니다"
        frm.phoneNum.focus();
        return false;
    }
}