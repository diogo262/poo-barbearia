package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class TelaCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldSobrenome;
	private JTextField textFieldEmail;
	private JTextField textFieldSenha;
	private JTextField textFieldCpfCnpj;
	private JTextField textFieldTelefone;

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
	public TelaCadastro() {
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
		txtpnBemvindo.setText("Bem vindo (a)! Vamos começar?");
		txtpnBemvindo.setBounds(10, 11, 213, 23);
		contentPane.add(txtpnBemvindo);
		
		
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(105, 91, 213, 37);
		contentPane.add(textFieldNome);
        textFieldNome.setText("Nome");
        textFieldNome.setForeground(Color.GRAY);
        adicionarTextoDica(textFieldNome, "Nome");
        
        textFieldSobrenome = new JTextField();
        textFieldSobrenome.setText("Sobrenome");
        textFieldSobrenome.setForeground(Color.GRAY);
        textFieldSobrenome.setBounds(377, 91, 213, 37);
        contentPane.add(textFieldSobrenome);

        // Adiciona o texto de dica e o FocusListener para o textFieldSobrenome
        adicionarTextoDica(textFieldSobrenome, "Sobrenome");

        textFieldEmail = new JTextField();
        textFieldEmail.setText("E-mail");
        textFieldEmail.setForeground(Color.GRAY);
        textFieldEmail.setBounds(105, 150, 213, 37);
        contentPane.add(textFieldEmail);

        // Adiciona o texto de dica e o FocusListener para o textFieldEmail
        adicionarTextoDica(textFieldEmail, "E-mail");

        textFieldSenha = new JTextField();
        textFieldSenha.setText("Senha");
        textFieldSenha.setForeground(Color.GRAY);
        textFieldSenha.setBounds(377, 150, 213, 37);
        contentPane.add(textFieldSenha);

        // Adiciona o texto de dica e o FocusListener para o textFieldSenha
        adicionarTextoDica(textFieldSenha, "Senha");

        textFieldCpfCnpj = new JTextField();
        textFieldCpfCnpj.setText("CPF/CNPJ");
        textFieldCpfCnpj.setForeground(Color.GRAY);
        textFieldCpfCnpj.setBounds(105, 207, 213, 37);
        contentPane.add(textFieldCpfCnpj);

        // Adiciona o texto de dica e o FocusListener para o textFieldCpfCnpj
        adicionarTextoDica(textFieldCpfCnpj, "CPF/CNPJ");

        textFieldTelefone = new JTextField();
        textFieldTelefone.setText("Telefone");
        textFieldTelefone.setForeground(Color.GRAY);
        textFieldTelefone.setBounds(377, 207, 213, 37);
        contentPane.add(textFieldTelefone);

        // Adiciona o texto de dica e o FocusListener para o textFieldTelefone
        adicionarTextoDica(textFieldTelefone, "Telefone");
        
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
        
        
        JButton btnSubmit = new JButton("Cadastrar-se");
        btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnSubmit.setBounds(289, 270, 114, 25);
        contentPane.add(btnSubmit);
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
