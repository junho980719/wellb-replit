
package kr.co.misoinfo.wellb.common.exception;

public class BusinessException extends RuntimeException {
	private final ErrorCode errorCode;
	
	public BusinessException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}
	
	public BusinessException(ErrorCode errorCode, String additionalMessage) {
		super(errorCode.getMessage() + ": " + additionalMessage);
		this.errorCode = errorCode;
	}
	
	public ErrorCode getErrorCode() {
		return errorCode;
	}
	
	public int getHttpStatus() {
		return errorCode.getHttpStatus().value();
	}
	
	public String getCode() {
		return errorCode.getCode();
	}
}
