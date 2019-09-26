<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Produto</title>
    </head>
    <body>
        <div class="container" align="center">
            <div class="col-md-6 cadastro">
                <br/>
                <h1>Produto</h1>
                <form>
                    <div class="form-group">
                        <input type="button" class="btn btn-outline-success" onclick="location.href='adicionarProduto'" value="Adicionar">
                    </div>
                </form>    
                <div class="form-group">
                    <table border="1" cellpadding="5">
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Quantidade (g)</th>
                        <th>Data Validade</th>
                        <th>Ação</th>
                    </tr>
                    <c:forEach items="${listaProdutos}" var="produto">
                    <tr>
                        <td>${produto.idProduto}</td>
                        <td>${produto.nome}</td>
                        <td>${produto.quantidade}</td>
                        <td>${produto.dataValidade}</td>
                        <td>
                            <a href="alterarProduto?idProduto=${produto.idProduto}" class="badge badge-pill badge-warning">Editar</a>
                            &nbsp;&nbsp;&nbsp;
                            <a href="excluirProduto?idProduto=${produto.idProduto}" class="badge badge-pill badge-danger">Deletar</a>
                        </td>
                    </tr>
                    </c:forEach>
                </table>
                </div>        
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" 
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"/>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"/>                        
    </body>
</html>