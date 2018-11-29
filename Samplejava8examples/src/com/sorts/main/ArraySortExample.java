package com.sorts.main;

import java.util.Arrays;

public class ArraySortExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = { 3, 5, 1, 9, 7, 0, 10 };
		System.out.println("Before Sorting: ");

		for (int i : a) {
			System.out.print(i + ",");
		}

		Arrays.parallelSort(a);

		System.out.println("After Sorting: ");

		for (int i : a) {
			System.out.print(i + ",");
		}

	}

}
