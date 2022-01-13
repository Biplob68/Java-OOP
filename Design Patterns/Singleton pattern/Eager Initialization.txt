package SingletonPatterns;

public class EagerInitialization {

	// Rules 1: Private static variable that is the only instance of the class.
	private static final EagerInitialization instance = new EagerInitialization();
	
	// Rules 2: make the constructor private so that this class cannot be instantiated
	private EagerInitialization() {
		
	}
	
	// Rules 3: Public static method to get the only object available
	public static EagerInitialization getinstance() {
		return instance;
	}
	
	// Main method
	public static void main(String[] args) {
	
		EagerInitialization obj = EagerInitialization.getinstance();
	}

}
