package br.com.myrecipe.dao;

import br.com.myrecipe.dominio.Usuario;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UsuarioDAO {
    
    public EntityManager getEM(){
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyRecipePU");
        return factory.createEntityManager();
    }

    public void adicionarUsuarioBanco(Usuario usuario) throws SQLException{
        
        EntityManager em = getEM();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
    }
    
    public void alterarUsuarioBanco(Usuario usuario) throws SQLException{
        
        EntityManager em = getEM();
        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();
        em.close();
    }
    
    public Usuario retornarDados(Usuario usuario){
        
        EntityManager em = getEM();
        Usuario usuarioDB = em.find(Usuario.class, usuario.getNome());
        em.close();
        return usuarioDB;
    }
    
    public Usuario buscarUsuarioPorID(int idUsuario) {
        
        Usuario usuarioBanco = new Usuario();
        EntityManager em = getEM();
        try {
            usuarioBanco = em.find(Usuario.class, idUsuario);
        } catch(Exception e){
            System.out.println("Exception e ProdutoDAO Linha 72: " + e.getMessage());
            System.out.println("Exception e ProdutoDAO Linha 72: " + e.getLocalizedMessage());
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return usuarioBanco;
    }
    
    public List buscarUsuarioPorEmailSenha(String email, String senha) {
        List<Usuario> listaUsuarioDB = null;
        try {
            EntityManager em = getEM();
            listaUsuarioDB = em.createQuery("SELECT u FROM Usuario u WHERE u.email LIKE :emailLogin AND u.senha LIKE :senhaLogin")
            .setParameter("emailLogin", email).setParameter("senhaLogin", senha).setMaxResults(1).getResultList();
        } catch (Exception e) {
            System.out.println("Exception e UsuarioDAO Linha 39: " + e.getMessage());
        }
        return listaUsuarioDB;
    }
    
    public String alterarSenhaUsuarioBanco(String email, String senha) throws SQLException{
        EntityManager em = getEM();
        
        try {
            Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :usuarioEmail");
            query.setParameter("usuarioEmail", email);
            Usuario usuario = (Usuario) query.getSingleResult();
            usuario.setSenha(senha);
            alterarUsuarioBanco(usuario);
            return "login";
        } catch (Exception e) {
            System.out.println("Exception e UsuarioDAO Linha 39: " + e.getMessage());
            return "esqueceuSenha";
        }
    }
}