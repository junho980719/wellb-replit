package kr.co.misoinfo.core.common.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
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
}