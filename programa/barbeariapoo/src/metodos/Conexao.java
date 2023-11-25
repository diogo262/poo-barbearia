package metodos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
}
