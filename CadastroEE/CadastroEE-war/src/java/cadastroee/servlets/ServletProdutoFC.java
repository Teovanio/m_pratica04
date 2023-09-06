/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cadastroee.servlets;


import cadatroee.controler.ProdutosFacadeLocal;
import cadatroee.model.Produtos;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
public class ServletProdutoFC extends HttpServlet {
    @EJB
    ProdutosFacadeLocal facade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String destino = "";
        Integer id;
        Produtos p;
        List<Produtos> listaProdutos;
        
        switch (acao) {
            case "listar":
              
                listaProdutos = facade.findAll();
               
                destino = "ProdutoLista.jsp" ;
                request.setAttribute("listaProdutos", listaProdutos);
                break;
            case "incluir":
                destino = "ProdutoLista.jsp";
                Produtos novoProduto = new Produtos();
                novoProduto.setNome(request.getParameter("nome"));
                novoProduto.setPrecoVenda(Float.valueOf(request.getParameter("precoVenda")));
                novoProduto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                facade.create(novoProduto);
                listaProdutos = facade.findAll();
                request.setAttribute("listaProdutos", listaProdutos);
                break;
            case "alterar":
                destino = "ProdutoLista.jsp";
                id = Integer.valueOf(request.getParameter("id"));
                p = facade.find(id);
                p.setNome(request.getParameter("nome"));
                p.setPrecoVenda(Float.valueOf(request.getParameter("precoVenda")));
                p.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                facade.edit(p);
                listaProdutos = facade.findAll();
                request.setAttribute("listaProdutos", listaProdutos);
                break;
            case "excluir":
                destino = "ProdutoLista.jsp";
                id = Integer.valueOf(request.getParameter("id"));
                p = facade.find(id);
                facade.remove(p);
                listaProdutos = facade.findAll();
                request.setAttribute("listaProdutos", listaProdutos);
                break;
            case "formIncluir":
                destino = "ProdutoDados.jsp";
                break;
            case "formAlterar":
                destino = "ProdutoDados.jsp";
                id = Integer.valueOf(request.getParameter("id"));
                p = facade.find(id);
                request.setAttribute("Produtos", p);
                break;
            default:
                throw new AssertionError();
        }
        request.getRequestDispatcher(destino).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
