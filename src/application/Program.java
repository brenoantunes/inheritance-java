package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List <Product> listProduct = new ArrayList<>();
		
		System.out.print("Enter the numer of products: ");
		int num = sc.nextInt();
		
		for (int i=1; i<=num; i++) {
			
			System.out.println("Product #" + i + " data:");
			System.out.print("Comon, used or imported (c/u/i)? ");
			char c = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			sc.nextLine();
			
			if (c == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				listProduct.add(new ImportedProduct(name, price, customsFee));
			}
			
			else if (c == 'u'){
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				listProduct.add(new UsedProduct(name, price, manufactureDate));
				
			}
			
			else {
				listProduct.add(new Product(name, price));
			}
		}
		
		System.out.println();
		
		System.out.println("PRICE TAGS: ");
		for (Product p : listProduct) {
			System.out.println(p.priceTag());
		}
		
		sc.close();
	}
}
