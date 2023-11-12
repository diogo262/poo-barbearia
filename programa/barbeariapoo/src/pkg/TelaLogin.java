package pkg;

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

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldEmailCpfCnpj;
	private JTextField textFieldSenha;

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
        textFieldEmailCpfCnpj.setText("E-mail/CPF/CNPJ");
        textFieldEmailCpfCnpj.setForeground(Color.GRAY);
        adicionarTextoDica(textFieldEmailCpfCnpj, "E-mail/CPF/CNPJ");
        
        textFieldSenha = new JTextField();
        textFieldSenha.setText("Senha");
        textFieldSenha.setForeground(Color.GRAY);
        textFieldSenha.setBounds(248, 182, 213, 37);
        contentPane.add(textFieldSenha);

        // Adiciona o texto de dica e o FocusListener para o textFieldSobrenome
        adicionarTextoDica(textFieldSenha, "Senha");
        
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
