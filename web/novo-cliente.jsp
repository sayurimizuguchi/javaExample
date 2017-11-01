<%-- 
    Document   : atualiza
    Created on : 25/10/2017, 10:23:57
    Author     : mmartins
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="resources/css/bootstrap-reboot.min.css"/>
        <link rel="stylesheet" href="resources/css/bootstrap-grid.min.css"/>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
        
    </head>
    <body>
        
        <form name="form1" id="form1" 
              method="post" 
              action="ClienteController.do?acao=insere">
        
        <table border="1">
            <tr>
                <td>Código: </td>
                <td>
                    <input type="text" name="codigo"
                           id="codigo" value="" />
                </td>
            </tr>
            <tr>
                <td>Nome: </td>
                <td>
                    <input type="text" name="nome"
                           id="nome" value="" />
                </td>
            </tr>
            <tr>
                <td>E-mail: </td>
                <td>
                    <input type="text" name="email"
                           id="email" value="" />
                </td>
            </tr>
            <tr>
                <td>Telefone: </td>
                <td>
                    <input type="text" name="fone"
                           id="fone" value="" />
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="OK" class="btn btn-info"/>
                </td>
            </tr>
        </table>
            
        </form>            
    </body>
</html>
