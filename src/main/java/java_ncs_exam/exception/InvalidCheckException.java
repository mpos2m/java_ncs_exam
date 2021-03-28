package java_ncs_exam.exception;

@SuppressWarnings("serial")
public class InvalidCheckException extends RuntimeException {

	public InvalidCheckException() {
		super("공란 존재.");
	}
	 
	public InvalidCheckException(String message) {
		super(message);
	}

	public InvalidCheckException(Throwable cause) {
		super("공란 존재.",cause);
	}
	
}
