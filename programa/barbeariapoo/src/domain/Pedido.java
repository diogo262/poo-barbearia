package domain;

public class Pedido<F extends Funcionario, C extends Cliente> {
	private int cdPedido;
	private C cliente;
	private F funcionario;
	private int cdStatus;
	private String nomeStatus;
	private String horaPedido;
	private String dataPedido;
	private String nomeCliente;
	private String sobrenomeCliente;
	private String telefoneCliente;
	private String emailCliente;
	private String inscricaoNacionalCliente;
	
	public C getCliente() {
		return cliente;
	}
	public void setCliente(C cliente) {
		this.cliente = cliente;
	}
	public F getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(F funcionario) {
		this.funcionario = funcionario;
	}
	public int getCdPedido() {
		return cdPedido;
	}
	public void setCdPedido(int cdPedido) {
		this.cdPedido = cdPedido;
	}
	public int getCdStatus() {
		return cdStatus;
	}
	public void setCdStatus(int cdStatus) {
		this.cdStatus = cdStatus;
	}
	public String getNomeStatus() {
		return nomeStatus;
	}
	public void setNomeStatus(String nomeStatus) {
		this.nomeStatus = nomeStatus;
	}
	public String getHoraPedido() {
		return horaPedido;
	}
	public void setHoraPedido(String horaPedido) {
		this.horaPedido = horaPedido;
	}
	public String getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
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
	public String getInscricaoNacionalCliente() {
		return inscricaoNacionalCliente;
	}
	public void setInscricaoNacionalCliente(String inscricaoNacionalCliente) {
		this.inscricaoNacionalCliente = inscricaoNacionalCliente;
	}
	
}
