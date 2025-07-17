
package kr.co.wellbe.common.exception;

public class DuplicateResourceException extends CustomException {
	public DuplicateResourceException(String resource, String value) {
		super("DUPLICATE_RESOURCE", 
			String.format("이미 존재하는 %s입니다: %s", resource, value), 
			409);
	}
}
