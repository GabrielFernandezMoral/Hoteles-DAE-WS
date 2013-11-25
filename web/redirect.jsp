<%--
Views should be stored under the WEB-INF folder so that
they are not accessible except through controller process.

This JSP is here to provide a redirect to the dispatcher
servlet but should be the only JSP outside of WEB-INF.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Servicios</title>
    </head>

    <body>
        <ul>
            <li>
                <a href="servicioHotel">Servicio Hotel</a>
            </li>
            <li>
                <a href="servicioOperador">Servicio Operador</a>
            </li>
            <li>
                <a href="servicioAdministrador">Servicio Administrador</a>
            </li>
        </ul>
    </body>
</html>
