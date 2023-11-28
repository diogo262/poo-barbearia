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
}
