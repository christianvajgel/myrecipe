package br.com.myrecipe.dao;

import br.com.myrecipe.dominio.Receita;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

public class ReceitaDAO {
    
    public EntityManager getEM(){
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyRecipePU");
        return factory.createEntityManager();
    }
    
    public void adicionarReceitaBanco(Receita receita) throws SQLException{
        
        EntityManager em = getEM();
        em.getTransaction().begin();
        em.persist(receita);
        em.getTransaction().commit();
        em.close();
    }
    
    public void alterarReceitaBanco(Receita receita) throws SQLException{
        
        EntityManager em = getEM();
        em.getTransaction().begin();
        em.merge(receita);
        em.getTransaction().commit();
        em.close();
    }
    
    public void excluirReceitaBanco(int idReceita) throws SQLException{
        
        EntityManager em = getEM();
        em.getTransaction().begin();
        Receita receitaDB = buscarReceitaPorID(idReceita);
        receitaDB = em.merge(receitaDB);
        em.remove(receitaDB);
        em.getTransaction().commit();
        em.close();
    }
    
    public Receita buscarReceitaPorID(int idReceita) {
        
        Receita receitaBanco = new Receita();
        EntityManager em = getEM();
        try {
            receitaBanco = em.find(Receita.class, idReceita);
        } catch(Exception e){
            System.out.println("Exception e ReceitaDAO Linha 72: " + e.getMessage());
            System.out.println("Exception e ReceitaDAO Linha 72: " + e.getLocalizedMessage());
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return receitaBanco;
    }
    
    public List<Receita> listarTodasReceitas(){
        
        List<Receita> listaReceita = null; 
        EntityManager em = getEM();
        try {
            CriteriaQuery criteria = em.getCriteriaBuilder().createQuery();
            criteria.select(criteria.from(Receita.class));
            listaReceita = em.createQuery(criteria).getResultList();
        } catch (Exception e) {
            System.out.println("Exception e ReceitaDAO Linha 20: " + e.getMessage());
            System.out.println("Exception e ReceitaDAO Linha 20: " + e.getLocalizedMessage());
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, e);
        } 
        return listaReceita;
    }
    
    public List<Receita> listarReceitasPossiveis(){
    
        List<Receita> listaPossiveisReceitas = null;
        EntityManager em = getEM();
        try {
            String sql = "select * from receita where idReceita not in (select receitaproduto.idReceita from receitaproduto,produto "
                    + "where receitaproduto.idProduto = produto.idProduto and receitaproduto.quantidade > produto.quantidade);";
            Query query = em.createNativeQuery(sql, Receita.class);
            listaPossiveisReceitas = query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception e: " + e.getMessage());
        }
        return listaPossiveisReceitas;
    }
}