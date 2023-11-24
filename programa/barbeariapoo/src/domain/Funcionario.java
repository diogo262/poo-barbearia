package domain;

public abstract class Funcionario {
	private int cdFuncionario;
	private String nomeFuncionario;
	private String sobrenomeFuncionario;
	private String telefoneFuncionario;
	private String emailFuncionario;
	private String senhaFuncionario;
	private boolean admFuncionario;
	
	public int getCdFuncionario() {
		return cdFuncionario;
	}
	public void setCdFuncionario(int cdFuncionario) {
		this.cdFuncionario = cdFuncionario;
	}
	
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	
	public String getSobrenomeFuncionario() {
		return sobrenomeFuncionario;
	}
	public void setSobrenomeFuncionario(String sobrenomeFuncionario) {
		this.sobrenomeFuncionario = sobrenomeFuncionario;
	}
	
	public String getTelefoneFuncionario() {
		return telefoneFuncionario;
	}
	public void setTelefoneFuncionario(String telefoneFuncionario) {
		this.telefoneFuncionario = telefoneFuncionario;
	}
	
	public String getEmailFuncionario() {
		return emailFuncionario;
	}
	public void setEmailFuncionario(String emailFuncionario) {
		this.emailFuncionario = emailFuncionario;
	}
	
	public String getSenhaFuncionario() {
		return senhaFuncionario;
	}
	public void setSenhaFuncionario(String senhaFuncionario) {
		this.senhaFuncionario = senhaFuncionario;
	}
	
	public boolean getAdmFuncionario() {
		return admFuncionario;
	}
	public void setAdmFuncionario(boolean admFuncionario) {
		this.admFuncionario = admFuncionario;
	}
}
