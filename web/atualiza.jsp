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
        <title>Atualizar Contatos</title>
        <link rel="stylesheet" href="resources/css/bootstrap-reboot.min.css"/>
        <link rel="stylesheet" href="resources/css/bootstrap-grid.min.css"/>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
        
    </head>
    <body>
        <%
             Cliente cli = (Cliente) session.getAttribute("Cliente");
        %>
        <div class="container">
            <h1 class="display">Lista de Contatos</h1>
            <form  name="formAtualiza" action="ClienteController.do?acao=atualizar&id=<%=cli.getCodigo()%>" method="post">
                 <div class="form-group">
                    <label for="exampleInputEmail1">Codigo: </label>
                    <input type="number" class="form-control" id="codigo" name="codigo" aria-describedby="emailHelp" placeholder="<%=cli.getCodigo()%>" disabled="true">
                    <small id="emailHelp" class="form-text text-muted">Digite o novo codigo do usuario</small>
                 </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Nome: </label>
                    <input type="text" class="form-control" id="nome" name="nome" aria-describedby="emailHelp" placeholder="<%=cli.getNome()%>">
                    <small id="emailHelp" class="form-text text-muted">Digite o novo nome do usuario</small>
                 </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Email: </label>
                    <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" placeholder="<%=cli.getEmail()%>>">
                    <small id="emailHelp" class="form-text text-muted">Digite o novo email do usuario</small>
                 </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Telefone: </label>
                    <input type="tel" class="form-control" id="fone" name="fone" aria-describedby="emailHelp" placeholder="<%=cli.getFone()%>">
                    <small id="emailHelp" class="form-text text-muted">Digite o novo telefone do usuario</small>
                 </div>
                <div class="form-group">
                    <button class="btn btn-primary" type="submit" value="Enviar" name="env">Enviar</button>
                 </div>
            </form>
            <br/>
            <a href="ClienteController.do?acao=prepara-novo" class="btn btn-info">
                Inserir Novo Cliente
            </a> 
            <a href="ClienteController.do?acao=lista-todos" class="btn btn-info">
                Voltar para a Lista
            </a> 
            <a href="index.html" class="btn btn-info">
                Menu
            </a>
            
        </div>
        
    </body>
</html>