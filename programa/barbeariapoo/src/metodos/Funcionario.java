package metodos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class Funcionario {

	public static ArrayList<String[]> listaFuncionario() {
        ArrayList<String[]> lista = new ArrayList<String[]>();
        Connection connection = Conexao.getConnection();

        try {
            String query = "SELECT * FROM tbl_funcionario";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String[] funcionario = new String[7];
                funcionario[0] = resultSet.getString("cd_funcionario");
                funcionario[1] = resultSet.getString("nome_funcionario");
                funcionario[2] = resultSet.getString("sobrenome_funcionario");
                funcionario[3] = resultSet.getString("telefone_funcionario");
                funcionario[4] = resultSet.getString("email_funcionario");
                funcionario[5] = resultSet.getString("senha_funcionario");
                funcionario[6] = resultSet.getBoolean("adm_funcionario") ? "Sim" : "Não";

                lista.add(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
	
	public static void excluirFuncionario(DefaultTableModel model, int selectedRow) {
	    if(selectedRow != -1) {
	        String cdFuncionario = model.getValueAt(selectedRow, 0).toString();

	        try {
	            Connection connection = Conexao.getConnection();
	            String sql = "DELETE FROM tbl_funcionario WHERE cd_funcionario = ?";
	            PreparedStatement statement = connection.prepareStatement(sql);
	            statement.setString(1, cdFuncionario);
	            int rowsAffected = statement.executeUpdate();

	            // aqui remove
	            model.removeRow(selectedRow);
	            
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	}
	
	public static void inserirFuncionario(DefaultTableModel model, String nome, String sobrenome, String telefone, String email, String senha, boolean adm) {
	    try {
	        Connection con = Conexao.getConnection();
	        PreparedStatement statement = con.prepareStatement("INSERT INTO tbl_funcionario (nome_funcionario, sobrenome_funcionario, telefone_funcionario, email_funcionario, senha_funcionario, adm_funcionario) VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
	        statement.setString(1, nome);
	        statement.setString(2, sobrenome);
	        statement.setString(3, telefone);
	        statement.setString(4, email);
	        statement.setString(5, senha);
	        statement.setBoolean(6, adm);
	        statement.executeUpdate();

	        ResultSet resultSet = statement.getGeneratedKeys();
	        if(resultSet.next()) {
	            int cd_funcionario = resultSet.getInt(1);
	            
	            model.addRow(new Object[]{cd_funcionario, nome, sobrenome, telefone, email, senha, adm});
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
	
	public static void atualizarFuncionario(int cd_funcionario, int coluna, Object newValue) {
        try {
            Connection con = Conexao.getConnection();
            PreparedStatement statement = null;

            if(coluna == 1) {
                statement = con.prepareStatement("UPDATE tbl_funcionario SET nome_funcionario = ? WHERE cd_funcionario = ?");
                statement.setString(1, (String) newValue);
                statement.setInt(2, cd_funcionario);
            } else if(coluna == 2) {
                statement = con.prepareStatement("UPDATE tbl_funcionario SET sobrenome_funcionario = ? WHERE cd_funcionario = ?");
                statement.setString(1, (String) newValue);
                statement.setInt(2, cd_funcionario);
            } else if(coluna == 3) { 
                statement = con.prepareStatement("UPDATE tbl_funcionario SET telefone_funcionario = ? WHERE cd_funcionario = ?");
                statement.setString(1, (String) newValue);
                statement.setInt(2, cd_funcionario);
            } else if(coluna == 4) {
                statement = con.prepareStatement("UPDATE tbl_funcionario SET email_funcionario = ? WHERE cd_funcionario = ?");
                statement.setString(1, (String) newValue);
                statement.setInt(2, cd_funcionario);
            } else if(coluna == 5) {
                statement = con.prepareStatement("UPDATE tbl_funcionario SET senha_funcionario = ? WHERE cd_funcionario = ?");
                statement.setString(1, (String) newValue);
                statement.setInt(2, cd_funcionario);
            } else if(coluna == 6) {
                statement = con.prepareStatement("UPDATE tbl_funcionario SET adm_funcionario = ? WHERE cd_funcionario = ?");
                statement.setBoolean(1, (Boolean) newValue);
                statement.setInt(2, cd_funcionario);
            }

            if(statement != null) {
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
