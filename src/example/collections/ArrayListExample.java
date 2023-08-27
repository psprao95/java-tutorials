package example.collections;

import java.util.List;
import java.util.ArrayList;

public class ArrayListExample {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(20);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		System.out.println(list);
		
		list.add(2, 10);
		System.out.println(list);
		
		List<Integer> secondList = new ArrayList<Integer>();
		secondList.add(88);
		secondList.add(99);
		secondList.add(99);
		
		list.addAll(secondList);
		System.out.println(list);
		
		list.addAll(4, secondList);
		System.out.println(list);
		
		System.out.println("The element at index 4 is: "+list.get(4));
		System.out.println("The size of the arraylist is: "+list.size());
		
		
		list.remove(2);
		System.out.println(list);
		
		list.set(1, 10);
		System.out.println(list);
	}

}
