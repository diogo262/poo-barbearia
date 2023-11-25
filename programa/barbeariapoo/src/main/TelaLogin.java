package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metodos.Conexao;
import metodos.Validacoes;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldEmailCpfCnpj;
	private JTextField textFieldSenha;
	
	private final String placeholderEmailCpfCnpj = "E-mail/CPF/CNPJ";
	private final String placeholderSenha = "Senha";
	
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
	public TelaLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 253, 233));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnBemvindo = new JTextPane();
		txtpnBemvindo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnBemvindo.setBackground(new Color(255, 253, 233));
		txtpnBemvindo.setEditable(false);
		txtpnBemvindo.setText("Olá, a fim de fazer um corte?");
		txtpnBemvindo.setBounds(10, 11, 213, 23);
		contentPane.add(txtpnBemvindo);
		
		textFieldEmailCpfCnpj = new JTextField();
		textFieldEmailCpfCnpj.setBounds(248, 120, 213, 37);
		contentPane.add(textFieldEmailCpfCnpj);
        textFieldEmailCpfCnpj.setText(placeholderEmailCpfCnpj);
        textFieldEmailCpfCnpj.setForeground(Color.GRAY);
        adicionarTextoDica(textFieldEmailCpfCnpj, placeholderEmailCpfCnpj);
        
        textFieldSenha = new JTextField();
        textFieldSenha.setText(placeholderSenha);
        textFieldSenha.setForeground(Color.GRAY);
        textFieldSenha.setBounds(248, 182, 213, 37);
        contentPane.add(textFieldSenha);

        // Adiciona o texto de dica e o FocusListener para o textFieldSobrenome
        adicionarTextoDica(textFieldSenha, placeholderSenha);
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(22, 327, 89, 23);
        contentPane.add(btnVoltar);
        
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
            	
                TelaInicial telaInicial = new TelaInicial();
                telaInicial.setVisible(true);
            }
        });
        
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		boolean loginBemSucedido = false;
        		boolean entradaValida = false;
        		boolean loginFuncionario = false;
        		boolean loginCliente = false;
        		
        		
        		String emailCpfCnpj = textFieldEmailCpfCnpj.getText();
                String senha = textFieldSenha.getText();
        		
        		Validacoes.validaTextField(textFieldEmailCpfCnpj.getText(), placeholderEmailCpfCnpj, entradaValida);
        		
        		Validacoes.validaTextField(textFieldSenha.getText(), placeholderSenha, entradaValida);
    			
        		
        		//valida login do funcionario
        		if (Conexao.validarLoginFuncionario(emailCpfCnpj, senha) && loginFuncionario==false) {
        			loginFuncionario = true;
        			loginBemSucedido = true;
					TelaFuncionario telaFuncionario = new TelaFuncionario();

	                telaFuncionario.setVisible(true);

	                dispose();
					
				}
        		
        		//valida login do cliente
        		if (Conexao.validarLoginCliente(emailCpfCnpj, senha) && loginCliente==false) {
        			loginCliente = true;
        			loginBemSucedido = true;
					TelaCliente telaCliente = new TelaCliente();

	                telaCliente.setVisible(true);

	                dispose();
					
				}
        		
        		if (!loginBemSucedido) {
        		    JOptionPane.showMessageDialog(null, "Usuário não encontrado ou senha incorreta", "Erro", JOptionPane.ERROR_MESSAGE);
        		}
        		
        		
    			if (entradaValida) {
    				
    				
    				// valida os dados de entrada
    				// se true, então ->  procura no banco pelo login
    				// caso contrário -> erro
    				
    				
    			}
        			
        	}
        });
        btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnLogin.setBounds(296, 256, 114, 25);
        contentPane.add(btnLogin);
    }

    // Método para adicionar o texto de dica e o FocusListener a um JTextField
    private void adicionarTextoDica(JTextField textField, String textoDica) {
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(textoDica)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(textoDica);
                    textField.setForeground(Color.GRAY);
                }
            }
        });
	}
}
