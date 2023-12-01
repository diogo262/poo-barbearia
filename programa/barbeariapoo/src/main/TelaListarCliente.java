package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import metodos.Cliente;
import metodos.Funcionario;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextPane;

public class TelaListarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaListarCliente(int cdFunc) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 253, 233));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(281, 327, 114, 23);
		contentPane.add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	TelaFuncionario telaFuncionario = new TelaFuncionario(cdFunc);

                telaFuncionario.setVisible(true);
            	
            	dispose();
            }
        });
		
		JTextPane txtpnOQueVoc = new JTextPane();
		txtpnOQueVoc.setBackground(new Color(255, 253, 233));
		txtpnOQueVoc.setEditable(false);
		txtpnOQueVoc.setText("Clientes Cadastrados");
		txtpnOQueVoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnOQueVoc.setBounds(10, 11, 229, 20);
		contentPane.add(txtpnOQueVoc);
		
		DefaultTableModel model = new DefaultTableModel();

		// Adiciona colunas ao modelo de tabela
		model.addColumn("CdCliente");
		model.addColumn("Nome");
		model.addColumn("Sobrenome");
		model.addColumn("Telefone");
		model.addColumn("Email");
		model.addColumn("Senha");

		table = new JTable(model);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(31, 88, 632, 230);

		// Coloca a tabela dentro de um JScrollPane pra aparecer o nome de cada coluna, usei o Scroll pane pra poder rolar 
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(31, 88, 632, 230);
		contentPane.add(scrollPane);
		
		//excluir cliente
		JButton btnDelCli = new JButton("Excluir Cliente");
		btnDelCli.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int linhaSelecionada = table.getSelectedRow();
		        if(linhaSelecionada != -1) {
		            int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir este Cliente?", "Confirmação", JOptionPane.YES_NO_OPTION);
		            if(confirma == JOptionPane.YES_OPTION) {
		                DefaultTableModel model = (DefaultTableModel) table.getModel();
		                Cliente.excluirCliente(model, linhaSelecionada);
		            }
		        }
		    }
		});

		btnDelCli.setBounds(212, 43, 159, 29);
		contentPane.add(btnDelCli);

		//inserir cliente
		JButton btnAddCli = new JButton("Adicionar cliente");
		btnAddCli.addActionListener(e -> {
		    String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
		    String sobrenome = JOptionPane.showInputDialog("Digite o sobrenome do cliente:");
		    String telefone = JOptionPane.showInputDialog("Digite o telefone do cliente:");
		    String email = JOptionPane.showInputDialog("Digite o email do cliente:");
		    String senha = JOptionPane.showInputDialog("Digite a senha do cliente:");
		    Cliente.inserirCliente(model, nome, sobrenome, telefone, email, senha);
		});
		btnAddCli.setBounds(31, 43, 159, 29);
		contentPane.add(btnAddCli);
		
		//atualizar cliente
				model.addTableModelListener(new TableModelListener() {
					public void tableChanged(TableModelEvent e) {
						if(e.getType() == TableModelEvent.UPDATE) {
							int linha = e.getFirstRow();
						    int coluna = e.getColumn();
						    Object newValue = model.getValueAt(linha, coluna); // Recupera a linha e coluna
						    int cd_cliente = Integer.parseInt((String) model.getValueAt(linha, 0)); // Pega o cd_cliente da linha editada
						    Cliente.atualizarCliente(cd_cliente, coluna, newValue);
						 }
					}
				});
				
		ArrayList<String[]> lista = Cliente.listaCliente();

		for (String[] cliente : lista) {
		    model.addRow(cliente);
		}
		
	}
}
