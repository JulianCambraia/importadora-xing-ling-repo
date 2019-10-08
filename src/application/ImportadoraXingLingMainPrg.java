package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Produto;
import entities.ProdutoImportado;
import entities.ProdutoUsado;

public class ImportadoraXingLingMainPrg {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Produto p = null;
		List<Produto> produtos = new ArrayList<Produto>();

		System.out.print("Entre com o número de produtos:");
		Integer pNumProd = sc.nextInt();
		System.out.println();
		for (int i = 1; i <= pNumProd; i++) {
			System.out.println("Dados do Produto #" + i + ":");
			System.out.print("Comum, Usado ou Importado (c/u/i) ?");
			char pTipoProduto = sc.next().charAt(0);
			System.out.print("Nome: ");
			String pNome = sc.next();
			System.out.print("Preço: ");
			Double pPreco = sc.nextDouble();
			switch (pTipoProduto) {
			case 'i':
				System.out.print("Taxa Alfandegária:");
				Double pTaxa = sc.nextDouble();
				p = new ProdutoImportado(pNome, pPreco, pTaxa);
				break;
			case 'c':
				p = new Produto(pNome, pPreco);
				break;

			case 'u':
				System.out.print("Data de Fabricação (DD/MM/YYYY):");
				Date pDataFabrica = sdf.parse(sc.next());
				p = new ProdutoUsado(pNome, pPreco, pDataFabrica);
				break;
			default:
				break;
			}
			produtos.add(p);
		}

		System.out.println();
		System.out.println("ETIQUETA DE PREÇOS:");
		for (Produto produto : produtos) {
			System.out.println(produto.precoEtiqueta());
		}
		sc.close();

	}

}
