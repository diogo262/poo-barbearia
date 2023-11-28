package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class TelaAvaliarFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldTituloAvaliacao;
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
	public TelaAvaliarFuncionario(int cdCli) {
		this.cdCliente = cdCli;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 253, 233));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(310, 319, 133, 31);
		contentPane.add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	TelaCliente telaCliente = new TelaCliente(cdCliente);

                telaCliente.setVisible(true);

            	
            	dispose();
            }
        });
		
		textFieldTituloAvaliacao = new JTextField();
		textFieldTituloAvaliacao.setBounds(58, 120, 213, 37);
		contentPane.add(textFieldTituloAvaliacao);
		textFieldTituloAvaliacao.setText("Titulo Avaliação");
		textFieldTituloAvaliacao.setForeground(Color.GRAY);
        adicionarTextoDica(textFieldTituloAvaliacao, "Titulo Avaliação");
		
		
		
		JTextPane txtpnOQueVoc = new JTextPane();
		txtpnOQueVoc.setBackground(new Color(255, 253, 233));
		txtpnOQueVoc.setEditable(false);
		txtpnOQueVoc.setText("Avaliar Funcionário");
		txtpnOQueVoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnOQueVoc.setBounds(10, 11, 229, 20);
		contentPane.add(txtpnOQueVoc);
		
		
		JButton starButton1 = new JButton("★ 1");
		starButton1.setBounds(58, 64, 55, 31);
		contentPane.add(starButton1);
		starButton1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        System.out.println("Avaliação alterada para: " + e.getActionCommand());
		    }
		});

		
		JButton starButton2 = new JButton("★ 2");
		starButton2.setBounds(123, 64, 55, 31);
		contentPane.add(starButton2);
		starButton2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        System.out.println("Avaliação alterada para: " + e.getActionCommand());
		    }
		});

		
		JButton starButton3 = new JButton("★ 3");
		starButton3.setBounds(188, 64, 51, 31);
		contentPane.add(starButton3);
		starButton3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        System.out.println("Avaliação alterada para: " + e.getActionCommand());
		    }
		});


		JButton starButton4 = new JButton("★ 4");
		starButton4.setBounds(249, 64, 51, 31);
		contentPane.add(starButton4);
		starButton4.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        System.out.println("Avaliação alterada para: " + e.getActionCommand());
		    }
		});


		JButton starButton5 = new JButton("★ 5");
		starButton5.setBounds(310, 64, 55, 31);
		contentPane.add(starButton5);
		
		JTextArea textAreaTextoAvaliacao = new JTextArea();
		textAreaTextoAvaliacao.setBounds(58, 181, 590, 123);
		contentPane.add(textAreaTextoAvaliacao);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(403, 120, 245, 37);
		contentPane.add(comboBox);
		starButton5.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        System.out.println("Avaliação alterada para: " + e.getActionCommand());
		    }
		});
	}
	
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