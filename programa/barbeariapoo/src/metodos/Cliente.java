package metodos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Cliente {
	public static String pegaNomeCliente(int cdCliente) {
    	Connection connection = Conexao.getConnection();
    	
    	try {
            String query = String.format(
            		"call sp_consultaClientePorCdCliente(%d)", 
            		cdCliente
            );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            String result = "";
            while (resultSet.next()) {
            	result = resultSet.getString(1);
            }

            return result;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao validar o login.", e);
        }
    }
}
