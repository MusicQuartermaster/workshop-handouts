package workshops.practice_problems.exception_handling;

public class ContainsNumberException extends Exception {
	private static final long serialVersionUID = 1L;

	public ContainsNumberException(String string) {
		super(string);
	}
}
