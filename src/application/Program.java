package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner read = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> list = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int n = read.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.print("Common, used or imported (c/u/i)? ");
			char chr = read.next().charAt(0);
			System.out.print("Name: ");
			read.nextLine();
			String name = read.nextLine();
			System.out.print("Price: ");
			double price = read.nextDouble();
			if (chr == 'c') {
				list.add(new Product(name, price));
			} else if (chr == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(read.next());
				list.add(new UsedProduct(name, price, date));
			} else {
				System.out.print("Customs fee: ");
				double customsFee = read.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}
		}

		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product prod : list) {
			System.out.println(prod.priceTag());
		}

		read.close();

	}

}
