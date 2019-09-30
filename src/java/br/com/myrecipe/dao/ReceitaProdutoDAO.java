package br.com.myrecipe.dao;

import br.com.myrecipe.dominio.ReceitaProduto;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReceitaProdutoDAO {
    
    public EntityManager getEM(){
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyRecipePU");
        return factory.createEntityManager();
    }
    
    public void adicionarReceitaProdutoBanco(ReceitaProduto receitaProduto) throws SQLException{
        
        EntityManager em = getEM();
        em.getTransaction().begin();
        em.persist(receitaProduto);
        em.getTransaction().commit();
        em.close();
    }    
}