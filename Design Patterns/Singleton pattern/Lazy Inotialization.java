package SingletonPatterns;

public class LazyInitialization {

	
	// Rules 1: Private static variable that is the only instance of the class.
		private static LazyInitialization instance;
		
		// Rules 2: make the constructor private so that this class cannot be instantiated
		private LazyInitialization() {
			
		}
		
		// Rules 3: Public static method to get the only object available
		public static LazyInitialization getinstance() {
			if(instance == null) {
				instance = new LazyInitialization();
			}
			return instance;
		}
		
		// Main method
		public static void main(String[] args) {
		
			LazyInitialization obj = LazyInitialization.getinstance();
		}

}
