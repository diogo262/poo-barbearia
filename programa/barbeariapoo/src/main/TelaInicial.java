package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextPane;

public class TelaInicial extends JFrame {

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
	public TelaInicial() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 253, 233));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastro = new JButton("Cadastrar-se");
		btnCadastro.setBounds(274, 96, 148, 31);
		contentPane.add(btnCadastro);
		
        btnCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaCadastro telaCadastro = new TelaCadastro();

                telaCadastro.setVisible(true);

                dispose();
            }
        });
		
		
		JButton btnLogin = new JButton("Iniciar Sessão");
		btnLogin.setBounds(274, 147, 148, 31);
		contentPane.add(btnLogin);
		
		btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaLogin telaLogin = new TelaLogin();

                telaLogin.setVisible(true);

                dispose();
            }
        });
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(294, 210, 114, 23);
		contentPane.add(btnSair);
		
		btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            	dispose();
            	
            }
        });
		
		JTextPane txtpnOQueVoc = new JTextPane();
		txtpnOQueVoc.setBackground(new Color(255, 253, 233));
		txtpnOQueVoc.setEditable(false);
		txtpnOQueVoc.setText("O que você gostaria de fazer?");
		txtpnOQueVoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnOQueVoc.setBounds(256, 44, 189, 20);
		contentPane.add(txtpnOQueVoc);
		
		JButton btnCliente = new JButton("Teste tela cliente");
		btnCliente.setBounds(235, 327, 178, 23);
		contentPane.add(btnCliente);
		
		btnCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaCliente telaCliente = new TelaCliente();

                telaCliente.setVisible(true);

                dispose();
            }
        });
		
		
		JButton btnFuncionario = new JButton("Teste tela funcionario");
		btnFuncionario.setBounds(35, 327, 178, 23);
		contentPane.add(btnFuncionario);
		
		btnFuncionario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaFuncionario telaFuncionario = new TelaFuncionario();

                telaFuncionario.setVisible(true);

                dispose();
            }
        });
		
	}
}
