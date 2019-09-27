package br.com.myrecipe.controller;

import br.com.myrecipe.dao.ProdutoDAO;
import java.util.List;
import org.springframework.ui.Model;
import br.com.myrecipe.dao.ReceitaDAO;
import br.com.myrecipe.dominio.Produto;
import br.com.myrecipe.dominio.Receita;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerReceita {
    
    @RequestMapping(value = "/receita", method = RequestMethod.GET)
    public ModelAndView carregarListaReceitasBanco() {
        ReceitaDAO daoR = new ReceitaDAO(); 
        
        List<Receita> listaReceitas = daoR.listarTodasReceitas();
        ModelAndView mav = new ModelAndView("receita");
        mav.addObject("listaReceitas", listaReceitas);
        return mav;
    }
    
    @RequestMapping(value = "/adicionarReceita", method = RequestMethod.GET)
    public String novaReceitaBanco() {
        return "adicionarReceita";
    }
    
    @RequestMapping(value = "/salvarReceita", method = RequestMethod.POST)    
    public String salvarReceitaBanco(Receita receita) throws SQLException{
        ReceitaDAO daoR = new ReceitaDAO(); 
        
        daoR.adicionarReceitaBanco(receita);
        return "redirect:receita";
    }
    
    @RequestMapping(value = "/alterarReceita", method = RequestMethod.GET)     
    public ModelAndView alterarReceitaBanco(@RequestParam int idReceita){
        ReceitaDAO daoR = new ReceitaDAO(); 
        Receita receita = daoR.buscarReceitaPorID(idReceita);

        ModelAndView mav = new ModelAndView("alterarReceita");
        mav.addObject("receita", receita);
        return mav;
    }
    
    @RequestMapping(value = "/alterarReceita", method = RequestMethod.POST)     
    public String alterarReceitaBanco(@RequestParam int idReceita, HttpServletRequest request) throws SQLException{
        ReceitaDAO daoR = new ReceitaDAO(); 
        Receita receita = daoR.buscarReceitaPorID(idReceita);

        receita.setNome(request.getParameter("nome"));
        receita.setPreparo(request.getParameter("preparo"));
        daoR.alterarReceitaBanco(receita);
        return "redirect:receita";
    }

    @RequestMapping(value = "/excluirReceita", method = RequestMethod.GET)
    public String excluirReceitaBanco(@RequestParam int idReceita) throws SQLException{
        ReceitaDAO daoR = new ReceitaDAO(); 
        
        daoR.excluirReceitaBanco(idReceita);
        return "redirect:receita";  
    }    
}