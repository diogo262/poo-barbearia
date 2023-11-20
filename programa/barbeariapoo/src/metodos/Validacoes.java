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
	
	public static boolean validaEmail(String email) {
		String mensagemErro = "";
		if (email.length() > 3) {
			if (email.contains("@"))
				return true;
			else 
				mensagemErro = "O email é inválido, informe um e-mail válido!";
		} else {
			mensagemErro = "O e-mail precisa ter mais que 3 caracteres";
		}
		
		chamaDialogErro(mensagemErro, "E-mail inválido!");
		return false;
	}
}
