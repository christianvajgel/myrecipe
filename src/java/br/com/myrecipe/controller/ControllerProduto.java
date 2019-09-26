package br.com.myrecipe.controller;

import br.com.myrecipe.dao.ProdutoDAO;
import br.com.myrecipe.dominio.Produto;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerProduto {
    
    @RequestMapping(value = "/produto", method = RequestMethod.GET)
    public ModelAndView carregarListaProdutosBanco() {
        ProdutoDAO daoP = new ProdutoDAO();
        
        List<Produto> listaProdutos = daoP.listarTodosProdutos();
        ModelAndView mav = new ModelAndView("produto");
        mav.addObject("listaProdutos", listaProdutos);
        return mav;
    }
    
    @RequestMapping(value = "/adicionarProduto", method = RequestMethod.GET)
    public String novoProdutoBanco(Model model, Produto produto) {
        return "adicionarProduto";
    }

    @RequestMapping(value = "/salvarProduto", method = RequestMethod.POST)    
    public String salvarProdutoBanco(Model model, Produto produto) throws SQLException{
        ProdutoDAO dao = new ProdutoDAO();
        
        dao.adicionarProdutoBanco(produto);
        return "redirect:produto";
    }
    
    @RequestMapping(value = "/alterarProduto", method = RequestMethod.GET)     
    public ModelAndView alterarProdutoBanco(@RequestParam int idProduto){
        ProdutoDAO daoP = new ProdutoDAO();
        Produto produto;
        
        ModelAndView mav = new ModelAndView("alterarProduto");
        produto = daoP.buscarProdutoPorID(idProduto);
        mav.addObject("produto", produto);
        return mav;
    }
    
    @RequestMapping(value = "/alterarProduto", method = RequestMethod.POST)     
    public String alterarProdutoBanco(@RequestParam int idProduto, HttpServletRequest request) throws SQLException{
        ProdutoDAO daoP = new ProdutoDAO();
        Produto produto = daoP.buscarProdutoPorID(idProduto);

        produto.setNome(request.getParameter("nome"));
        produto.setQuantidade(Double.parseDouble(request.getParameter("quantidade")));
        produto.setDataValidade(request.getParameter("dataValidade"));
        daoP.alterarProdutoBanco(produto);
        return "redirect:produto";
    }
    
    @RequestMapping(value = "/excluirProduto", method = RequestMethod.GET)
    public String excluirProdutoBanco(@RequestParam int idProduto) throws SQLException{
        ProdutoDAO daoP = new ProdutoDAO();
        
        daoP.excluirProdutoBanco(idProduto);
        return "redirect:/produto";  
    }
}    