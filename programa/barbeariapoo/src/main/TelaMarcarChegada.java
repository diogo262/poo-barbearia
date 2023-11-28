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

public class TelaMarcarChegada extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int cdCliente;
	
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
		this.cdCliente = cdCli;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 253, 233));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEntrarFila = new JButton("Sair da fila");
		btnEntrarFila.setBounds(379, 155, 148, 31);
		contentPane.add(btnEntrarFila);
		
        btnEntrarFila.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(285, 330, 114, 23);
		contentPane.add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	TelaCliente telaCliente = new TelaCliente(cdCliente);

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
		
		JTextPane txtpnH = new JTextPane();
		txtpnH.setText("Há um total de X pessoas na sua frente. Recomendamos que você entre na fila o quanto antes.");
		txtpnH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnH.setEditable(false);
		txtpnH.setBackground(new Color(255, 253, 233));
		txtpnH.setBounds(10, 43, 616, 20);
		contentPane.add(txtpnH);
		
		JButton btnEntrarFila_1 = new JButton("Entrar na Fila");
		btnEntrarFila_1.setBounds(166, 155, 148, 31);
		contentPane.add(btnEntrarFila_1);
	}
}
