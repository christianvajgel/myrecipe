package br.com.myrecipe.dao;

import br.com.myrecipe.dominio.Produto;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

public class ProdutoDAO {
    
    public EntityManager getEM(){
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyRecipePU");
        return factory.createEntityManager();
    }

    public void adicionarProdutoBanco(Produto produto) throws SQLException{
        
        EntityManager em = getEM();
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
        em.close();
    }
    
    public void alterarProdutoBanco(Produto produto) throws SQLException{
        
        EntityManager em = getEM();
        em.getTransaction().begin();
        em.merge(produto);
        em.getTransaction().commit();
        em.close();
    }
    
    public void excluirProdutoBanco(int idProduto) throws SQLException{
        
        EntityManager em = getEM();
        em.getTransaction().begin();
        Produto produtoDB = buscarProdutoPorID(idProduto);
        produtoDB = em.merge(produtoDB);
        em.remove(produtoDB);
        em.getTransaction().commit();
        em.close();
    }
    
    public Produto retornarDados(Produto produto){
        
        EntityManager em = getEM();
        Produto produtoDB = em.find(Produto.class, produto.getNome());
        em.close();
        return produtoDB;
    }
    
    public Produto buscarProdutoPorID(int idProduto) {
        
        Produto produtoBanco = new Produto();
        EntityManager em = getEM();
        try {
            produtoBanco = em.find(Produto.class, idProduto);
//            CriteriaQuery criteria = em.getCriteriaBuilder().createQuery();
//            criteria.select(criteria.from(Produto.class));
//            List<Produto> lista = em.createQuery(criteria).getResultList();
//        } catch (IllegalArgumentException iae) {
//            System.out.println("IllegalArgumentException iae ProdutoDAO Linha 72: " + iae.getMessage());
//            System.out.println("IllegalArgumentException iae ProdutoDAO Linha 72: " + iae.getLocalizedMessage());
//            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, iae);
        } catch(Exception e){
            System.out.println("Exception e ProdutoDAO Linha 72: " + e.getMessage());
            System.out.println("Exception e ProdutoDAO Linha 72: " + e.getLocalizedMessage());
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return produtoBanco;
    }
    
    
    
    public List<Produto> listarTodosProdutos(){
        
//        List<Cadastro> lista = new ArrayList<>();
//        Conexao conn = new Conexao();
//        String sql = "select * from cadastro";
//        PreparedStatement ps = conn.getConexao().prepareStatement(sql);
//        ResultSet rs = ps.executeQuery();
//        
//        while (rs.next()) {
//            Cadastro cadastro = new Cadastro();
//            
//            cadastro.setNome(rs.getString("nome"));
//            cadastro.setEndereco(rs.getString("endereco"));
//            cadastro.setTelefone(rs.getInt("telefone"));
//            cadastro.setEmail(rs.getString("email"));
//            lista.add(cadastro);
//        }
        List<Produto> listaProdutos = null; 
        EntityManager em = getEM();
        try {
            CriteriaQuery criteria = em.getCriteriaBuilder().createQuery();
            criteria.select(criteria.from(Produto.class));
            listaProdutos = em.createQuery(criteria).getResultList();
        } catch (Exception e) {
            System.out.println("Exception e ProdutoDAO Linha 20: " + e.getMessage());
            System.out.println("Exception e ProdutoDAO Linha 20: " + e.getLocalizedMessage());
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, e);
        } 
        return listaProdutos;
    }
}