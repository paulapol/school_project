/**
 * Created with IntelliJ IDEA.
 * User: radu.miron
 * Date: 12/2/19
 * Time: 3:01 PM
 * To change this template use File | Settings | File Templates.
 */

function sendRequest (type, resource, data, Authorization, successHandler, errHandler) {
    jQuery.ajax({
        type: type,
        url: "http://localhost:8081/position/" + resource,
        data: data,
        dataType: "json",
        accepts: "application/json",

        headers: {
          //  'Authorization': 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU3NDAyNjY3MiwiaWF0IjoxNTczOTkwNjcyfQ._DsQUdHwhYlaep_TAHPy_undVtz_XOV5U-W4rFb1bc4',
            Authorization,
            'Accept': 'application/json',
            'Content-Type': 'application/json'

        },
        success: function (data, status, jqXHR) {
            successHandler (data);
        },

        error: function (jqXHR, status) {
            errHandler(status);
        }
    });
}

function goToPage(url) {
    $(location).attr('href',url);
}