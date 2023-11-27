package main;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.JTable;
import metodos.Conexao;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class TelaListarFuncionario extends JFrame {

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
	public TelaListarFuncionario() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 253, 233));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddFunc = new JButton("Adicionar Funcionário");
		btnAddFunc.setBounds(31, 42, 148, 31);
		contentPane.add(btnAddFunc);
		
        btnAddFunc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(284, 327, 114, 23);
		contentPane.add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            	TelaFuncionario telaFuncionario = new TelaFuncionario();

                telaFuncionario.setVisible(true);
            	
            	dispose();
            	
            }
        });
		
		DefaultTableModel model = new DefaultTableModel();

		// Colunas
		model.addColumn("Nome");
		model.addColumn("Sobrenome");
		model.addColumn("Telefone");
		model.addColumn("Email");
		model.addColumn("Senha");
		model.addColumn("Administrador");

		table = new JTable(model);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(31, 88, 632, 230);

		// Cria um JPanel e adiciona a tabela a ele pra aparecer os nomes das colunas
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(table.getTableHeader(), BorderLayout.PAGE_START);
		panel.add(table, BorderLayout.CENTER);
		panel.setBounds(31, 88, 632, 230);
		contentPane.add(panel);

		ArrayList<String[]> lista = Conexao.listaFuncionario();

		for (String[] funcionario : lista) {
		    model.addRow(funcionario);
		}
		
	}
}
