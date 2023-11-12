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

public class TelaCliente extends JFrame {

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
	public TelaCliente() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 253, 233));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMarcarChegada = new JButton("Marcar Chegada");
		btnMarcarChegada.setBounds(43, 138, 148, 31);
		contentPane.add(btnMarcarChegada);
		
        btnMarcarChegada.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaMarcarChegada telaMarcarChegada = new TelaMarcarChegada();

                telaMarcarChegada.setVisible(true);

                dispose();
            }
        });
		
		
		JButton btnAvaliarFunc = new JButton("Avaliar Funcionário");
		btnAvaliarFunc.setBounds(271, 138, 148, 31);
		contentPane.add(btnAvaliarFunc);
		
		btnAvaliarFunc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaAvaliarFuncionario telaAvaliarFuncionario = new TelaAvaliarFuncionario();

                telaAvaliarFuncionario.setVisible(true);

                dispose();
            }
        });
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(288, 260, 114, 23);
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
		txtpnOQueVoc.setText("Bem-vindo(a), NomedoCliente!");
		txtpnOQueVoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnOQueVoc.setBounds(10, 11, 229, 20);
		contentPane.add(txtpnOQueVoc);
		
		JButton btnListarServ = new JButton("Listar Serviços");
		btnListarServ.setBounds(485, 138, 148, 31);
		contentPane.add(btnListarServ);
		
		btnListarServ.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaListarServico telaListarServico = new TelaListarServico();

                telaListarServico.setVisible(true);

                dispose();
            }
        });
		
	}
}
