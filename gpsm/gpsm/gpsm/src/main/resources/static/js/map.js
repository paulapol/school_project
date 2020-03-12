/**
 * Created with IntelliJ IDEA.
 * User: radu.miron
 * Date: 12/2/19
 * Time: 3:01 PM
 * To change this template use File | Settings | File Templates.
 */
var map;
var myLatLng = {lat: 46.7693924, lng: 23.5902006};

function initialize() {
    var mapCanvas = document.getElementById('map');
    var mapOptions = {
        center: new google.maps.LatLng(myLatLng),
        zoom: 6,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    }

    map = new google.maps.Map(mapCanvas, mapOptions)
}

function addStaticMarker() {
    var pos = getLatLong()
    var marker = new google.maps.Marker({
        position: pos,
        map: map,
        title:"lat:"+pos.lat+", long:"+pos.lng
    });
}

function getRandomPosition(){
    var randLatLng = {lat: (myLatLng["lat"] + Math.floor(Math.random() * 5) + 1),
        lng: (myLatLng["lng"] + Math.floor(Math.random() * 5) + 1)};
    return randLatLng;
}

function getLatLong() {
    initialize();
    let markers=JSON.parse(localStorage.getItem('markers'));
    for (let i=0;i<markers.length ;i++)
    {
        let pos={lat: parseFloat(markers[i].latitude),
                 lng: parseFloat(markers[i].longitude)};
        let marker = new google.maps.Marker({
            position: pos,
            map: map,
            title:"lat:"+pos.lat+", long:"+pos.lng
        });
    }


}