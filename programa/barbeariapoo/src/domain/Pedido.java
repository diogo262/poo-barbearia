package domain;

import java.sql.Date;

public class Pedido<F extends Funcionario, C extends Cliente> {
	private Servico Servico;
	private C cliente;
	private F funcionario;
	private boolean statusPedido;
	private Date horaPedido;
	private Date dataPedido;
	
	public Servico getServico() {
		return Servico;
	}
	public void setServico(Servico servico) {
		Servico = servico;
	}
	
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
	
	public boolean setStatusPedido() {
		return statusPedido;
	}
	public void setStatusPedido(boolean statusPedido) {
		this.statusPedido = statusPedido;
	}
	
	public Date getHoraPedido() {
		return horaPedido;
	}
	public void setHoraPedido(Date horaPedido) {
		this.horaPedido = horaPedido;
	}
	
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
}
