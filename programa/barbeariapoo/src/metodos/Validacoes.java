package metodos;

import javax.swing.JOptionPane;

public class Validacoes {
	public static void chamaDialogErro(String mensagemErro, String tituloErro) {
		JOptionPane.showMessageDialog(null, mensagemErro, tituloErro, JOptionPane.ERROR_MESSAGE);	
	}
	
	public static void validaTextField(String conteudoTextField, String placeHolder, boolean entradaValida) {
		if (conteudoTextField.equals(placeHolder) || conteudoTextField.isBlank()) {
			entradaValida = false;
			Validacoes.chamaDialogErro("Por favor, preencha o campo '"+placeHolder+"'.", "Entrada inválida");
		}
	}
}
