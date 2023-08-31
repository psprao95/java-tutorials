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
		BiPredicate<Integer, Integer> isSumEqualToTwenty = (a, m) -> a + m == 20;
		BiPredicate<Integer, Integer> isOneArgumentDivisibleByOther = (a, m) -> a%m ==0 || m%a == 0;
		BiPredicate<Integer, Integer> friendNumbers = isOneArgumentDivisibleByOther.and(isSumEqualToTwenty);
		System.out.println("2 and 18 are friend numbers: " + friendNumbers.test(2, 18));
		System.out.println("13 and 7 are friend numbers: " + friendNumbers.test(13, 7));
		System.out.println("8 and 12 are friend numbers: " + friendNumbers.test(8, 12));
		System.out.println("16 and 4 are friend numbers: " + friendNumbers.test(16, 4));
		System.out.println("15 and 5 are friend numbers: " + friendNumbers.test(15, 5));
		
		// or function
		BiPredicate<Integer, Integer> aquaintanceNumbers = isOneArgumentDivisibleByOther.or(isSumEqualToTwenty);
		System.out.println("2 and 14 are aquaintance numbers: " + aquaintanceNumbers.test(2, 18));
		System.out.println("9 and 11 are aquaintance numbers: " + aquaintanceNumbers.test(13, 7));
		System.out.println("8 and 12 are aquaintance numbers: " + aquaintanceNumbers.test(8, 12));
		System.out.println("16 and 7 are aquaintance numbers: " + aquaintanceNumbers.test(16, 7));
		System.out.println("15 and 9 are aquaintance numbers: " + aquaintanceNumbers.test(15, 9));
		
		// negate function
		BiPredicate<Person, Integer> isNotEligibleToVote = isEligibleToVote.negate();
		System.out.println("Naveen is not eligible to vote: " + isNotEligibleToVote.test(naveen, 18));
		System.out.println("Arjun is not eligible to vote: " + isNotEligibleToVote.test(arjun, 18));
	}
	
	private static boolean evaluateBiPredicate(Person person, BiPredicate<Person, Integer> predicate){
		return predicate.test(person, 18);
	}
}
