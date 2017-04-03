<%-- 
    Document   : registrar_entrada
    Created on : 26/03/2017, 19:02:52
    Author     : savio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Entrada</title>
    </head>
    <body>
        <fieldset>
            <legend>Registrar Entrada</legend>
            <form method="post">
                <input type="text" name="nome" placeholder="Nome do Visitante" />
                <input type="number" name="idade" placeholder="Idade do Visitante" />
                <input type="submit" value="Registrar Entrada" />
            </form>
        </fieldset>
    </body>
</html>
