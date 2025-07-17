package kr.co.misoinfo.core.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult<T> {
	private boolean success;
	private T data;
	private String message;

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

	// 실패 응답 - 데이터
	public static <T> ApiResult<T> fail(T data) {
		return new ApiResult<>(false, data, null);
	}

	// 실패 응답 - 메시지만
	public static <T> ApiResult<T> fail(String message) {
		return new ApiResult<>(false, null, message);
	}

	// 실패 응답 - 데이터와 메시지
	public static <T> ApiResult<T> fail(T data, String message) {
		return new ApiResult<>(false, data, message);
	}
}