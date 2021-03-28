package java_ncs_exam.exception;

@SuppressWarnings("serial")
public class LengthCheckException extends RuntimeException{
	
	public LengthCheckException() {
		super("사원번호는 3자리 까지 입력가능합니다.");
	}
	
	public LengthCheckException(String message) {
		super(message);
	}

	public LengthCheckException(Throwable cause) {
		super("사원번호는 3자리 까지 입력가능합니다.",cause);
	}
}
