//var urlBaseUser = "http://168.138.142.158:8080/api/user";
var urlBaseUser = "/api/user";

console.log("ejecutando funcion guardar")


var limpiarForm = function () {
    //$("#id").val('');
    $("#username").val('');
    $("#useremail").val('');
    $("#password").val('');
    $("#passwordrepeat").val('');
    
}



var guardarRegistro = function () {
    var payload;
    var method;
    //var id = $("#id").val();
    var id = ""
    var nm = $("#username").val();
    var em = $("#useremail").val();
    var pw = $("#password").val();
    var pwr = $("#passwordrepeat").val();

    var msg;
    var ruta;
    if (nm.length == 0 || em == null ) {
        alert('Revisar los campos ...!')
    }else { 
        if (!pw !== null && pw.length > 6 && !pwr !== null && pwr.length > 6) {
            if (pw == pwr) {
                if (id !== 'undefined' && id !== null && id.length > 0) {
                    ruta = urlBaseUser + "/update";
                    payload = {
                        id: +$("#id").val(),
                        name: $("#username").val(),
                        email: $("#useremail").val(),
                        password: $("#password").val(),
                        };
                        method = "PUT";
                        msg = "Se ha Actualizado Usuario";
                } else {
                    ruta = urlBaseUser + "/new";
                    payload = {
                        name: $("#username").val(),
                        email: $("#useremail").val(),
                        password: $("#password").val(),
                    };
                    method = "POST";
                    msg = "Registro Existoso ...!";
                    limpiarForm();

                }

                console.log("Guardando ", payload)
                console.log("ruta ", ruta)
                console.log("method ", method)

                $.ajax({
                    url: ruta,
                    type: method,
                    dataType: 'json',
                    headers: {
                        "Content-Type": "application/json"
                    },
                    data: JSON.stringify(payload),
                    statusCode: {
                        201: function () {
                            alert(msg);

                        }
                    },
                });  
            } else {
                alert('Verifique datos de password ...!');
            }
        } else {
                alert('Verifique datos de password ...!');
        }
    }        
}