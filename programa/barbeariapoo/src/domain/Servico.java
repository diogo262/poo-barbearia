package domain;

public class Servico {
	private int cdServico;
	private String nomeServico;
	private double precoServico;
	
	public int getCdServico() {
		return cdServico;
	}
	public void setCdServico(int cdServico) {
		this.cdServico = cdServico;
	}
	
	public String getNomeServico() {
		return nomeServico;
	}
	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}
	
	public double getPrecoServico() {
		return precoServico;
	}
	public void setPrecoServico(double precoServico) {
		this.precoServico = precoServico;
	}
}
