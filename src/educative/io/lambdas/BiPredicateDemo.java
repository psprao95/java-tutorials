package educative.io.lambdas;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class BiPredicateDemo {

	public static void main(String args[]) {
		Person arjun = new Person("Arjun", 19);
		Person naveen = new Person("Naveen", 17);
		BiPredicate<Person, Integer> isEligibleToVote = (a, m) -> a.getAge() >= m;
		
		// test function
		System.out.println("Naveen is eligible to vote: " + evaluateBiPredicate(naveen, isEligibleToVote));
		System.out.println("Arjun is eligible to vote: " + evaluateBiPredicate(arjun, isEligibleToVote));
		
		// and function
		// 10*5 = 50, 10/5=2
		// 4*2 = 8, 1/2 = 2
		BiPredicate<Person, Integer> isNotSeniorCitizen = (a, m) -> a.getAge() < m;
		BiPredicate<Person, Integer> isEligibleToContest = isEligibleToVote.and(isNotSeniorCitizen);
		System.out.println("Naveen is eligible to contest: " + evaluateBiPredicate(naveen, isEligibleToVote));
		System.out.println("Arjun is eligible to contest: " + evaluateBiPredicate(arjun, isEligibleToVote));
	}
	
	private static boolean evaluateBiPredicate(Person person, BiPredicate<Person, Integer> predicate){
		return predicate.test(person, 18);
	}
}
