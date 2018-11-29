function sendMessages() {
    $.ajax({
        url : '/service',
        type: 'POST',
        data : {
            mode : 'send',
            message: document.getElementById('message').value
        },
        success : function(response) {
            $('#sendJMS ul').append('<li>'+response+'</li>');
        }
    });
}
function receiveMessages() {
    $.ajax({
        url : '/service',
        type: 'POST',
        data : {
            mode : 'receive' },
            success : function(response) {
                $('#receiveJMS ul').append('<li>'+response+'</li>');
        }
    });
}
