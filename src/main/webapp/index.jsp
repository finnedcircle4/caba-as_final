<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <title> HOME </title>
    </head>
    <body style="background-color:#F8F9F9">

        <div class="container" style="margin-top:50px">
            <div class="row mb-5">
                <div class="col">
                    <div class="card shadow" onclick="location.href='Formulario_Reserva.jsp'" style="cursor:pointer">
                        <div class="card-body">
                            <p class="card-text">Generar reserva</p>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card shadow" onclick="location.href='Listar_Cabanas.jsp'" style="cursor:pointer">
                        <div class="card-body">
                            <p class="card-text">Busqueda por cabañas</p>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card shadow" onclick="location.href='Listar_Reservas.jsp'" style="cursor:pointer">
                        <div class="card-body">
                            <p class="card-text">Listar todas las reservas</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <h2>${respuesta}</h2>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>


    </body>
</html>
