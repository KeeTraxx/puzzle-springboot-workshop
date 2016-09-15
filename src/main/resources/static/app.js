
function sendRequestMoto(name) {
    $.ajax({
        url: "/api/moto?name=" + name
    }).then(function(data) {
        showQuote(data);
    });
}

function sendRequest() {
    $.ajax({
        url: "/api/quote"
    }).then(function(data) {
        showQuote(data[getRandomInt(data.length)]);
    });
}

function sendRequestPirate() {
    $.ajax({
        url: "/api/piratequote"
    }).then(function(data) {
        showQuote(data[getRandomInt(data.length)]);
    });
}

function showQuote(data) {
    //{"id":1,"quote":"Frankly, my dear, I don't give a damn.","character":"Rhett Butler","actor":"Clark Gable","movie":"Gone with the Wind","year":1939}
    $("#quotes").html("");
    $("#quotes").append("<tr><td width='20%'>Quote:</td></td><td>" + data.quote + "</td></tr>")
        .append("<tr><td>Character:</td></td><td>" + data.character + "</td></tr>")
        .append("<tr><td>Actor:</td></td><td>" + data.actor + "</td></tr>")
        .append("<tr><td>Year:</td></td><td>" + data.year + "</td></tr>");
}

function getRandomInt(max) {
    return Math.floor(Math.random() * (max - + 1));
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#send" ).click(sendRequest);
    $( "#sendmoto" ).click(function() { sendRequestMoto($("#name").val); });
    $( "#sendpirat" ).click(sendRequestPirate);
});