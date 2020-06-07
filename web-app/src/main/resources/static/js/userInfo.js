function addUser() {

    let name = $('#name').val();
    var positionid = $("#positions option:selected").val();
    var groupid = $("#groups option:selected").val();

    $.ajax({
        type: "POST",
        url: "${pageContext.request.contextPath}/user/addajax.htm",
        data: "username=" + name + "&positionid=" + positionid + "&groupid=" + groupid,
        success: function (response) {
            $('#info').html(response);
            $('#name').val('');

        },
        error: function (e) {
            alert('Error: ' + e);
        }
    });
}

function deleteUser(id) {

    $.ajax({
        type: "POST",
        url: "${pageContext.request.contextPath}/user/deleteajax.htm",
        data: "userid=" + id,
        success: function (response) {
            $('#info').html(response);

        },
        error: function (e) {
            alert('Error: ' + e);
        }
    });
}

let inputUserName = document.getElementById('userName'),
    inputUserData = document.getElementById('userData');

inputUserName.addEventListener('input', () => {
    let request = new XMLHttpRequest();

    request.open("GET", "http://localhost:8080/userByName");
    request.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    request.send();

    // readystatechange or simpler type 'load'
    request.addEventListener('readystatechange', function () {
        if (request.readyState === 4 && request.status === 200) {
            let data = JSON.parse(request.response);
            console.log(data);
            inputUserData.value = data;

        } else {
            console.log(request.response);
        }
    })

});