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
import metodos.Cliente;
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

		ocultaBotao(btnAtendimentoConcluido);
		
		JButton btnAtender = new JButton("Atender");
		btnAtender.setBounds(31, 47, 148, 31);
		contentPane.add(btnAtender);
		
		ocultaBotao(btnAtender);
		
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
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(31, 88, 632, 230);
		contentPane.add(scrollPane);
		
		atualizaTabela(model, FilaM.listarPedidosFila());
		
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
		
		JButton btnSelecionarCliente = new JButton("Selecionar cliente");
		btnSelecionarCliente.setBounds(31, 47, 148, 31);
		contentPane.add(btnSelecionarCliente);
		
		btnSelecionarCliente.setEnabled(true);
		btnSelecionarCliente.setVisible(true);
		
		comboBoxStatusPedido.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int statusSelecionado = comboBoxStatusPedido.getSelectedIndex();
				model.setRowCount(0);
				if (statusSelecionado > 0) {
					if (statusSelecionado == 1) { // aguardando atendimento
						ocultaBotao(btnAtendimentoConcluido);
						ocultaBotao(btnSelecionarCliente);
						atualizaTabela(model, FilaM.listarPedidosPorFuncionarioEStatus(cdFunc, 2));
						btnCancelarAtendimento.setEnabled(true);
						expoeBotao(btnAtender);
					} else if (statusSelecionado == 2) { // em atendimento
						ocultaBotao(btnAtender);
						ocultaBotao(btnSelecionarCliente);
						atualizaTabela(model, FilaM.listarPedidosPorFuncionarioEStatus(cdFunc, 3));
						expoeBotao(btnAtendimentoConcluido);
						btnCancelarAtendimento.setEnabled(true);
					} else if (statusSelecionado == 3) { // finalizado
						ocultaBotao(btnAtender);
						ocultaBotao(btnSelecionarCliente);
						ocultaBotao(btnAtendimentoConcluido);
						atualizaTabela(model, FilaM.listarPedidosPorFuncionarioEStatus(cdFunc, 4));
					} else if (statusSelecionado == 4) { // cancelado
						ocultaBotao(btnAtender);
						ocultaBotao(btnSelecionarCliente);
						ocultaBotao(btnAtendimentoConcluido);
						btnCancelarAtendimento.setEnabled(false);
						atualizaTabela(model, FilaM.listarPedidosPorFuncionarioEStatus(cdFunc, 5));
					}
				} else { // na fila
					ocultaBotao(btnAtender);
					ocultaBotao(btnAtendimentoConcluido);
					btnCancelarAtendimento.setEnabled(true);
					atualizaTabela(model, FilaM.listarPedidosFila());
					expoeBotao(btnSelecionarCliente);
				}
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
		
        btnAtendimentoConcluido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int linhaSelecionada = table.getSelectedRow();
            	if (linhaSelecionada != -1) {
                	int cdPedido = Integer.parseInt(table.getValueAt(linhaSelecionada, 0).toString());
                	
                	boolean atendimentoFinalizado = FilaM.atendimentoConcluido(cdPedido);
                	
                	if (atendimentoFinalizado) {
        				model.setRowCount(0);
    					atualizaTabela(model, FilaM.listarPedidosPorFuncionarioEStatus(cdFunc, 3));

                		FilaM.chamaDialogAviso("Atendimento finalizado!", "Mandou bem!");
                	} else 
                		FilaM.chamaDialogErro("Ops, ocorreu algum erro interno...", "Erro inesperado!");	
            	}
            }
        });
		
		btnAtender.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = table.getSelectedRow();
            	if (linhaSelecionada != -1) {
                	int cdPedido = Integer.parseInt(table.getValueAt(linhaSelecionada, 0).toString());
                	
                	boolean atender = FilaM.atenderPedido(cdPedido);
                	
                	if (atender) {
        				model.setRowCount(0);
    					atualizaTabela(model, FilaM.listarPedidosPorFuncionarioEStatus(cdFunc, 2));

                		FilaM.chamaDialogAviso("Mais um para a conta!", "Boa! Bora pra cima!");
                	} else 
                		FilaM.chamaDialogErro("Ops, ocorreu algum erro interno...", "Erro inesperado!");	
            	}
			}
		});
		
		btnSelecionarCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = table.getSelectedRow();
            	if (linhaSelecionada != -1) {
                	int cdPedido = Integer.parseInt(table.getValueAt(linhaSelecionada, 0).toString());
                	
                	boolean aguardandoAtendimento = FilaM.pedidoAguardandoAtendimento(cdPedido);
                	
                	if (aguardandoAtendimento) {
        				model.setRowCount(0);
    					atualizaTabela(model, FilaM.listarPedidosFila());

                		FilaM.chamaDialogAviso("Agora você será responsável por esse atendimento.", "Boa! Bora pra cima!");
                	} else 
                		FilaM.chamaDialogErro("Ops, ocorreu algum erro interno...", "Erro inesperado!");
            	}
			}
		});
		
		btnCancelarAtendimento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = table.getSelectedRow();
            	if (linhaSelecionada != -1) {
                	int cdPedido = Integer.parseInt(table.getValueAt(linhaSelecionada, 0).toString());
                	
                	boolean aguardandoAtendimento = FilaM.cancelarPedido(cdPedido);
                	
                	if (aguardandoAtendimento) {
        				model.setRowCount(0);
    					atualizaTabela(model, FilaM.listarPedidosFila());

                		FilaM.chamaDialogAviso("Agora você será responsável por esse atendimento.", "Boa! Bora pra cima!");
                	} else 
                		FilaM.chamaDialogErro("Ops, ocorreu algum erro interno...", "Erro inesperado!");
            	}
			}
		});
	}
	
	private static void atualizaTabela(DefaultTableModel model, ArrayList<String[]> lista) {
		for (String[] fila: lista) {
			model.addRow(fila);
		}
	}
	
	private static void ocultaBotao(JButton button) 
	{
		button.setVisible(false);
		button.setEnabled(false);
	}
	
	private static void expoeBotao(JButton button) 
	{
		button.setEnabled(true);
		button.setVisible(true);
	}
}
