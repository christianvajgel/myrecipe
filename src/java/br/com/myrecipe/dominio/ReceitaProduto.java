package br.com.myrecipe.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReceitaProduto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReceita;
    private int idProduto;
    private double quantidade;

//    public ReceitaProduto() {
//    }
//
//    public ReceitaProduto(double quantidade) {
//        this.quantidade = quantidade;
//    }

    public int getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
}
