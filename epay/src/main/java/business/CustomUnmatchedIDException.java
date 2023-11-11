package business;

public class CustomUnmatchedIDException extends Exception {

	public CustomUnmatchedIDException() {
		super("The elements of the id did not match hence the method will not be occuring.");
	}

	public CustomUnmatchedIDException(String message) {
		System.out.println(message);
	}

}
