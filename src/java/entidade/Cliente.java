package entidade;

import java.io.Serializable;

/**
 * representa um ou vários clientes do banco.
 * @author laboratorio
 */
public class Cliente implements Serializable{
    private Integer codigo;
    private String nome;
    private String fone;
    private String email;
    
    public static final String BUSCA_TODOS = 
    "SELECT * FROM CLIENTES ORDER BY CODIGO";

    public static final String BUSCA_POR_CODIGO = 
    "SELECT * FROM CLIENTES WHERE CODIGO = ?";
    
    public static final String INSERE = 
    "INSERT INTO CLIENTES " + 
    " (CODIGO, NOME, FONE, EMAIL) " +
    " VALUES (?,?,?,?) ";
    
    public static final String ALTERA = 
    "UPDATE CLIENTES SET NOME = ?, FONE = ?, " +
    " EMAIL = ? WHERE CODIGO = ? ";        
    
    public static final String EXCLUI = 
    "DELETE FROM CLIENTES WHERE CODIGO = ? ";

    public Cliente() {
    }

    public Cliente(Integer codigo) {
        this.codigo = codigo;
    }

    public Cliente(Integer codigo, String nome, 
            String fone, String email) {
        System.out.print("Cliente codigo:"+codigo);
        this.codigo = codigo;
        this.nome = nome;
        this.fone = fone;
        this.email = email;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codigo=" + codigo + ", nome=" + nome + ", fone=" + fone + ", email=" + email + '}';
    }
}