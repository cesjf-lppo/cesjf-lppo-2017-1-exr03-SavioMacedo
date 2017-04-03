/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.DataFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author savio
 */
@WebServlet(urlPatterns = {"/registrar_saida.html"})
public class RegistrarSaidaServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
            List<visitante> visitante_lista =  new ArrayList<>();
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/usuario", "usuario", "senha");
            Statement operacao = conexao.createStatement();
            ResultSet resultado = operacao.executeQuery("select * from visitante where saida is null order by nome");
            
            while(resultado.next())
            {
                visitante visitante = new visitante();
                visitante.setId(resultado.getLong("id"));
                visitante.setNome(resultado.getString("nome"));
                visitante.setIdade(resultado.getInt("idade"));
                visitante.setEntrada(resultado.getTimestamp("entrada"));
                visitante_lista.add(visitante);
            }
            
            request.setAttribute("visitantes", visitante_lista);
            request.getRequestDispatcher("WEB-INF/registrar_saida.jsp").forward(request, response);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RegistrarSaidaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
            Long id = Long.parseLong(request.getParameter("id"));
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/usuario", "usuario", "senha");
            Statement operacao = conexao.createStatement();
            operacao.executeUpdate("update visitante set saida = CURRENT_TIMESTAMP where id="+id);
            
            response.sendRedirect("");
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RegistrarSaidaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
