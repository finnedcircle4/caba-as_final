<script>
    function validaRut() {
        var arut = new Array(8);
        var i, j, dv;
        if ((document.getElementById("rut").value.length) = 0) {
            alert("Debe ingresar un Número valido");
        } else {
            for (i = 1; i < 9; i++) {
                arut[i] = 0;
            }
            i = 0;
            for (j = (9 - (document.getElementById("rut").value.length)); j < 9; j++) {
                if ((document.getElementById("rut").value.substr(i, 1) >= 0) & (document.getElementById("rut").value.substr(i, 1) <= 9)) {
                    arut[j] = document.getElementById("rut").value.substr(i, 1);
                    i++;
                } else {
                    alert("Debe ingresar solo numeros sin puntos!");
                    i = 0;
                    break;
                }
            }
            if (i > 0) {
                dv = 11 - (((arut[1] * 3) + (arut[2] * 2) + (arut[3] * 7) + (arut[4] * 6) + (arut[5] * 5) + (arut[6] * 4) + (arut[7] * 3) + (arut[8] * 2)) % 11)
                if (dv === 10) {
                    dv = "K";
                } else if (dv === 11) {
                    dv = "0";
                }
                document.getElementById("dv").value = dv;
                return dv;
            }
        }
        }

</script>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <title>Formulario reserva cabañas</title>
    </head>
    <body>
        <div class="container-fluid mb-5">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="index.jsp">Menu Principal<span class="sr-only">(current)</span></a>
                        </li>
                    </ul>
                </div>
            </nav> 
        </div>
        <div class="container" style="margin-top:20px;">
            <h1>Registro de Editoriales</h1>
            <form action="RegistrarReserva" method="POST" >
                <table>
                    <tbody>
                        <tr>
                            <td><label for="rut">Rut de solicitante :</label></td>
                            <td><input type="number" name="rut" id="rut" placeholder="Ingrese Rut sin punto" onchange="validaRut();" required=""></td>
                            <td><input type="text" name="dv" id="dv" readonly></td>
                        </tr>
                        <tr>
                            <td><label for="nombres">Nombres de solicitante :</label></td>
                            <td><input type="text" name="nombres" id="nombres" placeholder="Ingrese nombre" required></td>
                        </tr>
                        <tr>
                            <td><label for="apellidos">Apellidos de solicitante :</label></td>
                            <td><input type="text" name="apellidos" id="apellidos" placeholder="Ingrese apellido" required></td>
                        </tr>
                        <tr>
                            <td><label for="acom">Cantidad de acompañantes :</label></td>
                            <td><input type="number" name="acom" id="acom" placeholder="ingrese cantidad" required></td>
                        </tr>
                        <tr>
                            <td><label for="dias">Cantidad de dias :</label></td>
                            <td><input type="number" name="dias" id="dias" placeholder="ingrese dias" required></td>
                        </tr>
                        <tr>
                            <td><label for="fecha">Fecha de inicio :</label></td>
                            <td><input type="date" name="fecha" id="fecha" required></td>
                        </tr>
                        <tr>
                            <td><label for="cabana">Seleccionar cabaña :</label></td>
                            <td><select name="cabana" id="cabana">
                                    <option value="" disabled>Seleccione cabaña</option>
                                    <option value="Pequena">Pequeña (4p.)</option>
                                    <option value="Mediana">Mediana (8p.)</option>
                                    <option value="Grande">Grande (12p.)</option>
                                </select></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><button style="background-color: buttonface" type="submit">Guardar reserva</button></td>
                        </tr>
                    </tbody>
                </table>
                <br>
            </form>

        </div>

    </body>
</html>
