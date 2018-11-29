package com.sorts.main;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSortEaxmple1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Map<String, Integer> unsortMap = new HashMap<>();
	        unsortMap.put("z", 10);
	        unsortMap.put("b", 5);
	        unsortMap.put("a", 6);
	        unsortMap.put("c", 20);
	        unsortMap.put("d", 1);
	        unsortMap.put("e", 7);
	        unsortMap.put("y", 8);
	        unsortMap.put("n", 99);
	        unsortMap.put("g", 50);
	        unsortMap.put("m", 2);
	        unsortMap.put("f", 9);
	        unsortMap.put(null, 9);

	        System.out.println("Original...");
	        System.out.println(unsortMap);

	        // sort by keys, a,b,c..., and return a new LinkedHashMap
	        // toMap() will returns HashMap by default, we need LinkedHashMap to keep the order.
	        Map<String, Integer> result = unsortMap.entrySet().parallelStream()
	                .sorted(Map.Entry.comparingByKey())
	                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue
	         ,
                    (oldValue, newValue) -> oldValue, LinkedHashMap::new));

	        result.forEach((a,b) -> System.out.println("Key:: "+a +"  Value:: "+b));
	       
	        System.out.println("********");
	        
	     // sort by values, , and return a new LinkedHashMap
	        // toMap() will returns HashMap by default, we need LinkedHashMap to keep the order.
	        Map<String, Integer> resulte = unsortMap.entrySet().stream()
	                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
	                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
	                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

	        resulte.forEach((a,b) -> System.out.println("Key:: "+a +"  Value:: "+b));
	        
	}

}
