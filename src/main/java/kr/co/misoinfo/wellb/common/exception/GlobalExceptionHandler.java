package kr.co.misoinfo.wellb.common.exception;

import kr.co.misoinfo.wellb.common.response.ApiResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ApiResult<Object>> handleBusinessException(BusinessException ex) {
		return ResponseEntity
			.status(ex.getErrorCode().getHttpStatus())
			.body(ApiResult.fail(ex.getErrorCode().getCode(), ex.getMessage()));
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResult<Object>> handleResourceNotFoundException(ResourceNotFoundException ex) {
		return ResponseEntity
			.status(HttpStatus.NOT_FOUND)
			.body(ApiResult.fail("RESOURCE_NOT_FOUND", ex.getMessage()));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResult<Object>> handleGenericException(Exception ex) {
		return ResponseEntity
			.status(HttpStatus.INTERNAL_SERVER_ERROR)
			.body(ApiResult.fail("INTERNAL_SERVER_ERROR", "서버 내부 오류가 발생했습니다."));
	}
}