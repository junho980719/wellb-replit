
package kr.co.misoinfo.wellb.common.exception;

public class ResourceNotFoundException extends CustomException {
	public ResourceNotFoundException(String resource, String identifier) {
		super("RESOURCE_NOT_FOUND", 
			String.format("%s를 찾을 수 없습니다. ID: %s", resource, identifier), 
			404);
	}
}
