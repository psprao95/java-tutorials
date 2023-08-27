package educative.io.lambdas;

public class Person {

	private int age;
	private String name;
	private String country;
	
	public Person(int age, String name, String country){
		this.age = age;
		this.name = name;
		this.country = country;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getCountry() {
		return this.country;
	}
}
