package business;

public class CustomNullOrderExceptions extends Exception {

	public CustomNullOrderExceptions() {
		super("The equality of the Order element resulted in being null hence the functionality of the method will no be occuring.");
	}

	public CustomNullOrderExceptions(String message) {
		System.out.println(message);
	}

}
