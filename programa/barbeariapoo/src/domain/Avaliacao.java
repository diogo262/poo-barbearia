package domain;

public class Avaliacao<F extends Funcionario, C extends Cliente> {
	private C cliente;
	private F funcionario;
	private int qntdEstrela;
	private String textoAvaliacao;
	
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
	public int getQntdEstrela() {
		return qntdEstrela;
	}
	public void setQntdEstrela(int qntdEstrela) {
		this.qntdEstrela = qntdEstrela;
	}
	public String getTextoAvaliacao() {
		return textoAvaliacao;
	}
	public void setTextoAvaliacao(String textoAvaliacao) {
		this.textoAvaliacao = textoAvaliacao;
	}
}
