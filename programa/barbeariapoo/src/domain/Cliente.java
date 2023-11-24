package domain;

public abstract class Cliente {
	private int cdCliente;
	private String nomeCliente;
	private String sobrenomeCliente;
	private String telefoneCliente;
	private String emailCliente;
	private String senhaCliente;
	private boolean admCliente;
	
	public int getCdCliente() {
		return cdCliente;
	}
	public void setCdCliente(int cdCliente) {
		this.cdCliente = cdCliente;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public String getSobrenomeCliente() {
		return sobrenomeCliente;
	}
	public void setSobrenomeCliente(String sobrenomeCliente) {
		this.sobrenomeCliente = sobrenomeCliente;
	}
	
	public String getTelefoneCliente() {
		return telefoneCliente;
	}
	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}
	
	public String getEmailCliente() {
		return emailCliente;
	}
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	
	public String getSenhaCliente() {
		return senhaCliente;
	}
	public void setSenhaCliente(String senhaCliente) {
		this.senhaCliente = senhaCliente;
	}
	
	public boolean getAdmCliente() {
		return admCliente;
	}
	public void setAdmCliente(boolean admCliente) {
		this.admCliente = admCliente;
	}
}
