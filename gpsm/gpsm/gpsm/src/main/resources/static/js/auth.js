
function  AuthData() {
    let authe = {};
    var username = $('#user').val().trim(); // select data from input and trim it
    if (username.length > 0) {
        authe["username"]=username;
    }
    var password = $('#password').val().trim(); // select data from input and trim it
    if (password.length > 0) {
        authe["password"]=password;
    }
    return authe;
}

function getToken() {
    var authData=new AuthData();
    sendRequest("POST", "authenticate", JSON.stringify(authData),null, getTokenSuccessHandler, getTokenErrorHandler);

}
function getTokenSuccessHandler(respData) {
    localStorage.setItem("token",JSON.stringify(respData.jwt));
}
function getTokenErrorHandler(status) {
    alert("err response: " + status); // popup on err.
}