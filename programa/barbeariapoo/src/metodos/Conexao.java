package metodos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;

public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3306/db_barbearia";
    private static final String user = "root";
    private static final String senha = "";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, senha);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Erro na conexão com o Banco de Dados.", e);
        }
    }
    
    public static ArrayList<String[]> listaFuncionario() {
        ArrayList<String[]> lista = new ArrayList<String[]>();
        Connection connection = getConnection();

        try {
            String query = "SELECT * FROM tbl_funcionario";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String[] funcionario = new String[6];
                funcionario[0] = resultSet.getString("nome_funcionario");
                funcionario[1] = resultSet.getString("sobrenome_funcionario");
                funcionario[2] = resultSet.getString("telefone_funcionario");
                funcionario[3] = resultSet.getString("email_funcionario");
                funcionario[4] = resultSet.getString("senha_funcionario");
                funcionario[5] = resultSet.getBoolean("adm_funcionario") ? "Sim" : "Não";

                lista.add(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    
    
}
