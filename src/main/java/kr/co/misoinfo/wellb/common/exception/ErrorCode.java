
package kr.co.misoinfo.wellb.common.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
	// 요청 관련 에러 (400 Bad Request)
	INVALID_REQUEST("INVALID_REQUEST", "잘못된 요청입니다", HttpStatus.BAD_REQUEST),
	INVALID_USER_ID("INVALID_USER_ID", "유효하지 않은 사용자 ID입니다", HttpStatus.BAD_REQUEST),
	EMPTY_EMAIL("EMPTY_EMAIL", "이메일이 비어있습니다", HttpStatus.BAD_REQUEST),
	EMPTY_USER_INFO("EMPTY_USER_INFO", "사용자 정보가 비어있습니다", HttpStatus.BAD_REQUEST),
	EMPTY_USER_NAME("EMPTY_USER_NAME", "사용자 이름은 필수입니다", HttpStatus.BAD_REQUEST),
	EMPTY_USER_EMAIL("EMPTY_USER_EMAIL", "이메일은 필수입니다", HttpStatus.BAD_REQUEST),
	EMPTY_UPDATE_INFO("EMPTY_UPDATE_INFO", "수정할 사용자 정보가 비어있습니다", HttpStatus.BAD_REQUEST),
	
	// 리소스 관련 에러 (404 Not Found)
	USER_NOT_FOUND("USER_NOT_FOUND", "사용자를 찾을 수 없습니다", HttpStatus.NOT_FOUND),
	RESOURCE_NOT_FOUND("RESOURCE_NOT_FOUND", "리소스를 찾을 수 없습니다", HttpStatus.NOT_FOUND),
	
	// 중복 관련 에러 (409 Conflict)
	DUPLICATE_EMAIL("DUPLICATE_EMAIL", "이미 존재하는 이메일입니다", HttpStatus.CONFLICT),
	DUPLICATE_RESOURCE("DUPLICATE_RESOURCE", "이미 존재하는 리소스입니다", HttpStatus.CONFLICT),
	
	// 서버 에러 (500 Internal Server Error)
	INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", "서버 내부 오류가 발생했습니다", HttpStatus.INTERNAL_SERVER_ERROR);
	
	private final String code;
	private final String message;
	private final HttpStatus httpStatus;
	
	ErrorCode(String code, String message, HttpStatus httpStatus) {
		this.code = code;
		this.message = message;
		this.httpStatus = httpStatus;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
}
