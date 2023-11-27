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

    public static boolean validarLoginFuncionario(String emailCpfCnpj, String senha) {
        Connection connection = getConnection();

        try {
            String query = "SELECT * FROM tbl_funcionario WHERE email_funcionario = '" + emailCpfCnpj + "' AND senha_funcionario = '" + senha + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao validar o login.", e);
        }
    }
    
    public static boolean validarLoginCliente(String emailCpfCnpj, String senha) {
        Connection connection = getConnection();

        try {
            String query = "SELECT * FROM tbl_cliente WHERE email_cliente = '" + emailCpfCnpj + "' AND senha_cliente = '" + senha + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao validar o login.", e);
        }
    }
    
    public static boolean cadastrarCliente(String nome, String sobrenome, String telefone, String email, String senha) {
        Connection connection = getConnection();

        try {
            String query = "INSERT INTO tbl_cliente VALUES ( DEFAULT, '" + nome + "', '" + sobrenome + "', '" + telefone + "', '" + email + "', '" + senha + "');";
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(query);

            return result > 0; //true se pelo menos uma linha for afetada
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar usuario.", e);
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
