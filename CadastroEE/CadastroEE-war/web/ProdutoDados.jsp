<%-- 
    Document   : ProdutoDados
    Created on : 6 de set. de 2023, 10:40:39
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Dados do Produto</h1>
        <form action="ServletProdutoFC" method="post">
            <label>Nome: </label>
            <input type="text">
            <label>Quantidade: </label>
            <input type="number">
            <label>Preço Venda: </label>
            <input type="number">
            <button type="submit">Adicionar Produto</button>
        </form>
    </body>
</html>
