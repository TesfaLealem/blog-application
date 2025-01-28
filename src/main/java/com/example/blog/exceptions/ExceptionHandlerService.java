package com.example.blog.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionHandlerService {@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
	return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
}

	@ExceptionHandler(UnauthorizedAccessException.class)
	public ResponseEntity<String> handleUnauthorizedAccess(UnauthorizedAccessException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<String> handleBadRequest(BadRequestException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DuplicateResourceException.class)
	public ResponseEntity<String> handleDuplicateResource(DuplicateResourceException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
	}

	@ExceptionHandler(NoContentException.class)
	public ResponseEntity<String> handleNoContent(NoContentException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<String> handleValidation(ValidationException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
	}

	@ExceptionHandler(ForbiddenActionException.class)
	public ResponseEntity<String> handleForbiddenAction(ForbiddenActionException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGenericException(Exception ex) {
		return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
