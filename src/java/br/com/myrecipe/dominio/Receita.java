package br.com.myrecipe.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Receita {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReceita;
    private String nome;
    private String preparo;

//    public Receita() {
//    }
//
//    public Receita(String nome, String preparo) {
//        this.nome = nome;
//        this.preparo = preparo;
//    }

    public int getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreparo() {
        return preparo;
    }

    public void setPreparo(String preparo) {
        this.preparo = preparo;
    }
}