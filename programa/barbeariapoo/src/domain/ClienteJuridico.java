package domain;

public class ClienteJuridico extends Cliente {
	private String cnpjCliente;

	public String getCnpjCliente() {
		return cnpjCliente;
	}
	public void setCnpjCliente(String cnpjCliente) {
		this.cnpjCliente = cnpjCliente;
	}
}
