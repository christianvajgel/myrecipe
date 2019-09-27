<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Cadastro</title>
</head>
<body>
    <div align="center">
        <h2>Cadastrar</h2>
        <form:form action="esqueceuSenha" method="POST" modelAttribute="usuario">
            <table border="0" cellpadding="5">
                <tr>
                    <td>Email:</td>
                    <td>
                        <form:input type="email" name="email" id="email" path="email" required="required"/></td>
                        <%--<form:hidden path="email"/>--%>
                    </td>
                </tr>  
                <tr>
                    <td>Nova senha:</td>
                    <td><form:input type="password" name="senha" id="senha" path="senha" required="required"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" class="btn btn-outline-success" value="Salvar"></td>
                </tr>                    
            </table>
        </form:form>
    </div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" 
integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"/>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"/>
</body>
</html>