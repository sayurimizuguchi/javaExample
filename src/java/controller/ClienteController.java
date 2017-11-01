package controller;

import dao.DAOCliente;
import entidade.Cliente;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ClienteController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        String acao = (request.getParameter("acao") != null )?request.getParameter("acao"):"erro.jsp";
        String id = (request.getParameter("id") != null )? request.getParameter("id"): "erro.jsp";
        String destino = "erro.jsp";
        
        Integer codigo = (request.getParameter("codigo") != null )?Integer.parseInt(request.getParameter("codigo")):0;
        String nome = (request.getParameter("nome") != null )?request.getParameter("nome"):"";
        String fone = (request.getParameter("fone") != null )?request.getParameter("fone"):"";
        String email = (request.getParameter("email") != null )?request.getParameter("email"):"";
        
        List<Cliente> clientes = new ArrayList<>();
        DAOCliente dao = new DAOCliente();
        Cliente cliente = new Cliente();
        clientes = dao.buscaTodos();
        switch (acao) {
            case "lista-todos":
                clientes = dao.buscaTodos();
                request.setAttribute("clientes", clientes);
                destino = "lista-clientes.jsp";
                break;
            case "prepara-novo":
                destino = "novo-cliente.jsp";
                break;
            case "insere":
                cliente.setCodigo(codigo);
                cliente.setNome(nome);
                cliente.setFone(fone);
                cliente.setEmail(email);
                dao.insereCliente(cliente);
                
                clientes = dao.buscaTodos();
                request.setAttribute("clientes", clientes);
                destino = "lista-clientes.jsp";
                break;
            case "atualiza-cliente":
                cliente = dao.find(Integer.parseInt(id));
                session.setAttribute("Cliente", cliente);
                destino = "atualiza.jsp";
            break;
            case "atualizar":
                cliente.setCodigo(Integer.parseInt(id));
                cliente.setNome(nome);
                cliente.setFone(fone);
                cliente.setEmail(email);
                {  try {
                        dao.atualiza(cliente);
                    } catch (SQLException ex) {
                        Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            clientes = dao.buscaTodos();
            request.setAttribute("clientes", clientes);
            destino = "lista-clientes.jsp";
                break;
            case "delete":
                cliente = dao.find(Integer.parseInt(id));
                request.setAttribute("Cliente", cliente);
                destino = "delete.jsp";
                break;
            case "deletar-cliente":
                cliente = dao.find(Integer.parseInt(id));
                dao.excluir(cliente);
                clientes = dao.buscaTodos();
                request.setAttribute("clientes", clientes);
                destino = "lista-clientes.jsp";
            break;
                
            
        }
        
        RequestDispatcher rd = 
                request.getRequestDispatcher(destino);
        rd.forward(request, response);
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
