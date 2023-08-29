package coding.with.john;

import java.util.HashMap;

public class MapHashMapDemo {

	public static void main(String args[]) {
		HashMap<String, Integer> empIds= new HashMap<String, Integer>();
		
		// add key-value pairs
		empIds.put("Prashanth", 1234);
		empIds.put("Qasim", 2311);
		empIds.put("Ramesh", 9879);
		
		System.out.println(empIds);
		
		// get value using key
		System.out.println(empIds.get("Ramesh"));
		
		// check if key exists
		System.out.println(empIds.containsKey("Qasim"));
		System.out.println(empIds.containsKey("Arjun"));
		
		// check if value exists
		System.out.println(empIds.containsValue(5432));
		System.out.println(empIds.containsValue(1234));
		
		// update value for key
		empIds.put("Prashanth", 3872);
		System.out.println(empIds);
		
		// replace value of key
		empIds.replace("Prashanth", 3878);
		empIds.replace("Arjun", 3878);
		System.out.println(empIds);
	}
}
