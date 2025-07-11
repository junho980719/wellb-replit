package kr.co.misoinfo.wellb.common.exception;

import kr.co.misoinfo.wellb.common.response.ApiResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ApiResult<Void>> handleBusinessException(BusinessException ex, WebRequest request) {
		String path = request.getDescription(false).replace("uri=", "");
		return ResponseEntity
			.status(ex.getErrorCode().getHttpStatus())
			.body(ApiResult.fail(ex.getErrorCode().getCode(), ex.getMessage()));
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResult<Void>> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		String path = request.getDescription(false).replace("uri=", "");
		return ResponseEntity
			.status(HttpStatus.NOT_FOUND)
			.body(ApiResult.fail("RESOURCE_NOT_FOUND", ex.getMessage()));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResult<Void>> handleGlobalException(Exception ex, WebRequest request) {
		String path = request.getDescription(false).replace("uri=", "");
		return ResponseEntity
			.status(HttpStatus.INTERNAL_SERVER_ERROR)
			.body(ApiResult.fail("INTERNAL_SERVER_ERROR", "서버 내부 오류가 발생했습니다."));
	}
}