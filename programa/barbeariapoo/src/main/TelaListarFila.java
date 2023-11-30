package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import domain.FuncionarioFisico;
import domain.FuncionarioJuridico;
import domain.FilaD;
import metodos.FilaM;
import metodos.Funcionario;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaListarFila extends JFrame {

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
	public TelaListarFila(int cdFunc) {		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 253, 233));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] statusPedidos = {"Na fila", "Aguardando atendimento", "Em atendimento", "Finalizado", "Cancelado"};
		
		JComboBox comboBoxStatusPedido = new JComboBox();
		comboBoxStatusPedido.setModel(new DefaultComboBoxModel(statusPedidos));
		comboBoxStatusPedido.setBounds(515, 16, 148, 21);
		contentPane.add(comboBoxStatusPedido);
		
		JButton btnAtendimentoConcluido = new JButton("Atendimento Concluído");
		btnAtendimentoConcluido.setBounds(31, 47, 148, 31);
		contentPane.add(btnAtendimentoConcluido);
		
        btnAtendimentoConcluido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                	
            }
        });
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(289, 330, 114, 23);
		contentPane.add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	TelaFuncionario telaFuncionario = new TelaFuncionario(cdFunc);

                telaFuncionario.setVisible(true);
            	
            	dispose();
            }
        });

		DefaultTableModel model = new DefaultTableModel();

		//Adiciona colunas ao modelo de tabela
		model.addColumn("Pedido");
		model.addColumn("Cd Cliente");
		model.addColumn("Cd Status");
		model.addColumn("Status");
		model.addColumn("Hora chegada");
		model.addColumn("Data chegada");
		model.addColumn("Cliente");
		model.addColumn("Sobrenome Cliente");
		model.addColumn("Telefone Cliente");
		model.addColumn("Email Cliente");
		model.addColumn("CPF/CNPJ");
				
		table = new JTable(model);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(31, 88, 632, 230);
		table.setLayout(null);
				
		for (String[] fila: FilaM.listarPedidosFila()) {
			model.addRow(fila);
		}
				
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(31, 88, 632, 230);
		contentPane.add(scrollPane);
		
		JTextPane txtpnOQueVoc = new JTextPane();
		txtpnOQueVoc.setBackground(new Color(255, 253, 233));
		txtpnOQueVoc.setEditable(false);
		txtpnOQueVoc.setText("Clientes aguardando atendimento");
		txtpnOQueVoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnOQueVoc.setBounds(10, 11, 229, 20);
		contentPane.add(txtpnOQueVoc);
		
		JButton btnCancelarAtendimento = new JButton("Cancelar Atendimento");
		btnCancelarAtendimento.setBounds(515, 47, 148, 31);
		contentPane.add(btnCancelarAtendimento);
		
		comboBoxStatusPedido.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int statusSelecionado = comboBoxStatusPedido.getSelectedIndex();
				model.setRowCount(0);
				if (statusSelecionado > 0) {
					if (statusSelecionado == 1)
						atualizaTabela(model, FilaM.listarPedidosPorFuncionarioEStatus(cdFunc, 2));
					else if (statusSelecionado == 2)
						atualizaTabela(model, FilaM.listarPedidosPorFuncionarioEStatus(cdFunc, 3));
					else if (statusSelecionado == 3)
						atualizaTabela(model, FilaM.listarPedidosPorFuncionarioEStatus(cdFunc, 4));
					else if (statusSelecionado == 4) 
						atualizaTabela(model, FilaM.listarPedidosPorFuncionarioEStatus(cdFunc, 5));
					
				} else 
					atualizaTabela(model, FilaM.listarPedidosFila());
			}
		});
	}
	
	private static void atualizaTabela(DefaultTableModel model, ArrayList<String[]> lista) {
		for (String[] fila: lista) {
			model.addRow(fila);
		}
	}
}
