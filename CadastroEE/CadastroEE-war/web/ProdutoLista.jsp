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

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produtos</title>
    </head>
    <body>
        <h1>Listagem de Produtos!</h1>
        <a href="ServletProdutoFC?acao=formIncluir" > Novo Produto </a>
        <%
            

            %>
    </body>
</html>
