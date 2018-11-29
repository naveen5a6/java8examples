package com.sorts.main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.streams.models.Product;

public class CollectionSortExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> numbers = Arrays.asList(3, 5, 1, 9, 7, 0, 10);

		List<Integer> sortedNumbers = numbers.parallelStream().sorted()
				.collect(Collectors.toList());
		
		sortedNumbers.forEach(i -> {
			System.out.print(i + ",");
		});
		System.out.println();

		List<Product> products = Arrays.asList(new Product("abc", 12, "cloth"), new Product("xyz", 3, "footwear"),
				new Product("njj", 13, "cloth"));
		

		products.sort(Comparator.comparingInt(Product::getPrice));
		products.forEach(p -> {
			System.out.println(p.getPrice());
		});

		// custom comparator with anynomous class
		List<Product> products1 = Arrays.asList(new Product("abc", 12, "cloth"), new Product("xyz", 3, "footwear"),
				new Product("njj", 13, "cloth"));

		products1.sort(new Comparator<Product>() {
			@Override
			public int compare(Product m1, Product m2) {
				if (m1.getPrice() == m2.getPrice()) {
					return 0;
				}
				return m1.getPrice() < m2.getPrice() ? -1 : 1;
			}
		});

		products1.forEach(p -> {
			System.out.println(p.getPrice());
		});

		// using lambda instead of anynomous classes

		List<Product> products2 = Arrays.asList(new Product("abc", 12, "cloth"), new Product("xyz", 3, "footwear"),
				new Product("njj", 13, "cloth"));

		products2.sort((p1, p2) -> {
			if (p1.getPrice() == p2.getPrice()) {
				return 0;
			}
			return p1.getPrice() < p2.getPrice() ? -1 : 1;
		});

		products2.forEach(p -> {
			System.out.println(p.getPrice());
		});

		// using comparator

		List<Product> products3 = Arrays.asList(new Product("abc", 12, "cloth"), new Product("xyz", 3, "footwear"),
				new Product("njj", 13, "cloth"));

		products3.sort(Comparator.comparing(Product::getPrice, (p1, p2) -> {
			if (p1 == p2) {
				return 0;
			}
			return p1 > p2 ? -1 : 1;
		}));

		products3.forEach(p -> {
			System.out.println(p.getPrice());
		});

		// then comparing example

		List<Product> products4 = Arrays.asList(new Product("abc", 12, "cloth"), new Product("xyz", 3, "footwear"),
				new Product("njj", 13, "cloth"));

		products4.sort(Comparator.comparing(Product::getType).thenComparingInt(Product::getPrice));

		products4.forEach(p -> {
			System.out.println(p.getType() + " " + p.getPrice());
		});
		
		
		
		
	}

}
