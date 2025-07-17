
package kr.co.misoinfo.core.common.exception;

public class CustomException extends RuntimeException {
	private final String errorCode;
	private final int httpStatus;
	
	public CustomException(String errorCode, String message, int httpStatus) {
		super(message);
		this.errorCode = errorCode;
		this.httpStatus = httpStatus;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	
	public int getHttpStatus() {
		return httpStatus;
	}
}
