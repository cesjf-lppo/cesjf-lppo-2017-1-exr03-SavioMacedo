<%@page import="java.util.Calendar"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- 
    Document   : registrar_saida
    Created on : 26/03/2017, 20:25:12
    Author     : savio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <fieldset>
            <legend>Registrar Saida</legend>
            <form method="post">
                <div>
                    <label>Selecione o visitante: </label>
                    <select name="id">
                        <c:forEach var="visitantes" items="${visitantes}">
                            <option value="${visitantes.id}">${visitantes.nome} || Entrada: <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${visitantes.entrada}" /></option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="Registrar Saida" />
                </div>
            </form>
        </fieldset>
    </body>
</html>
