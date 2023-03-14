package exception;

public class AgeMismatch extends Exception {
	public AgeMismatch(int min, int max){
		super("Error: Age +"+min+" is greater than "+max+"!");
	}
}
