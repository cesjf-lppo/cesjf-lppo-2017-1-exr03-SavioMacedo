/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author savio
 */
@WebServlet(urlPatterns = {"/registrar_entrada.html"})
public class RegistrarEntradaServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.getRequestDispatcher("WEB-INF/registrar_entrada.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
            visitante visitante = new visitante();
            visitante.setNome(request.getParameter("nome"));
            visitante.setIdade(Integer.parseInt(request.getParameter("idade")));
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/usuario", "usuario", "senha");
            Statement operacao = conexao.createStatement();
            operacao.executeUpdate("INSERT INTO VISITANTE(NOME,IDADE) VALUES ('"+visitante.getNome()+"',"+visitante.getIdade()+")");
        }
        catch (ClassNotFoundException | SQLException ex)
        {
            Logger.getLogger(RegistrarEntradaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("");
    }
}
