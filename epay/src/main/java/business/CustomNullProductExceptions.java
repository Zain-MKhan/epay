package business;

public class CustomNullProductExceptions extends Exception{


    public CustomNullProductExceptions (){
		super("The equality of the Product element resulted in being null hence the functionality of the method will no be occuring.");
	}
	public CustomNullProductExceptions (String message){
		System.out.println(message);
	}
    
}
