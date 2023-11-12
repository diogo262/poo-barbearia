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

public class TelaListarFila extends JFrame {

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
	public TelaListarFila() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 253, 233));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtendimentoConcluido = new JButton("Atendimento Concluído");
		btnAtendimentoConcluido.setBounds(31, 42, 148, 31);
		contentPane.add(btnAtendimentoConcluido);
		
        btnAtendimentoConcluido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(281, 310, 114, 23);
		contentPane.add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            	dispose();
            	
            }
        });
		
		JTextPane txtpnOQueVoc = new JTextPane();
		txtpnOQueVoc.setBackground(new Color(255, 253, 233));
		txtpnOQueVoc.setEditable(false);
		txtpnOQueVoc.setText("Clientes aguardando atendimento");
		txtpnOQueVoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnOQueVoc.setBounds(10, 11, 229, 20);
		contentPane.add(txtpnOQueVoc);
		
		JButton btnCancelarAtendimento = new JButton("Cancelar Atendimento");
		btnCancelarAtendimento.setBounds(465, 46, 148, 31);
		contentPane.add(btnCancelarAtendimento);
	}
}
