<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Receita</title>
    </head>
    <body>
        <div class="container" align="center">
            <div class="col-md-6 cadastro">
                <br/>
                <h1>Receita</h1><br/>
                
                <input type="button" class="btn btn-outline-success" onclick="location.href='adicionarReceita'" value="Nova Receita">
                       
                <div class="container">
                    <br/><br/><table border="1" cellpadding="5">
                    <tr>
                        <th>Nome</th>
                        <th>Preparo</th>
                        <th>Ação</th>
                    </tr>
                    <c:forEach items="${listaReceitas}" var="receita">
                    <tr>
                        <td>${receita.nome}</td>
                        <td>${receita.preparo}</td>
                        <td>
                            <a href="alterarReceita?idReceita=${receita.idReceita}" class="badge badge-pill badge-warning">Editar</a>
                            &nbsp;&nbsp;&nbsp;
                            <a href="excluirReceita?idReceita=${receita.idReceita}" class="badge badge-pill badge-danger">Deletar</a>
                        </td>
                    </tr>
                    </c:forEach>
                </table><br/><br/>
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