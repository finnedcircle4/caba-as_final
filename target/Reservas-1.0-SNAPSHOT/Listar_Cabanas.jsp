
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <title>Busqueda por cabañas</title>
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
            <h1>Busqueda por cabañas</h1>
            <form action="Listar_cabanas" method="POST" >
                <table>
                    <tbody>
                        <tr>
                            <td><label for="cabana">Seleccionar cabaña :</label></td>
                            <td><select name="cabana" id="cabana">
                                    <option value="" disabled>Seleccione cabaña</option>
                                    <option value="Pequena">Pequeña (4p.)</option>
                                    <option value="Mediana">Mediana (8p.)</option>
                                    <option value="Grande">Grande (12p.)</option>
                                </select></td>
                            <td></td>
                            <td><button style="background-color: buttonface" type="submit">Buscar</button></td>
                        </tr>
                    </tbody>
                </table>
                <br>
            </form>
            <div style="margin-top:20px;">
                <h6>${respuesta}</h6>
            </div>
        </div>

    </body>
</html>
