/**
 * Created with IntelliJ IDEA.
 * User: radu.miron
 * Date: 12/2/19
 * Time: 10:45 AM
 * To change this template use File | Settings | File Templates.
 */
function getPositions() {
    var criteria = new Criteria();
    sendRequest("GET", "getAllByTerminalIdAndCreationTimeBetween?" + $.param(criteria), null,' Bearer '+getAuth(), getPositionsSuccessHandler, getPositionsErrorHandler);
}
function getAuth(){
    let auth =JSON.parse(localStorage.getItem('token'));
    return auth;
}

function Criteria() {
    var deviceId = $('#deviceId').val().trim(); // select data from input and trim it
    if (deviceId.length > 0) {
        this.terminalID = deviceId;
    }

    var startDate = $('#startDate').val().trim(); // select data from input and trim it
    if (startDate.length > 0) {
        this.date1 = startDate;
    }

    var endDate = $('#endDate').val().trim(); // select data from input and trim it
    if (endDate.length > 0) {
        this.date2 = endDate;
    }
}

function getPositionsSuccessHandler(respData) {
    $("#result").empty();
    $("#result").append("<br>" + JSON.stringify(respData));
    //$("#result").text(respData); // appends the json to the 'result' div. see index.html
      localStorage.removeItem('markers');
     localStorage.setItem('markers',JSON.stringify(respData));

}

function getPositionsErrorHandler(status) {
    alert("err response: " + status); // popup on err.
    localStorage.removeItem('markers');
}

