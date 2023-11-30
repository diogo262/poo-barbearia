package main;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;
import metodos.Conexao;
import metodos.Funcionario;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

public class TelaListarFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private int cdFuncionario;

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
	public TelaListarFuncionario(int cdFunc) {
		this.cdFuncionario = cdFunc;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 253, 233));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(284, 327, 114, 23);
		contentPane.add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	TelaFuncionario telaFuncionario = new TelaFuncionario(cdFuncionario);

                telaFuncionario.setVisible(true);
            	
            	dispose();
            }
        });
		
		DefaultTableModel model = new DefaultTableModel();

		// Adiciona colunas ao modelo de tabela
		model.addColumn("CdFuncionario");
		model.addColumn("Nome");
		model.addColumn("Sobrenome");
		model.addColumn("Telefone");
		model.addColumn("Email");
		model.addColumn("Senha");
		model.addColumn("Administrador");

		table = new JTable(model);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(31, 88, 632, 230);

		// Coloca a tabela dentro de um JScrollPane pra aparecer o nome de cada coluna, usei o Scroll pane pra poder rolar 
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(31, 88, 632, 230);
		contentPane.add(scrollPane);
		
		//excluir funcionario
		JButton btnDelFunc = new JButton("Excluir Funcionário");
		btnDelFunc.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int linhaSelecionada = table.getSelectedRow();
		        if(linhaSelecionada != -1) {
		            int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir este funcionário?", "Confirmação", JOptionPane.YES_NO_OPTION);
		            if(confirma == JOptionPane.YES_OPTION) {
		                DefaultTableModel model = (DefaultTableModel) table.getModel();
		                Funcionario.excluirFuncionario(model, linhaSelecionada);
		            }
		        }
		    }
		});

		btnDelFunc.setBounds(212, 43, 159, 29);
		contentPane.add(btnDelFunc);

		//inserir funcionario
		JButton btnAddFunc = new JButton("Adicionar Funcionário");
		btnAddFunc.addActionListener(e -> {
		    String nome = JOptionPane.showInputDialog("Digite o nome do funcionário:");
		    String sobrenome = JOptionPane.showInputDialog("Digite o sobrenome do funcionário:");
		    String telefone = JOptionPane.showInputDialog("Digite o telefone do funcionário:");
		    String email = JOptionPane.showInputDialog("Digite o email do funcionário:");
		    String senha = JOptionPane.showInputDialog("Digite a senha do funcionário:");
		    boolean adm = JOptionPane.showConfirmDialog(null, "O funcionário é um administrador?", "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
		    Funcionario.inserirFuncionario(model, nome, sobrenome, telefone, email, senha, adm);
		});
		btnAddFunc.setBounds(31, 43, 159, 29);
		contentPane.add(btnAddFunc);
		
		JButton btnSalv = new JButton("Salvar");
		btnSalv.setBounds(504, 43, 159, 29);
		contentPane.add(btnSalv);
		
		ArrayList<String[]> lista = Funcionario.listaFuncionario();

		for (String[] funcionario : lista) {
		    model.addRow(funcionario);
		}
	}
}
