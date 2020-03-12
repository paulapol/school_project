function loginbutton() {
    getToken();
    if(localStorage.getItem('token')!=null)
    { goToPage('index.html');}
}

function logouttbutton() {
    logout();

    goToPage('login.html')
}
function logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('markers');

}

function TwoInOne() {
    getPositions();
    getLatLong();
}