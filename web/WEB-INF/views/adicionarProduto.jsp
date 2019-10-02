<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Adicionar Produto</title>
    </head>
    <body>
        <div align="center"><br/><br/>
            <h2>Adicionar Produto</h2>
            <form action="salvarProduto" method="POST" >
                <br/><table border="0" cellpadding="5">
                    <tr>
                        <td>Nome:</td>                  
                        <td><input type="text" name="nome" id="nome" class="form-control" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Quantidade (g):</td>
                        <td><input type="number" min="0" step="0.1" name="quantidade" id="quantidade" class="form-control" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Data Validade:</td>
                        <td><input type="date" name="dataValidade" id="dataValidade" class="form-control" required="required"/></td>
                    </tr>    
                </table>
                <br/><input type="reset" class="btn btn-outline-danger" value="Limpar">
                <input type="submit" class="btn btn-outline-success" value="Salvar">
            </form>
        </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" 
    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"/>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"/>
    </body> 
</html>