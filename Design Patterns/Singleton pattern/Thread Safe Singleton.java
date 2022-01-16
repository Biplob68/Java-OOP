package SingletonPatterns;

public class ThreadSafeSingleton {

	
	// Rules 1: Private static variable that is the only instance of the class.
		private static ThreadSafeSingleton instance;
		
		// Rules 2: make the constructor private so that this class cannot be instantiated
		private ThreadSafeSingleton() {
			
		}
		
		// Rules 3: Public static method to get the only object available
		public static synchronized ThreadSafeSingleton getinstance() {
			if(instance == null) {
				instance = new ThreadSafeSingleton();
			}
			return instance;
		}
		
		// Main method
		public static void main(String[] args) {
		
			ThreadSafeSingleton obj = ThreadSafeSingleton.getinstance();
		}

}
