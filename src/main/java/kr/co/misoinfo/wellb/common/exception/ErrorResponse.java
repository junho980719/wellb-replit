
package kr.co.misoinfo.wellb.common.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class ErrorResponse {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime timestamp;
	private int status;
	private String error;
	private String errorCode;
	private String message;
	private String path;
	
	public ErrorResponse() {
		this.timestamp = LocalDateTime.now();
	}
	
	public ErrorResponse(int status, String error, String errorCode, String message, String path) {
		this();
		this.status = status;
		this.error = error;
		this.errorCode = errorCode;
		this.message = message;
		this.path = path;
	}
	
	// Getters and Setters
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getError() {
		return error;
	}
	
	public void setError(String error) {
		this.error = error;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
}
package kr.co.misoinfo.wellb.common.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class ErrorResponse {
	private boolean success;
	private String code;
	private String message;
	private String path;
	private String detail;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime timestamp;

	private ErrorResponse(boolean success, String code, String message, String path, String detail) {
		this.success = success;
		this.code = code;
		this.message = message;
		this.path = path;
		this.detail = detail;
		this.timestamp = LocalDateTime.now();
	}

	public static ErrorResponse of(ErrorCode errorCode, String path, String detail) {
		return new ErrorResponse(false, errorCode.getCode(), errorCode.getMessage(), path, detail);
	}

	public static ErrorResponse of(ErrorCode errorCode, String path) {
		return new ErrorResponse(false, errorCode.getCode(), errorCode.getMessage(), path, null);
	}

	// Getters
	public boolean isSuccess() {
		return success;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String getPath() {
		return path;
	}

	public String getDetail() {
		return detail;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
}
