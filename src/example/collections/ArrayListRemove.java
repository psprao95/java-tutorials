package example.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
//import java.util.ArrayListremoveRange;

public class ArrayListRemove {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(20);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(2);
		
		list.remove(3);
		System.out.println(list);
		
		list.remove(new Integer(2));
		System.out.println(list);
		
		//ArrayList.removeRange(1, 3);
		//System.out.println(list);
		
		list.clear();
		System.out.println(list);
		
		List<Integer> secondList = new ArrayList<Integer>(20);
		secondList.add(1);
		secondList.add(2);
		secondList.add(3);
		
		secondList.removeAll(secondList);
		System.out.println(secondList);
	}
}
