package interview.questions;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TracxnCodingProblem {
	
	public static void main(String args[]) {
		int Q = 7;
		List<List<Integer>> queries = new ArrayList<>();
		queries.add(Arrays.asList(1, 2));
		queries.add(Arrays.asList(1, 4));
		queries.add(Arrays.asList(1, 3));
		queries.add(Arrays.asList(1, 2));
		queries.add(Arrays.asList(1, 6));
		queries.add(Arrays.asList(2, -1));
		queries.add(Arrays.asList(2, -1));
		processPipeline(Q, queries);
		
	}
	
	/*
	 * Parameters:
	 * Q: number of queries
	 * queries: 2-dimensional integer array
	 * Each array entry in queries has 2 elements
	 * The first element denotes the operation
	 * The second element is the operand
	 * If operation = 1, add the operand to our running list
	 * If operation = 2, remove the most occurring element in our list from its last occurring index
	 * If two elements have the same number of maximum occurrences, we choose the one having the greater last occurring index
	 */
	public static void processPipeline(int Q, List<List<Integer>> queries) {
		List<Integer> currentQuery = new ArrayList<>();
		List<Integer> elements = new ArrayList<Integer>();
		Map<Integer, Integer> occurrenceMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> lastOccurringIndexMap = new HashMap<Integer, Integer>();
		List<Integer> removedElements = new ArrayList<>();
		
		for(int i = 0; i < Q; i++) {
			currentQuery.addAll(queries.get(i));
			System.out.println(currentQuery);
			
			int operation = currentQuery.get(0);
			int element = currentQuery.get(1);
			if(operation == 1) {
				elements.add(element);
				if(occurrenceMap.containsKey(element)){
					occurrenceMap.put(element, occurrenceMap.get(element) + 1);
				} else {
					occurrenceMap.put(element, 1);
				}
				lastOccurringIndexMap.put(element, elements.size() - 1);
			} else if(operation == 2) {
				int maxOccurringElement = -1;
				int maxOccurrences = 0;
				int indexMaxOccurringElement = -1;
				
				for(Map.Entry<Integer, Integer> mapElement: occurrenceMap.entrySet()) {
					if(mapElement.getValue() > maxOccurrences || (mapElement.getValue() == maxOccurrences 
							&& lastOccurringIndexMap.get(mapElement.getKey()) > lastOccurringIndexMap.get(maxOccurringElement))){
						maxOccurrences = mapElement.getValue();
						maxOccurringElement = mapElement.getKey();
						indexMaxOccurringElement = lastOccurringIndexMap.get(maxOccurringElement);
					}
				}
				
				if(indexMaxOccurringElement != -1) {
					removedElements.add(maxOccurringElement);
					
					int currentOccurrences = occurrenceMap.get(maxOccurringElement);
					if(currentOccurrences == 1) {
						occurrenceMap.remove(maxOccurringElement);
						lastOccurringIndexMap.remove(maxOccurringElement);
					}
					else {
						occurrenceMap.put(maxOccurringElement, currentOccurrences - 1);
						for(int k = indexMaxOccurringElement - 1; k>=0; k--) {
							if(elements.get(k) == maxOccurringElement) {
								lastOccurringIndexMap.put(maxOccurringElement, k);
								break;
							}
						}
					}
					
					for(int l = indexMaxOccurringElement + 1; l < elements.size(); l++) {
						lastOccurringIndexMap.put(elements.get(l), lastOccurringIndexMap.get(elements.get(l)) - 1);
					}
					
					
					elements.remove(indexMaxOccurringElement);
				}
			}
			
			System.out.println("array after operation " + (i+1) + " " + elements );
			System.out.println("occurrence map after operation " + (i+1) + " " + occurrenceMap );
			System.out.println("last occurring index map after operation " + (i+1) + " " + lastOccurringIndexMap );
			currentQuery.clear();
		}
		
		System.out.println("removed elements: " + removedElements );
		
	}

}
