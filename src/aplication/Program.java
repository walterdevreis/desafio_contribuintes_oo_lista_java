package aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Quantos contribuintes você vai digitar? ");
		int n = sc.nextInt();
		System.out.println();
		
		for(int i = 0; i < n; i++) {
			System.out.printf("Digite os dados do %do contribuinte: \n", i + 1);
			System.out.print("Renda anual com salário: ");
			double salary = sc.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			double service = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			double capital = sc.nextDouble();
			System.out.print("Gastos médicos: ");
			double health = sc.nextDouble();
			System.out.print("Gastos educacionais: ");
			double education = sc.nextDouble();
			list.add(new TaxPayer(salary, service, capital, health, education));
			System.out.println();
		}
		
		for (TaxPayer obj : list) {
			System.out.printf("Resumo do %do contribuinte:\n", list.indexOf(obj) + 1);
			System.out.println(obj);
		}
		
		sc.close();
	}

}
