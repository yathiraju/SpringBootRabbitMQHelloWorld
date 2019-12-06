package com.javainuse.error;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.hibernate.exception.SQLGrammarException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ GlobalErrormessage.class })
	public ResponseEntity<CustomErrorResponse> handle(GlobalErrormessage ex) {

		return new ResponseEntity<>(getCustomErrorResponse(ex), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ EntityServiceException.class, SQLException.class, NullPointerException.class,
			SQLGrammarException.class })
	public ResponseEntity<CustomErrorResponse> customHandleNotFound(Exception ex) throws IOException {

		return new ResponseEntity<>(getCustomErrorResponse(ex), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler({ EntityServiceValidationException.class })
	public ResponseEntity<CustomErrorResponse> handlebadRequest(EntityServiceValidationException ex) {
		return new ResponseEntity<>(getCustomErrorResponse(ex), HttpStatus.BAD_REQUEST);
	}

	public CustomErrorResponse getCustomErrorResponse(Exception ex) {
		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setTimestamp(LocalDateTime.now());
		customErrorResponse.setError(ex.getMessage());
		return customErrorResponse;
	}

}
