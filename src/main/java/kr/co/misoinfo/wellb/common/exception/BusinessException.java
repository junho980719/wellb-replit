package kr.co.misoinfo.wellb.common.exception;

public class BusinessException extends RuntimeException {
	private final ErrorCode errorCode;
	private final String detail;

	public BusinessException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
		this.detail = null;
	}

	public BusinessException(ErrorCode errorCode, String detail) {
		super(errorCode.getMessage() + ": " + detail);
		this.errorCode = errorCode;
		this.detail = detail;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public String getDetail() {
		return detail;
	}
}