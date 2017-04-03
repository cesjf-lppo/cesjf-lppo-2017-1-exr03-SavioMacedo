<%-- 
    Document   : index
    Created on : 26/03/2017, 21:40:27
    Author     : savio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <fieldset>
            <legend>Sistema de Visistantes</legend>
            <a href="registrar_entrada.html"><input type="button" value="Registrar Entrada"/></a>
            <a href="registrar_saida.html"><input type="button" value="Registrar Saida"/></a>
            <table border="2">
                <tr>
                    <th>Id</th>
                    <th>Nome</th>
                    <th>Idade</th>
                    <th>Data de entrada</th>
                    <th>Data de saída</th>
                </tr>
                <c:forEach var="visitantes" items="${visitantes}">
                    <tr>
                        <td>${visitantes.id}</td>
                        <td>${visitantes.nome}</td>
                        <td>${visitantes.idade}</td>
                        <td><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${visitantes.entrada}" /></td>
                        <td><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${visitantes.saida}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </fieldset>
    </body>
</html>
