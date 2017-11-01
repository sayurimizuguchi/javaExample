<%-- 
    Document   : atualiza
    Created on : 25/10/2017, 10:23:57
    Author     : mmartins
--%>

<%@page import="java.util.List"%>
<%@page import="entidade.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Clientes</title>
        <link rel="stylesheet" href="resources/css/bootstrap-reboot.min.css"/>
        <link rel="stylesheet" href="resources/css/bootstrap-grid.min.css"/>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
        
    </head>
    <body>
        <div class="container">
            <center><h1 class="display">Lista de Clientes</h1></center>
            <table class="table table-bordered table-striped">
                <tr>
                    <td>Código</td>
                    <td>Nome</td>
                    <td>E-mail</td>
                    <td>Fone</td>
                    <td></td>
                    <td></td>
                </tr>

                <!-- get dados here -->
                <% List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
                   for(Cliente cli: clientes) { %>

                    <tr>
                        <td><%=cli.getCodigo()%></td>
                        <td><%=cli.getNome()%></td>
                        <td><%=cli.getEmail()%></td>
                        <td><%=cli.getFone()%></td>
                        <td><a href="ClienteController.do?acao=atualiza-cliente&id=<%=cli.getCodigo()%>" class="btn btn-info">Editar</a></td>
                        <td><a href="ClienteController.do?acao=delete&id=<%=cli.getCodigo()%>" class="btn btn-danger">Deletar</a></td>
                    </tr>

                <% } %>

            </table>
            <br/>
            <a href="ClienteController.do?acao=prepara-novo" class="btn btn-info">
                Inserir um Novo Registro
            </a> 
            <a href="index.html" class="btn btn-info">
                Voltar para o Menu
            </a>
            
        </div>
        
    </body>
</html>
