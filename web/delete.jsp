<%-- 
    Document   : atualiza
    Created on : 25/10/2017, 10:23:57
    Author     : mmartins
--%>

<%@page import="entidade.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmação de exclusão</title>
        <link rel="stylesheet" href="resources/css/bootstrap-reboot.min.css"/>
        <link rel="stylesheet" href="resources/css/bootstrap-grid.min.css"/>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
    </head>
    <body>
        <% 
           Cliente cli = (Cliente) request.getAttribute("Cliente");        
        %>
        <div class="container-fluid">
            <ul class="list-group"><br>
                <li class="list-group-item list-group-item-info">Deseja apagar o registro abaixo?</li><br>
                <li class="list-group-item list-group-item-heading">Codigo: <%=cli.getCodigo()%></li>
                <li class="list-group-item list-group-item-heading">Nome: <%=cli.getNome()%></li>
                <li class="list-group-item list-group-item-heading">Email: <%=cli.getEmail()%></li>
                <li class="list-group-item list-group-item-heading">Telefone: <%=cli.getFone()%></li>
                <li class="list-group-item list-group-item-heading">
                    <a class="btn btn-danger" href="ClienteController.do?acao=deletar-cliente&id=<%=cli.getCodigo()%>">
                        Sim
                    </a> 
                    
                    <a class="btn btn-info" href="ClienteController.do?acao=lista-todos">
                        Voltar para a Lista
                    </a>
                </li>
            </ul>
        </div>
    </body>
</html>
