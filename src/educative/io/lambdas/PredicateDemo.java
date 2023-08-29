package educative.io.lambdas;

import java.util.function.Predicate;

public class PredicateDemo {
	
	public static void main(String[] args) {
		Person person = new Person("Ganesh", 31);
		Predicate<Person> isAtleastEighteen = p -> p.getAge() >=18;
		Predicate<Person> isBelowSixty = p -> p.getAge() < 60;
		
		// test function
		System.out.println("Ganesh is eligible to vote: " + evaluatePredicate(person, isAtleastEighteen));
		
		// and function
		Predicate<Person> isEligibleForClubMemberShip = isAtleastEighteen.and(isBelowSixty);
		System.out.println("Ganesh is eligible for club membership: " + evaluatePredicate(person, isEligibleForClubMemberShip));
		
		// or function
		Predicate<Integer> isAMultipleOfFive = i -> i%5 == 0;
		Predicate<Integer> isAMultipleOfThree = i -> i%3 == 0;
		Predicate<Integer> isAMultipleOfThreeOrFive = isAMultipleOfThree.or(isAMultipleOfFive);
		System.out.println("Number is a multiple of 3 or 5: " + isAMultipleOfThreeOrFive.test(49));
		
		// negate function
		Predicate<Integer> isAMultipleOfTen = p -> p%10 == 0;
		Predicate<Integer> isNotAMultipleOfTen = isAMultipleOfTen.negate();
		System.out.println("11 is not a multiple of 10: " + isNotAMultipleOfTen.test(11));
		System.out.println("20 is not a multiple of 10: " + isNotAMultipleOfTen.test(20));
		
		// isEqual function
		Predicate<String> testPredicate = Predicate.isEqual("Hello");
		System.out.println("Hello is equal to World: " + testPredicate.test("World"));
		System.out.println("Hello is equal to Hello: " + testPredicate.test("Hello"));
		
		Person p1 = new Person("Neeraj", 22);
		Person p2 = new Person("Raj", 20);
		Predicate<Person> testObjPredicate = Predicate.isEqual(p1);
		System.out.println("Test 1: " + testObjPredicate.test(p1));
		System.out.println("Test 2: " + testObjPredicate.test(p2));
		System.out.println("Test 3: " + testObjPredicate.test(new Person("Neeraj", 22)));
	}
	
	private static boolean evaluatePredicate(Person person, Predicate<Person> predicate){
		return predicate.test(person);
	}
}
