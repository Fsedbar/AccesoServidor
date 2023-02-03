<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


    

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Subir archivos</title>
    </head>
    <body>
    <c:choose>
        <c:when test="${not empty param.tomcat}">
            <form action="SubidaArchivos" method="POST" enctype="multipart/form-data">
                <input type="file" name="archivo"/>
                <input type="hidden" name="ruta" value="tomcat"/>
                <input type="submit" value="Subir archivo"/>
            </form>
        </c:when>
        <c:when test="${not empty param.apache}">
            <form action="SubidaArchivos" method="POST" enctype="multipart/form-data">
                <c:if test="${usuario.tipoUsuario eq false}">
                    <select name="asignatura">
                        <option value="Servidores">Servidores</option>
                        <option value="Cliente">Cliente</option>
                        <option value="Diseño">Diseño</option>
                        <option value="Despliegue">Despliegue</option>
                    </select>
                </c:if>
                <c:if test="${usuario.nombreUsuario eq 'lola'}">
                    <select name="asigLola">
                        <option value="Servidores">Servidores</option>
                        <option value="Despliegue">Despliegues</option>
                    </select>
                </c:if>
                <input type="file" name="archivo"/>
                <input type="hidden" name="ruta" value="apache"/>
                <input type="submit" value="Subir archivo"/>
            </form>
        </c:when>
    </c:choose>
    </body>
</html>
