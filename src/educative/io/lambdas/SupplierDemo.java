package educative.io.lambdas;

import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.IntSupplier;
import java.util.function.DoubleSupplier;

public class SupplierDemo {

	public static void main(String args[]) {
		Supplier<Person> naveenSupplier = () -> new Person("Naveen", 39);
		Supplier<Person> ramSupplier = () -> new Person("Ram", 9);
		Predicate<Person> isEligibleToVote = (a) -> a.getAge() >= 18;
		System.out.println("Naveen is eligible to vote: " + evaluatePredicate(naveenSupplier, isEligibleToVote));
		System.out.println("Ram is eligible to vote: " + evaluatePredicate(ramSupplier, isEligibleToVote));
		
		IntSupplier randomIntSupplier = () -> (int)(Math.random()*10);
		System.out.println(randomIntSupplier.getAsInt());
		
		DoubleSupplier randomDoubleSupplier = () -> Math.random()*10;
		System.out.println(randomDoubleSupplier.getAsDouble());
		
		
	}
	
	public static boolean evaluatePredicate(Supplier<Person> supplier, Predicate<Person> predicate) {
		return predicate.test(supplier.get());
	}
}
