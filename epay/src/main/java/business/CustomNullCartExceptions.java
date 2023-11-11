package business;

public class CustomNullCartExceptions extends Exception {

	public CustomNullCartExceptions() {
		super("The equality of the Cart element resulted in being null hence the functionality of the method will no be occuring.");
	}

	public CustomNullCartExceptions(String message) {
		System.out.println(message);
	}

}
