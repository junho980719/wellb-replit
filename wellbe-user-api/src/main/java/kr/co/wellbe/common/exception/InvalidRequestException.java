
package kr.co.wellbe.common.exception;

public class InvalidRequestException extends CustomException {
	public InvalidRequestException(String message) {
		super("INVALID_REQUEST", message, 400);
	}
}
