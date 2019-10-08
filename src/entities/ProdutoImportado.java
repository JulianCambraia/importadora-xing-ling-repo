package entities;

public class ProdutoImportado extends Produto {

	private Double taxAlfandegaria;

	public ProdutoImportado() {
		super();
	}

	public ProdutoImportado(String nome, Double preco, Double taxAlfandegaria) {
		super(nome, preco);
		this.taxAlfandegaria = taxAlfandegaria;
	}

	public Double getTaxAlfandegaria() {
		return taxAlfandegaria;
	}

	public void setTaxAlfandegaria(Double taxAlfandegaria) {
		this.taxAlfandegaria = taxAlfandegaria;
	}

	public Double precoTotal() {
		return super.getPreco() + taxAlfandegaria;
	}

	@Override
	public String precoEtiqueta() {
		return getNome() + " R$ " + String.format("%.2f", precoTotal()) + "Taxa Alfandegaria: R$ "
				+ String.format("%.2f", taxAlfandegaria);
	}

}
