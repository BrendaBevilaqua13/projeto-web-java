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
    <title>Clientes Cadastrados</title>
</head>
<body>
    <div class="container p-5">
     <%
       Cliente c = (Cliente)request.getAttribute("cliente");
     %>
        <div class="row">
                <div class="col"><h2>Clientes Cadastrados</h2></div>
                <div class="col"><a type="button" class="btn btn-info" href="index.html">Voltar ao Menu </a></div>
        </div>
         <div class="form-group mx-sm-3 mb-2 mt-5">
             <form action="busca" name="formBusca">
                    <div class="mb-3">
                        <label for="inputPassword2" class="sr-only">Buscar</label>

                        <input type="busca" class="form-control" id="meu-input" name="cpf-busca" value=<% out.print('"'+c.getCPF()+ '"'); %>>
                    </div>
                      <button type="submit" id="meu-submit" class="btn btn-primary" >Pesquisar </button>
                       <a href="clienteServlet" type="button" class="btn btn-warning" >Limpar </a>
             </form>
         </div>
    </div>
 <div class="container p-5">
    <form name="formCliente">
        <div class="mb-3">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th scope="col">Nome</th>
                  <th scope="col">CPF</th>
                  <th scope="col">Celular</th>
                  <th scope="col">Email</th>
                </tr>
              </thead>
              <tbody>
              <%
                   out.print("<tr>");
                      out.print("<td>" + c.getNome() + "</td>");
                      out.print("<td>" + c.getCPF() + "</td>");
                      out.print("<td>" + c.getCelular() + "</td>");
                      out.print("<td>" + c.getEmail() + "</td>");
                   out.print("</tr>");
              %>
              </tbody>
            </table>
        </div>
    </form>
 </div>

<script src="scripts/validador.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>


</body>
</html>