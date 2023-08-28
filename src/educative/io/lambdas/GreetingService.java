package educative.io.lambdas;

public class GreetingService {
	
	public void executeGreeting(Greeting greeting) {
		greeting.greet();
	}
	
	public static void main(String args[]) {
		
		// Approach 1: instantiate each implementation and pass it to executeGreeting()
		Greeting englishGreeting = new EnglishGreeting();
		Greeting hindiGreeting = new HindiGreeting();
		GreetingService greetingService = new GreetingService();
		greetingService.executeGreeting(englishGreeting);
		greetingService.executeGreeting(hindiGreeting);
		
		// approach 2: pass in anonymous class to executeGreeting() function
		greetingService.executeGreeting(new Greeting() {
			@Override
			public void greet() {
				System.out.println("Buenos dias");
			}
		});
		
		// approach 3: pass in lambda to executeGreeting() function
		greetingService.executeGreeting(() -> System.out.println("Guten tag"));
	}
}
