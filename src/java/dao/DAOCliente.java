package dao;

import conexao.Conexao;
import entidade.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Manipula o SQL
 * @author laboratorio
 */
public class DAOCliente {
    
    //representa a conexao
    private Connection conn; 
    //representa um conjunto de dados
    private ResultSet rs; 
    //representa a instrucao sql pré compilada
    private PreparedStatement ps;
    
    public List<Cliente> buscaTodos() 
    {
        List<Cliente> clientes = new ArrayList<>();
        try 
        {
            conn = Conexao.abreConexao();
            ps = conn.prepareStatement(Cliente.BUSCA_TODOS);
            rs = ps.executeQuery();
            while (rs.next()) 
            {
               clientes.add(
                 new Cliente(rs.getInt("codigo"), 
                             rs.getString("nome"),
                             rs.getString("fone"),
                             rs.getString("email"))
               ); 
            } //fim do while
            System.out.println("objeto cliente"+clientes);
            conn.close();
            ps.close();
            rs.close();
            
            return clientes;
        } 
        catch (Exception e) 
        {
            System.out.println("Erro ao listar registros no busca todos");
            System.out.println( e.getMessage() );
        }
        finally 
        {
            if (conn != null) conn = null;
            if (ps != null) ps = null;
            if (rs != null) rs = null;
        }
        
        return null;
    }
    public void atualiza(Cliente c) throws SQLException{
        try{
            conn = Conexao.abreConexao();
            ps = conn.prepareStatement(Cliente.ALTERA);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getFone());
            ps.setString(3, c.getEmail());
            ps.setInt(4, c.getCodigo());
            ps.execute();
            conn.close();
        }catch(SQLException e){
            System.out.println("Erro ao atualizar os dados");
            System.out.println( e.getMessage() );
        }
        finally 
        {
            if (conn != null) conn = null;
            if (ps != null) ps = null;
        }
        
    }
    
    public Cliente find(final Integer id){
        try{
            conn =  Conexao.abreConexao();
            ps = conn.prepareStatement("SELECT * FROM CLIENTES WHERE CODIGO = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                
            return new Cliente(
                             rs.getInt("codigo"), 
                             rs.getString("nome"),
                             rs.getString("fone"),
                             rs.getString("email"));
            
            }
          
        }catch(SQLException ex){
            System.out.println(ex.getCause());
            ex.getErrorCode();
        }
        return null;
    }
    
    public void insereCliente(Cliente c) {
        try 
        {
            conn = Conexao.abreConexao();
            ps = conn.prepareStatement(Cliente.INSERE);
            ps.setInt(1, c.getCodigo());
            ps.setString(2, c.getNome());
            ps.setString(3, c.getFone());
            ps.setString(4, c.getEmail());
            ps.executeUpdate();
            
            conn.close();
            ps.close();
        } 
        catch (SQLException e) 
        {
            System.out.println("Erro ao inserir registros");
            System.out.println( e.getMessage() );
        }
        finally 
        {
            if (conn != null) conn = null;
            if (ps != null) ps = null;
        }
    }
    
    public void excluir(Cliente cli){
        try{
            conn = Conexao.abreConexao();
            try {
                ps = conn.prepareStatement(Cliente.EXCLUI);
            } catch (SQLException ex) {
                Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            ps.setInt(1, cli.getCodigo());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //TESTANDO AS COISAS...
    public static void main(String[] args) {
        List<Cliente> cli = 
                new DAOCliente().buscaTodos();
        System.out.println("LISTA DE CLIENTES");
        for(Cliente c: cli)
        {
            System.out.println("COD " + c.getCodigo());
            System.out.println("NOME " + c.getNome());
            System.out.println("FONE " + c.getFone());
            System.out.println("EMAIL " + c.getEmail());
            System.out.println("-----------");
        }
        Cliente clie = new DAOCliente().find(1);
        System.out.println("COD " + clie.getCodigo());
            System.out.println("NOME " + clie.getNome());
            System.out.println("FONE " + clie.getFone());
            System.out.println("EMAIL " + clie.getEmail());
            System.out.println("-----------");
    }
    
   
    
}
