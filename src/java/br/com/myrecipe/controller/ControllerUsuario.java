package br.com.myrecipe.controller;

import java.util.List;
import org.springframework.ui.Model;
import br.com.myrecipe.dao.UsuarioDAO;
import br.com.myrecipe.dominio.Usuario;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerUsuario {
    
    @RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
    public String cadastroNovoUsuarioBanco(@ModelAttribute("usuario") Usuario usuario){
        return "cadastrar";
    }
    
    @RequestMapping(value = "/salvarUsuario", method = RequestMethod.POST)    
    public String salvarUsuarioBanco(@ModelAttribute("usuario") Usuario usuario) throws SQLException{
        UsuarioDAO daoU = new UsuarioDAO();
        daoU.adicionarUsuarioBanco(usuario);
        return "redirect:login";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@ModelAttribute("usuario") Usuario usuario){
        return "login";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String autenticarUsuario(Model model, Usuario usuario){
        UsuarioDAO daoU = new UsuarioDAO();
        List<Usuario> usuarioDB = daoU.buscarUsuarioPorEmailSenha(usuario.getEmail(), usuario.getSenha());
        
        if (usuarioDB.size() > 0) {
            model.addAttribute("nomeUsuario", usuarioDB.get(0).getNome());
            return "home";
        } else {
            return "dadosInvalidos";
        }
    }
    
//    @RequestMapping(value = "/esqueceuSenha", method = RequestMethod.GET)
//    public String alterarSenhaUsuarioBanco(@ModelAttribute("usuario") Usuario usuario){
//        return "esqueceuSenha";
//    }
//    
//    @RequestMapping(value = "/esqueceuSenha", method = RequestMethod.POST)
//    public String salvarNovaSenhaUsuarioBanco(@RequestParam String email, String senha) { //(@ModelAttribute("usuario") Usuario usuario){
//        daoU.alterarSenhaUsuarioBanco(email, senha);
//        return "redirect:login";
//    }
}