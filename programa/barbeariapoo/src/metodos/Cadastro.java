package metodos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Cadastro {
	public static boolean cadastrarCliente(String nome, String sobrenome, String telefone, String email, String senha, String inscricaoNacional, String tipoInscricaoNacional) {
		String query = "INSERT INTO tbl_cliente VALUES ( DEFAULT, '" + nome + "', '" + sobrenome + "', '" + telefone + "', '" + email + "', '" + senha + "');";
        try ( 
        		Connection connection = Conexao.getConnection();
                PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)
        ) {
            int result = statement.executeUpdate();

            int cdClienteInserido = 0;
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                	cdClienteInserido = generatedKeys.getInt(1);
                	
                	if (tipoInscricaoNacional.equals("CPF"))
                		query = String.format("call sp_insereClienteFisico (%d, '%s');", cdClienteInserido, inscricaoNacional);
                	else if (tipoInscricaoNacional.equals("CNPJ"))
                		query = String.format("call sp_insereClienteJuridico (%d, '%s');", cdClienteInserido, inscricaoNacional);
                	
                	result = statement.executeUpdate(query);
                }
                else
                    throw new SQLException("Creating user failed, no ID obtained.");
            }
            
            return result > 0; //true se pelo menos uma linha for afetada
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar usuario.", e);
        }
    }
}
