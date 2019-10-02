package br.com.myrecipe.dao;

import br.com.myrecipe.dominio.ReceitaProduto;
import java.sql.SQLException;

public class TESTE {

    public static void main(String[] args) throws SQLException {
        
        ReceitaProdutoDAO daoRP = new ReceitaProdutoDAO();
        ReceitaProduto rp = new ReceitaProduto();
        
        rp.setIdReceita(7);
        rp.setIdProduto(6);
        rp.setQuantidade(3);
        daoRP.adicionarReceitaProdutoBanco(rp);
        
        rp.setIdReceita(7);
        rp.setIdProduto(12);
        rp.setQuantidade(36);
        daoRP.adicionarReceitaProdutoBanco(rp);
        
        rp.setIdReceita(7);
        rp.setIdProduto(7);
        rp.setQuantidade(165);
        daoRP.adicionarReceitaProdutoBanco(rp);
        
        rp.setIdReceita(7);
        rp.setIdProduto(8);
        rp.setQuantidade(230);
        daoRP.adicionarReceitaProdutoBanco(rp);
        
        rp.setIdReceita(7);
        rp.setIdProduto(13);
        rp.setQuantidade(240);
        daoRP.adicionarReceitaProdutoBanco(rp);
        
        rp.setIdReceita(7);
        rp.setIdProduto(14);
        rp.setQuantidade(6);
        daoRP.adicionarReceitaProdutoBanco(rp);
        
        rp.setIdReceita(7);
        rp.setIdProduto(9);
        rp.setQuantidade(12);
        daoRP.adicionarReceitaProdutoBanco(rp);
    }
}