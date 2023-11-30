package metodos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
	
	public static ArrayList<String[]> listaCliente() {
        ArrayList<String[]> lista = new ArrayList<String[]>();
        Connection connection = Conexao.getConnection();

        try {
            String query = "SELECT * FROM tbl_cliente";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String[] cliente = new String[6];
                cliente[0] = resultSet.getString("cd_cliente");
                cliente[1] = resultSet.getString("nome_cliente");
                cliente[2] = resultSet.getString("sobrenome_cliente");
                cliente[3] = resultSet.getString("telefone_cliente");
                cliente[4] = resultSet.getString("email_cliente");
                cliente[5] = resultSet.getString("senha_cliente");

                lista.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
	
	public static void excluirCliente(DefaultTableModel model, int selectedRow) {
	    if(selectedRow != -1) {
	        String cdCliente = model.getValueAt(selectedRow, 0).toString();

	        try {
	            Connection connection = Conexao.getConnection();
	            String sql = "DELETE FROM tbl_cliente WHERE cd_cliente = ?";
	            PreparedStatement statement = connection.prepareStatement(sql);
	            statement.setString(1, cdCliente);
	            int rowsAffected = statement.executeUpdate();

	            // aqui remove
	            model.removeRow(selectedRow);
	            
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	}
	
	public static void inserirCliente(DefaultTableModel model, String nome, String sobrenome, String telefone, String email, String senha) {
	    try {
	        Connection con = Conexao.getConnection();
	        PreparedStatement statement = con.prepareStatement("INSERT INTO tbl_cliente (nome_cliente, sobrenome_cliente, telefone_cliente, email_cliente, senha_cliente) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
	        statement.setString(1, nome);
	        statement.setString(2, sobrenome);
	        statement.setString(3, telefone);
	        statement.setString(4, email);
	        statement.setString(5, senha);
	        statement.executeUpdate();

	        ResultSet resultSet = statement.getGeneratedKeys();
	        if(resultSet.next()) {
	            int cd_cliente = resultSet.getInt(1);
	            
	            model.addRow(new Object[]{cd_cliente, nome, sobrenome, telefone, email, senha});
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
	
	public static void atualizarCliente(int cd_cliente, int coluna, Object newValue) {
        try {
            Connection con = Conexao.getConnection();
            PreparedStatement statement = null;

            if(coluna == 1) {
                statement = con.prepareStatement("UPDATE tbl_cliente SET nome_cliente = ? WHERE cd_cliente = ?");
                statement.setString(1, (String) newValue);
                statement.setInt(2, cd_cliente);
            } else if(coluna == 2) {
                statement = con.prepareStatement("UPDATE tbl_cliente SET sobrenome_cliente = ? WHERE cd_cliente = ?");
                statement.setString(1, (String) newValue);
                statement.setInt(2, cd_cliente);
            } else if(coluna == 3) { 
                statement = con.prepareStatement("UPDATE tbl_cliente SET telefone_cliente = ? WHERE cd_cliente = ?");
                statement.setString(1, (String) newValue);
                statement.setInt(2, cd_cliente);
            } else if(coluna == 4) {
                statement = con.prepareStatement("UPDATE tbl_cliente SET email_cliente = ? WHERE cd_cliente = ?");
                statement.setString(1, (String) newValue);
                statement.setInt(2, cd_cliente);
            } else if(coluna == 5) {
                statement = con.prepareStatement("UPDATE tbl_cliente SET senha_cliente = ? WHERE cd_cliente = ?");
                statement.setString(1, (String) newValue);
                statement.setInt(2, cd_cliente);
            }

            if(statement != null) {
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}