package kr.co.misoinfo.wellb.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import kr.co.misoinfo.wellb.common.exception.ErrorResponse;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult<T> {
	private boolean success;
	private T data;
	private String message;

	private ApiResult(boolean success, T data, String message) {
		this.success = success;
		this.data = data;
		this.message = message;
	}

	// 성공 응답 - 데이터 없음
	public static <T> ApiResult<T> ok() {
		return new ApiResult<>(true, null, null);
	}

	// 성공 응답 - 데이터 있음
	public static <T> ApiResult<T> ok(T data) {
		return new ApiResult<>(true, data, null);
	}

	// 성공 응답 - 데이터와 메시지
	public static <T> ApiResult<T> ok(T data, String message) {
		return new ApiResult<>(true, data, message);
	}

	// 실패 응답 - 메시지만
	public static <T> ApiResult<T> fail(String message) {
		return new ApiResult<>(false, null, message);
	}

	// 실패 응답 - 데이터와 메시지
	public static <T> ApiResult<T> fail(T data, String message) {
		return new ApiResult<>(false, data, message);
	}

	public static ApiResult<ErrorResponse> fail(ErrorResponse errorResponse) {
		return new ApiResult<>(false, errorResponse, errorResponse.getMessage());
	}

	// Getters
	public boolean isSuccess() {
		return success;
	}

	public T getData() {
		return data;
	}

	public String getMessage() {
		return message;
	}

	// Setters (필요한 경우)
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}