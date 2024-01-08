package workshops.practice_problems.exception_handling;

public class OddNumberException extends Exception {
	private static final long serialVersionUID = 1L;

	public OddNumberException(String string) {
		super(string);
	}
}
