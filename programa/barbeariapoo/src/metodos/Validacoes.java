package metodos;

import javax.swing.JOptionPane;

public class Validacoes {
	public static void chamaDialogErro(String mensagemErro, String tituloErro) {
		JOptionPane.showMessageDialog(null, mensagemErro, tituloErro, JOptionPane.ERROR_MESSAGE);	
	}
	
	public static boolean validaTextField(String conteudoTextField, String placeHolder) {
		if (conteudoTextField.equals(placeHolder) || conteudoTextField.isBlank()) {
			Validacoes.chamaDialogErro("Por favor, preencha o campo '"+placeHolder+"'.", "Entrada inválida");
			return false;
		} else 
			return true;
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
	
	public static String validaInscricaoNacional(String inscricaoNacional) {
		if (inscricaoNacional.length() > 0 && inscricaoNacional.length() < 15) {
			if (inscricaoNacional.length() == 14)
				return "CNPJ";
			else if (inscricaoNacional.length() == 11)
				return "CPF";
			else 
				return "";
		} else {
			Validacoes.chamaDialogErro("A inscrição nacional não atende aos requisitos", "Entrada inválida");
			return "";
		}
	}
}
