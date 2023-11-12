package pkg;

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

public class TelaEscolherServico extends JFrame {

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
	public TelaEscolherServico() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 253, 233));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddUnidade = new JButton("Adicionar Unidade");
		btnAddUnidade.setBounds(53, 306, 148, 31);
		contentPane.add(btnAddUnidade);
		
        btnAddUnidade.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(477, 306, 133, 31);
		contentPane.add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            	TelaCliente telaCliente = new TelaCliente();

                telaCliente.setVisible(true);
            	
            	dispose();
            	
            }
        });
		
		JTextPane txtpnOQueVoc = new JTextPane();
		txtpnOQueVoc.setBackground(new Color(255, 253, 233));
		txtpnOQueVoc.setEditable(false);
		txtpnOQueVoc.setText("Marcar Chegada: Serviços");
		txtpnOQueVoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnOQueVoc.setBounds(10, 11, 229, 20);
		contentPane.add(txtpnOQueVoc);
		
		JButton btnRemoverUnidade = new JButton("Remover Unidade");
		btnRemoverUnidade.setBounds(269, 306, 148, 31);
		contentPane.add(btnRemoverUnidade);
	}
}
