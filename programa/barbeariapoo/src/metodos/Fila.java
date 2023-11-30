package metodos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.*;

public class Fila {
	public static List<Pedido<?, ?>> listarFila() {
		Connection connection = Conexao.getConnection();
		try {
			String query = "SELECT * FROM vw_consultaInformacoesPedido;";
			
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            List<Pedido<?, ?>> pedidos = new ArrayList<Pedido<?,?>>();
            while (resultSet.next()) {
            	if (resultSet.getString(12).length() == 14) {
                	System.out.println("Tem resultado!");
            		ClienteJuridico cliente = new ClienteJuridico();
            		setInformacoesPadraoCliente(resultSet, cliente);
            		cliente.setCnpjCliente(resultSet.getString(12));
            		
            		if (resultSet.getString(19).length() == 14) {
                		FuncionarioJuridico funcionario = new FuncionarioJuridico();
                		setInformacoesPadraoFuncionario(resultSet, funcionario);
                		funcionario.setCnpjFuncionario(resultSet.getString(18));
                		
                		Pedido<FuncionarioJuridico, ClienteJuridico> ped = new Pedido<FuncionarioJuridico, ClienteJuridico>();
                		
                		ped.setCliente(cliente);
                		ped.setFuncionario(funcionario);
                		
                		pedidos.add(ped);
                	} else if (resultSet.getString(19).length() == 11) {
                		FuncionarioFisico funcionario = new FuncionarioFisico();
                		setInformacoesPadraoFuncionario(resultSet, funcionario);
                		funcionario.setCpfFuncionario(resultSet.getString(18));
                		
                		Pedido<FuncionarioFisico, ClienteJuridico> ped = new Pedido<FuncionarioFisico, ClienteJuridico>();
                		
                		ped.setCliente(cliente);
                		ped.setFuncionario(funcionario);
                		
                		pedidos.add(ped);
                	}
            	} else if (resultSet.getString(12).length() == 11) {            		
            		ClienteFisico cliente = new ClienteFisico();
            		setInformacoesPadraoCliente(resultSet, cliente);
            		cliente.setCpfCliente(resultSet.getString(12));
            		
            		if (resultSet.getString(19).length() == 14) {
                		FuncionarioJuridico funcionario = new FuncionarioJuridico();
                		setInformacoesPadraoFuncionario(resultSet, funcionario);
                		funcionario.setCnpjFuncionario(resultSet.getString(19));
                		
                		Pedido<FuncionarioJuridico, ClienteFisico> ped = new Pedido<FuncionarioJuridico, ClienteFisico>();
                		
                		ped.setCliente(cliente);
                		ped.setFuncionario(funcionario);
                		
                		pedidos.add(ped);
                	} else if (resultSet.getString(19).length() == 11) {
                		FuncionarioFisico funcionario = new FuncionarioFisico();
                		setInformacoesPadraoFuncionario(resultSet, funcionario);
                		funcionario.setCpfFuncionario(resultSet.getString(19));
                		
                		Pedido<FuncionarioFisico, ClienteFisico> ped = new Pedido<FuncionarioFisico, ClienteFisico>();
                		
                		ped.setCliente(cliente);
                		ped.setFuncionario(funcionario);
                		
                		pedidos.add(ped);
                	}
            	}
            }
            return pedidos;
  		} catch (SQLException e) {
			throw new RuntimeException("Erro ao realizar consulta.", e);
		}
    }
	
	private static domain.Funcionario setInformacoesPadraoFuncionario(ResultSet resultSet, domain.Funcionario funcionario) throws SQLException {
		funcionario.setCdFuncionario(resultSet.getInt(3));
		funcionario.setNomeFuncionario(resultSet.getString(12));
		funcionario.setSobrenomeFuncionario(resultSet.getString(13));
		funcionario.setTelefoneFuncionario(resultSet.getString(14));
		funcionario.setEmailFuncionario(resultSet.getString(15));
		funcionario.setSenhaFuncionario(resultSet.getString(16));
		funcionario.setAdmFuncionario(resultSet.getBoolean(17));
		
		return funcionario;
	}
	
	private static domain.Cliente setInformacoesPadraoCliente(ResultSet resultSet, domain.Cliente cliente) throws SQLException {
		cliente.setCdCliente(resultSet.getInt(2));
		cliente.setNomeCliente(resultSet.getString(7));
		cliente.setSobrenomeCliente(resultSet.getString(8));
		cliente.setTelefoneCliente(resultSet.getString(9));
		cliente.setEmailCliente(resultSet.getString(10));
		cliente.setSenhaCliente(resultSet.getString(11));
		
		return cliente;
	}
}
