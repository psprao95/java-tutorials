package educative.io.lambdas;

import java.util.List;
import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;

public class PersonService {

	public static List<Person> getPersons(List<Person> persons){
		Collections.sort(persons, new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				return p1.getName().compareTo(p2.getName());
			}
		});
		return persons;
	}
	
	public static void main(String[] args) {
		
		// approach 1: using the sort function that implements the Comparator interface
		List<Person> persons = new ArrayList<>();
		persons.add(new Person(25, "Raoul", "Mexico"));
		persons.add(new Person(28, "John", "USA"));
		persons.add(new Person(20, "Takeshi", "Japan"));
		persons.add(new Person(20, "Amit", "India"));
		
		//persons = getPersons(persons);
		
		// approach 2: using a lambda that implements the Comparator interface
		Collections.sort(persons, (Person p1, Person p2) -> p1.getName().compareTo(p2.getName()));
		
		System.out.println("Person names in sorted order");
		for(Person person: persons) {
			System.out.println(person.getName());
		}
	}
}
