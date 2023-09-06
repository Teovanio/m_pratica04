<%-- 
    Document   : ProdutoLista
    Created on : 1 de set. de 2023, 11:10:08
    Author     : Usuario
    ${param.name} ${param.country}
    <%=request.getParameter("country")%>
String mensagem = request.getParameter("country");
            
            for (int i = 0; i < 10; i++) {
                int x = 2 * i;
            
                out.println("<h2>" + x + "</h2>");
                
                out.println(mensagem);
            
                }
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="cadatroee.model.Produtos"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    List<Produtos> listaProdutos =  (List<Produtos>)request.getAttribute("listaProdutos");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produtos</title>
    </head>
    <body>
        <h1>Listagem de Produtos2!</h1>
        <a href="ServletProdutoFC?acao=formIncluir" > Novo Produto </a>
        listaProdutos
        <table>
            <thead>
                <td>
                    # |
                </td>
                <td>
                    Nome |
                </td>
                <td>
                    Quantidade |
                </td>
                <td>
                    Preço de Venda |
                </td>
                <td>
                    Opções
                </td>
            </thead>
            <tbody>
                <%
                    for (Integer i = 0; i < listaProdutos.size(); i++) {
                        Produtos p = listaProdutos.get(i);
                        String Links = String.format("<a href='ServletProdutoFC?acao=alterar&id=%s'>Alterar</a> <a href='ServletProdutoFC?acao=excluir&id=%s'>Excluir</a>",p.getIdProdutos(), p.getIdProdutos());
                        String conteudo = String.format("<tr><td>%s |</td><td>%s |</td><td>%s |</td><td>%s |</td><td>%s</td></tr>",
                        p.getIdProdutos(), p.getNome(), p.getQuantidade(), p.getPrecoVenda(), Links);
                        
                        out.println(conteudo);
                    }
                %>
            </tbody>
    </table>
    
</body>
</html>
