package model;

public class VendaProduto {

	private String idVendaProduto;
	private String idVenda;
	private String idProduto;
	private int quantidade;
	private double valorTotal;
	
	public VendaProduto(String idVendaProduto, String idVenda, String idProduto, int quantidade, double valorTotal) {
		super();
		this.idVendaProduto = idVendaProduto;
		this.idVenda = idVenda;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
		this.valorTotal = valorTotal;
	}

	
	public VendaProduto() {
		super();
	}

	
	
	public String getIdVendaProduto() {
		return idVendaProduto;
	}

	public void setIdVendaProduto(String idVendaProduto) {
		this.idVendaProduto = idVendaProduto;
	}

	public String getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(String idVenda) {
		this.idVenda = idVenda;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	
}
