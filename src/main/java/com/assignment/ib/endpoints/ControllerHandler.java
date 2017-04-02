package com.assignment.ib.endpoints;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.assignment.ib.validations.ValidationError;

/**
 * @author Tarun
 *
 */
@ControllerAdvice
public class ControllerHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ValidationError error = fromBindingErrors(exception.getBindingResult());
		return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);
	}

	public static ValidationError fromBindingErrors(Errors errors) {
		ValidationError error = new ValidationError("Validation failed. " + errors.getErrorCount() + " error(s)");
		for (ObjectError objectError : errors.getAllErrors()) {
			error.addValidationError(objectError.getDefaultMessage());
		}
		return error;
	}


}
