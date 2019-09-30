package br.com.myrecipe.dao;

import br.com.myrecipe.dominio.ReceitaProduto;
import java.sql.SQLException;

public class TESTE {

    public static void main(String[] args) throws SQLException {
        
        ReceitaProdutoDAO daoRP = new ReceitaProdutoDAO();
        ReceitaProduto rp = new ReceitaProduto();
        
        rp.setIdReceita(5);
        rp.setIdProduto(5);
        rp.setQuantidade(400);
        
        daoRP.adicionarReceitaProdutoBanco(rp);
    }
    
}
