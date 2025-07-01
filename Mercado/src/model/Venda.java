package model;

public class Venda {

	private String idVenda;
	private String idFuncionario;
	private String idCliente;
	private String dataVenda;
	private String precoTotal;
	private String formaPag;
	private String quantTotal;
	
	public Venda(String idVenda, String idFuncionario, String idCliente, String dataVenda, String precoTotal,
			String formaPag, String quantTotal) {
		super();
		this.idVenda = idVenda;
		this.idFuncionario = idFuncionario;
		this.idCliente = idCliente;
		this.dataVenda = dataVenda;
		this.precoTotal = precoTotal;
		this.formaPag = formaPag;
		this.quantTotal = quantTotal;
	}

	public Venda() {
		super();
	}

	public String getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(String idVenda) {
		this.idVenda = idVenda;
	}

	public String getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(String idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(String precoTotal) {
		this.precoTotal = precoTotal;
	}

	public String getFormaPag() {
		return formaPag;
	}

	public void setFormaPag(String formaPag) {
		this.formaPag = formaPag;
	}

	public String getQuantTotal() {
		return quantTotal;
	}

	public void setQuantTotal(String quantTotal) {
		this.quantTotal = quantTotal;
	}
	
	
	
	}
