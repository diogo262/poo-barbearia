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

public class TelaFuncionario extends JFrame {

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
	public TelaFuncionario() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 253, 233));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnListarFunc = new JButton("Listar Funcionarios");
		btnListarFunc.setBounds(43, 138, 148, 31);
		contentPane.add(btnListarFunc);
		
        btnListarFunc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaListarFuncionario telaListarFuncionario = new TelaListarFuncionario();

                telaListarFuncionario.setVisible(true);

                dispose();
            }
        });
		
		
		JButton btnListarFila = new JButton("Listar Fila de Espera");
		btnListarFila.setBounds(271, 138, 148, 31);
		contentPane.add(btnListarFila);
		
		btnListarFila.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaListarFila telaListarFila = new TelaListarFila();

                telaListarFila.setVisible(true);

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
		txtpnOQueVoc.setText("Bem-vindo(a), NomedoFuncionario!");
		txtpnOQueVoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnOQueVoc.setBounds(10, 11, 229, 20);
		contentPane.add(txtpnOQueVoc);
		
		JButton btnListarCli = new JButton("Listar Clientes");
		btnListarCli.setBounds(485, 138, 148, 31);
		contentPane.add(btnListarCli);
		
		btnListarCli.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaListarCliente telaListarCliente = new TelaListarCliente();

                telaListarCliente.setVisible(true);

                dispose();
            }
        });
		
		
		JButton btnListarUni = new JButton("Listar Unidade");
		btnListarUni.setBounds(132, 199, 148, 31);
		contentPane.add(btnListarUni);
		
		btnListarUni.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaListarUnidade telaListarUnidade = new TelaListarUnidade();

                telaListarUnidade.setVisible(true);

                dispose();
            }
        });
		
		JButton btnListarServ = new JButton("Listar Serviço");
		btnListarServ.setBounds(381, 199, 148, 31);
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
