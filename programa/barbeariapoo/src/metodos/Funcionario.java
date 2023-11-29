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
	            System.out.println("Rows affected: " + rowsAffected); 

	            // aqui remove
	            model.removeRow(selectedRow);
	            
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	}



}
