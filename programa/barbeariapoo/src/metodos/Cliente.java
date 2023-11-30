package metodos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Cliente {	
	public static void chamaDialogAviso(String mensagemErro, String tituloErro) {
		JOptionPane.showMessageDialog(null, mensagemErro, tituloErro, JOptionPane.INFORMATION_MESSAGE);	
	}
	
	public static void chamaDialogErro(String mensagemErro, String tituloErro) {
		JOptionPane.showMessageDialog(null, mensagemErro, tituloErro, JOptionPane.ERROR_MESSAGE);	
	}
	
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
	
	public static int verificaSeClienteEstaNaFila(int cdCliente) {
		Connection connection = Conexao.getConnection();
		
		try {
            String query = String.format(
            		"call sp_consultaClienteNaFilaHojePorCdCliente(%d)", 
            		cdCliente
            );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            int result = 0;
            while (resultSet.next()) {
            	result = Integer.parseInt(resultSet.getString(1));
            }
            
            return result;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao realizar consulta.", e);
        }
	}
	
	public static boolean sairDaFila(int cdPedido) {
		Connection connection = Conexao.getConnection();
		
		try {
            String query = String.format("call sp_saiDaFila(%d)", cdPedido);
            PreparedStatement statement = connection.prepareStatement(query);
            
            return statement.executeUpdate() > 0 ? true : false;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao realizar consulta.", e);
		}
	}
	
	public static boolean entrarNaFila(int cdCliente) {
		Connection connection = Conexao.getConnection();
		
		try {
            String query = String.format("call sp_entrarNaFila(%d)", cdCliente);
            PreparedStatement statement = connection.prepareStatement(query);
            
            return statement.executeUpdate() > 0 ? true : false;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao realizar consulta.", e);
		}
	}
	
	public static int consultaClientesNaFrente(int cdCliente) {
		Connection connection = Conexao.getConnection();
		
		try {
			String query = "call sp_clientesNaFila";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            int qntdNaFrente = 0;
            while (resultSet.next()) {
            	if (Integer.parseInt(resultSet.getString(2)) == cdCliente)
            		break;
            	qntdNaFrente++;
            }
            
            return qntdNaFrente;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao realizar consulta.", e);
		}
	}
}
