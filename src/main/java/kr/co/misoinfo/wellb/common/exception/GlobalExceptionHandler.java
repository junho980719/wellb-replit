package kr.co.misoinfo.wellb.common.exception;

import kr.co.misoinfo.wellb.common.response.ApiResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	public ApiResult<ErrorResponse> handleBusinessException(BusinessException ex) {
		ErrorResponse errorResponse = ErrorResponse.of(ex.getErrorCode(), "/api", ex.getDetail());
		return ApiResult.fail(errorResponse);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ApiResult<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
		ErrorCode notFoundCode = ErrorCode.RESOURCE_NOT_FOUND;
		ErrorResponse errorResponse = ErrorResponse.of(notFoundCode, "/api");
		return ApiResult.fail(errorResponse);
	}

	@ExceptionHandler(Exception.class)
	public ApiResult<ErrorResponse> handleGenericException(Exception ex) {
		ErrorCode internalErrorCode = ErrorCode.INTERNAL_SERVER_ERROR;
		ErrorResponse errorResponse = ErrorResponse.of(internalErrorCode, "/api", ex.getMessage());
		return ApiResult.fail(errorResponse);
	}
}