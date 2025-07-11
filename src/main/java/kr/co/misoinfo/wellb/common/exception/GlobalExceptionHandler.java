package kr.co.misoinfo.wellb.common.exception;

import kr.co.misoinfo.wellb.common.response.ApiResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// 비즈니스 예외 처리
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ApiResult<ErrorResponse>> handleBusinessException(BusinessException ex, HttpServletRequest request) {
		ErrorCode errorCode = ex.getErrorCode();
		ErrorResponse errorResponse = ErrorResponse.of(errorCode, request.getRequestURI(), ex.getDetail());
		ApiResult<ErrorResponse> result = ApiResult.fail(errorResponse, errorCode.getMessage());
		return ResponseEntity.status(errorCode.getHttpStatus()).body(result);
	}

	// 커스텀 예외 처리
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponse> handleCustomException(CustomException e, HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(
			e.getHttpStatus(),
			HttpStatus.valueOf(e.getHttpStatus()).getReasonPhrase(),
			e.getErrorCode(),
			e.getMessage(),
			request.getRequestURI()
		);

		return ResponseEntity.status(e.getHttpStatus()).body(errorResponse);
	}

	// Validation 에러 처리 (@Valid)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException e, HttpServletRequest request) {

		String message = e.getBindingResult().getFieldErrors().stream()
			.map(FieldError::getDefaultMessage)
			.collect(Collectors.joining(", "));

		ErrorResponse errorResponse = new ErrorResponse(
			HttpStatus.BAD_REQUEST.value(),
			"Bad Request",
			"VALIDATION_FAILED",
			"입력값 검증에 실패했습니다: " + message,
			request.getRequestURI()
		);

		return ResponseEntity.badRequest().body(errorResponse);
	}

	// Binding 에러 처리
	@ExceptionHandler(BindException.class)
	public ResponseEntity<ErrorResponse> handleBindException(BindException e, HttpServletRequest request) {
		String message = e.getBindingResult().getFieldErrors().stream()
			.map(FieldError::getDefaultMessage)
			.collect(Collectors.joining(", "));

		ErrorResponse errorResponse = new ErrorResponse(
			HttpStatus.BAD_REQUEST.value(),
			"Bad Request",
			"BINDING_FAILED",
			"데이터 바인딩에 실패했습니다: " + message,
			request.getRequestURI()
		);

		return ResponseEntity.badRequest().body(errorResponse);
	}

	// 잘못된 HTTP 메소드 처리
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(
			HttpRequestMethodNotSupportedException e, HttpServletRequest request) {

		ErrorResponse errorResponse = new ErrorResponse(
			HttpStatus.METHOD_NOT_ALLOWED.value(),
			"Method Not Allowed",
			"METHOD_NOT_ALLOWED",
			String.format("지원하지 않는 HTTP 메소드입니다: %s", e.getMethod()),
			request.getRequestURI()
		);

		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(errorResponse);
	}

	// 핸들러를 찾을 수 없는 경우 (404)
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ApiResult<ErrorResponse>> handleNotFoundException(NoHandlerFoundException ex, HttpServletRequest request) {
		ErrorResponse errorResponse = ErrorResponse.of(ErrorCode.RESOURCE_NOT_FOUND, request.getRequestURI(), "요청한 리소스를 찾을 수 없습니다");
		ApiResult<ErrorResponse> result = ApiResult.fail(errorResponse, ErrorCode.RESOURCE_NOT_FOUND.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
	}

	// 필수 파라미터 누락 처리
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<ErrorResponse> handleMissingServletRequestParameterException(
			MissingServletRequestParameterException e, HttpServletRequest request) {

		ErrorResponse errorResponse = new ErrorResponse(
			HttpStatus.BAD_REQUEST.value(),
			"Bad Request",
			"MISSING_PARAMETER",
			String.format("필수 파라미터가 누락되었습니다: %s", e.getParameterName()),
			request.getRequestURI()
		);

		return ResponseEntity.badRequest().body(errorResponse);
	}

	// 타입 변환 에러 처리
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(
			MethodArgumentTypeMismatchException e, HttpServletRequest request) {

		ErrorResponse errorResponse = new ErrorResponse(
			HttpStatus.BAD_REQUEST.value(),
			"Bad Request",
			"TYPE_MISMATCH",
			String.format("파라미터 타입이 올바르지 않습니다: %s", e.getName()),
			request.getRequestURI()
		);

		return ResponseEntity.badRequest().body(errorResponse);
	}

	// JSON 파싱 에러 처리
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(
			HttpMessageNotReadableException e, HttpServletRequest request) {

		ErrorResponse errorResponse = new ErrorResponse(
			HttpStatus.BAD_REQUEST.value(),
			"Bad Request",
			"JSON_PARSE_ERROR",
			"JSON 형식이 올바르지 않습니다",
			request.getRequestURI()
		);

		return ResponseEntity.badRequest().body(errorResponse);
	}

	// 데이터베이스 제약조건 위반 처리
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(
			DataIntegrityViolationException e, HttpServletRequest request) {

		ErrorResponse errorResponse = new ErrorResponse(
			HttpStatus.CONFLICT.value(),
			"Conflict",
			"DATA_INTEGRITY_VIOLATION",
			"데이터 무결성 제약조건에 위반됩니다",
			request.getRequestURI()
		);

		return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
	}

	// IllegalArgumentException 처리
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponse> handleIllegalArgumentException(
			IllegalArgumentException e, HttpServletRequest request) {

		ErrorResponse errorResponse = new ErrorResponse(
			HttpStatus.BAD_REQUEST.value(),
			"Bad Request",
			"ILLEGAL_ARGUMENT",
			"잘못된 인수입니다: " + e.getMessage(),
			request.getRequestURI()
		);

		return ResponseEntity.badRequest().body(errorResponse);
	}

	// 일반 RuntimeException 처리
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException e, HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(
			HttpStatus.INTERNAL_SERVER_ERROR.value(),
			"Internal Server Error",
			"RUNTIME_ERROR",
			"런타임 오류가 발생했습니다: " + e.getMessage(),
			request.getRequestURI()
		);

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	}

	// 모든 예외의 최종 처리
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResult<ErrorResponse>> handleGenericException(Exception ex, HttpServletRequest request) {
		ErrorResponse errorResponse = ErrorResponse.of(ErrorCode.INTERNAL_SERVER_ERROR, request.getRequestURI(), ex.getMessage());
		ApiResult<ErrorResponse> result = ApiResult.fail(errorResponse, ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
	}
}