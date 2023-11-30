package metodos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.FilaD;

public class FilaM {
	public static ArrayList<String[]> listarPedidosFila() {
		Connection connection = Conexao.getConnection();
		try {
			String query = "call sp_consultaPedidosNaFila";
			
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            ArrayList<String[]> lista = new ArrayList<String[]>();
            while (resultSet.next()) {
            	String[] filaD = new String[11];
            	
            	filaD[0] = resultSet.getString(1);
            	filaD[1] = resultSet.getString(2);
            	filaD[2] = resultSet.getString(4);
            	filaD[3] = resultSet.getString(5);
            	filaD[4] = resultSet.getString(6);
            	filaD[5] = resultSet.getString(7);
            	filaD[6] = resultSet.getString(8);
            	filaD[7] = resultSet.getString(9);
            	filaD[8] = resultSet.getString(10);
            	filaD[9] = resultSet.getString(11);
            	filaD[10] = resultSet.getString(12);
            	
                lista.add(filaD);
            }
            return lista;
  		} catch (SQLException e) {
			throw new RuntimeException("Erro ao realizar consulta.", e);
		}
    }
	
	public static ArrayList<String[]> listarPedidosPorFuncionarioEStatus(int cdFuncionario, int cdStatus) {
		Connection connection = Conexao.getConnection();
		try {
			String query = String.format("call sp_consultaPedidosPorStatusEFuncionario(%d, %d)", cdFuncionario, cdStatus);
			
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            ArrayList<String[]> lista = new ArrayList<String[]>();
            while (resultSet.next()) {
            	String[] filaD = new String[11];
            	
            	filaD[0] = resultSet.getString(1);
            	filaD[1] = resultSet.getString(2);
            	filaD[2] = resultSet.getString(4);
            	filaD[3] = resultSet.getString(5);
            	filaD[4] = resultSet.getString(6);
            	filaD[5] = resultSet.getString(7);
            	filaD[6] = resultSet.getString(8);
            	filaD[7] = resultSet.getString(9);
            	filaD[8] = resultSet.getString(10);
            	filaD[9] = resultSet.getString(11);
            	filaD[10] = resultSet.getString(12);
            	
                lista.add(filaD);
            }
            return lista;
  		} catch (SQLException e) {
			throw new RuntimeException("Erro ao realizar consulta.", e);
		}
    }
}
