<!DOCTYPE html>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="lista.Cliente" %>
<%@page import="java.util.List" %>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Editar Cliente</title>
</head>
<body>
<div class="container p-5">
     <div class="row">
        <div class="col"><h2>Editar Cliente</h2></div>
        <div class="col"><a type="button" class="btn btn-info" href="index.html">Voltar ao Menu </a></div>
     </div>
    <div class="mb-3 mt-5">
        <form action="salvar" name="formCliente">
        <%
        Cliente c=(Cliente)request.getAttribute("cliente");
        int indice=(int)request.getAttribute("indice");
            out.print("<div class='mb-3'>");
                out.print("<div class='col-xs-2'>");
                    out.print("Nome: <input type='text' class='form-control' name='nome' value='" +c.getNome()+ "'>");
                    out.print("CPF: <input type='text' class='form-control' name='cpf' value='" +c.getCPF()+ "'>");
                    out.print("Celular: <input type='text' class='form-control' name='celular' value='" +c.getCelular()+ "'>");
                    out.print("Email: <input type='text' class='form-control' name='email' value='" +c.getEmail()+ "'>");
                    out.print("<input type='hidden' name='indice' value='" +indice+ "'>");
                out.print("</div>");
            out.print("</div>");
        %>
        <button type="submit" value="Salvar" class="btn btn-primary">Salvar</button>
        </form>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>


</body>
</html>