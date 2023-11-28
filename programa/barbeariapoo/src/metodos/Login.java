package metodos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {
	static int pegaCredencial(String nomeProcedure, String email, String senha) {
    	Connection connection = Conexao.getConnection();
    	
    	try {
            String query = String.format(
            		"call %s ('%s', '%s')", 
            		nomeProcedure,
            		email, 
            		senha
            );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            int result = 0;
            while (resultSet.next()) {
            	result = Integer.parseInt(resultSet.getString(1));
            }

            return result;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao validar o login.", e);
        }
    }
	
	public static int pegaCredencialFuncionario(String email, String senha) {
		return pegaCredencial("sp_consultaLoginFuncionario", email, senha);
	}
	
	public static int pegaCredencialCliente(String email, String senha) {
		return pegaCredencial("sp_consultaLoginCliente", email, senha);
	}
	
    static boolean validarLogin(String query) {
        Connection connection = Conexao.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao validar o login.", e);
        }
    }
    
    public static boolean validarLoginFuncionario(String emailCpfCnpj, String senha) {
    	String query = "SELECT * FROM tbl_funcionario WHERE email_funcionario = '" + emailCpfCnpj + "' AND senha_funcionario = '" + senha + "'";
    	return validarLogin(query);
    }
    
    public static boolean validarLoginCliente(String emailCpfCnpj, String senha) {
        String query = "SELECT * FROM tbl_cliente WHERE email_cliente = '" + emailCpfCnpj + "' AND senha_cliente = '" + senha + "'";
        return validarLogin(query);
    }
}
