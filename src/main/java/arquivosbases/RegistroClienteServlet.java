package arquivosbases;

import hash.Dicionario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lista.Cliente;
import lista.Repositorio;
import lista.Validacao;
import java.io.IOException;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = {"/clienteServlet","/insert","/create","/excluir","/editar","/salvar","/busca"})
public class RegistroClienteServlet extends HttpServlet {
    Repositorio repositorio = new Repositorio();
    Dicionario dicionario = new Dicionario();
    private PrintStream out;

    //mudar do metodo get para post

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        if(action.equals("/clienteServlet")){
            clientes(request,response);
        }else if (action.equals("/editar")) {
            editarCliente(request, response);
        }else if(action.equals("/create")){
            response.sendRedirect("registroCliente.jsp");
        }else if (action.equals("/busca")) {
            buscaCliente(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        if (action.equals("/insert")) {
            novoCliente(request, response);
        }else if (action.equals("/excluir")) {
            excluirCliente(request, response);
        }else if (action.equals("/salvar")) {
            salvarCliente(request, response);
        }
    }

    //Listar Clientes
    protected void clientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("lista.jsp");
            request.setAttribute("lista",dicionario.getDict());
            dispatcher.forward(request,response);
    }


    //Novo Cliente
    protected void novoCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "";
        List<String> mensagem = new ArrayList<>();
        final PrintWriter resposta = response.getWriter();
        Validacao valida = new Validacao();
        if(!valida.validacaoDados(request.getParameter("nome"),request.getParameter("cpf"),request.getParameter("celular"),request.getParameter("email"))){
            mensagem.add("Preencha todos os campos");
            page = "registroCliente.jsp";
        }else if(!valida.validacaoNome(request.getParameter("nome")).isEmpty()){
            mensagem.add(valida.validacaoNome(request.getParameter("nome")));
            page = "registroCliente.jsp";
        }else if(!valida.validacaoCPF(request.getParameter("cpf")).isEmpty()){
            mensagem.add(valida.validacaoCPF(request.getParameter("cpf")));
            page = "registroCliente.jsp";
        }else if(!valida.validacaoCelular(request.getParameter("celular")).isEmpty()){
            mensagem.add(valida.validacaoCelular(request.getParameter("celular")));
            page = "registroCliente.jsp";
        }else{
            Cliente c = dicionario.buscaCliente(request.getParameter("cpf"));
            if(c!=null){
                mensagem.add("Usuário com cpf já existe");
                page = "registroCliente.jsp";
            }else{
                dicionario.addTabela(request.getParameter("cpf"),request.getParameter("nome"),request.getParameter("celular"),request.getParameter("email"));
                mensagem.add("Cliente cadastrado com sucesso");
                page = "index.html";
            }
        }
        for (int i=0;i<mensagem.size();i++){
            System.out.println(mensagem.get(i));
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        request.setAttribute("mensagem",mensagem);
        dispatcher.forward(request,response);


    }

    //Excluir Cliente
    protected void excluirCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String i = request.getParameter("i");
        String cpf = request.getParameter("cpf");
        if ( cpf != null && cpf != ""){
            dicionario.excluirCliente(cpf);
        }
        request.setAttribute("lista",dicionario.getDict());
        RequestDispatcher dispatcher = request.getRequestDispatcher("lista.jsp");
        dispatcher.forward(request,response);

    }

    //Editar Cliente
    protected void editarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String pages ="";
        if(nome != null && nome!= ""){
            Cliente cliente = dicionario.buscarPeloNome(nome);
            pages="pages/editarCliente.jsp";
            request.setAttribute("cliente",cliente);

        }else{
            pages="lista.jsp";
            request.setAttribute("lista",dicionario.getDict());
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/editarCliente.jsp");
        dispatcher.forward(request,response);
    }

    //Atualizando cliente na lista
    protected void salvarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");


        if (cpf != null && cpf != "") {
            Cliente c = dicionario.buscaCliente(cpf);

            if(c!=null){
                c.setNome(request.getParameter("nome"));
                c.setCPF(request.getParameter("cpf"));
                c.setCelular(request.getParameter("celular"));
                c.setEmail(request.getParameter("email"));
            }
        }

        response.sendRedirect("clienteServlet");

    }

    //Buscando pelo cpf digitado no input
    protected void buscaCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cpf=request.getParameter("cpf-busca");
        Cliente cliente = dicionario.buscaCliente(cpf);
        String page = "";
        if (cliente != null){
            System.out.println(cliente);
            request.setAttribute("cliente",cliente);
            page = "cliente.jsp";

        }else{
            request.setAttribute("lista",dicionario.getDict());
            page = "lista.jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}
