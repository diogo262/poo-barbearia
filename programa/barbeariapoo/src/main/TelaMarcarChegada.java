package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metodos.Cliente;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextPane;

public class TelaMarcarChegada extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
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
	public TelaMarcarChegada(int cdCli) {	
				
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 253, 233));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEntrarFila = new JButton("Entrar na Fila");
		btnEntrarFila.setBounds(166, 155, 148, 31);
		contentPane.add(btnEntrarFila);
		
		boolean clienteNaFila = Cliente.verificaSeClienteEstaNaFila(cdCli) > 0 ? true : false; // verifica se cliente esta na fila e se estiver receb true do caso contrario...
		
		JButton btnSairFila = new JButton("Sair da fila");
		btnSairFila.setBounds(379, 155, 148, 31);
		contentPane.add(btnSairFila);
		
		if (clienteNaFila) {
			btnEntrarFila.setEnabled(false);
			btnSairFila.setEnabled(true);
		} else
			btnSairFila.setEnabled(false);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(285, 330, 114, 23);
		contentPane.add(btnVoltar);
		
        btnSairFila.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
            	int cdPedido = Cliente.verificaSeClienteEstaNaFila(cdCli);
            	boolean saiuDaFila = Cliente.sairDaFila(cdPedido);
            	            	
            	if (saiuDaFila) {
            		btnSairFila.setEnabled(false);
                	btnEntrarFila.setEnabled(true);
            		Cliente.chamaDialogAviso("Você saiu da fila.", "Esperamos te ver novamente...");
            	} else 
            		Cliente.chamaDialogErro("Ops, ocorreu algum erro interno...", "Erro inesperado!");
            }
        });
        
        btnEntrarFila.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean entrouNaFila = Cliente.entrarNaFila(cdCli);
				            				
            	if (entrouNaFila) {
                	btnEntrarFila.setEnabled(false);
                	btnSairFila.setEnabled(true);
            		Cliente.chamaDialogAviso("Você acabou de entrar na fila.", "É bom te ver por aqui!");
            	} else 
            		Cliente.chamaDialogErro("Ops, ocorreu algum erro interno...", "Erro inesperado!");
			}
		});
		
		btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	TelaCliente telaCliente = new TelaCliente(cdCli);

                telaCliente.setVisible(true);
            	
            	dispose();
            }
        });
		
		JTextPane txtpnOQueVoc = new JTextPane();
		txtpnOQueVoc.setBackground(new Color(255, 253, 233));
		txtpnOQueVoc.setEditable(false);
		txtpnOQueVoc.setText("Marcar Chegada");
		txtpnOQueVoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnOQueVoc.setBounds(10, 11, 229, 20);
		contentPane.add(txtpnOQueVoc);
		
		int clientesNaFrente = Cliente.consultaClientesNaFrente(cdCli);
		
		JTextPane txtpnH = new JTextPane();
		txtpnH.setText(String.format("Há um total de %d pessoas na sua frente. Recomendamos que você entre na fila o quanto antes.", clientesNaFrente));
		txtpnH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnH.setEditable(false);
		txtpnH.setBackground(new Color(255, 253, 233));
		txtpnH.setBounds(10, 43, 616, 20);
		contentPane.add(txtpnH);		
	}
}
