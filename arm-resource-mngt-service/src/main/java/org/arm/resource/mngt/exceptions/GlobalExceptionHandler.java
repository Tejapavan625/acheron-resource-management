package org.arm.resource.mngt.exceptions;

import java.sql.Timestamp;
import java.time.Instant;

import org.arm.resource.mngt.entity.ApiErrors;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@Override //
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		Timestamp timestamp = Timestamp.from(Instant.now());
		String error = "Method not allowed";
		int nstatus = status.value();
		ApiErrors errors = new ApiErrors(timestamp, message, nstatus, error);

		return ResponseEntity.status(status).body(errors);
	}

	@Override // U r given Method which is Not There
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String message = ex.getMessage();
		Timestamp timestamp = Timestamp.from(Instant.now());
		String error = "Method not allowed";

		ApiErrors errors = new ApiErrors(timestamp, message, status.value(), error);
		return ResponseEntity.status(status).body(errors);
	}

	@Override // Path or Url Miss match Exception
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		Timestamp timestamp = Timestamp.from(Instant.now());
		String error = "Path variable is missing";
		ApiErrors errors = new ApiErrors(timestamp, message, status.value(), error);

		return ResponseEntity.status(status).body(errors);
	}

	@Override // Exception realted Servlet Request
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		Timestamp timestamp = Timestamp.from(Instant.now());
		String error = "Servelet request parameter is missing";
		ApiErrors errors = new ApiErrors(timestamp, message, status.value(), error);

		return ResponseEntity.status(status).body(errors);
	}

	@Override // Data type Miss Match Exception
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		String message = ex.getMessage();
		Timestamp timestamp = Timestamp.from(Instant.now());
		String error = "Type mismatch";
		ApiErrors errors = new ApiErrors(timestamp, message, status.value(), error);
		return ResponseEntity.status(status).body(errors);
	}

	@ExceptionHandler(CampaignNotFoundException.class) // User Defined Exception
	protected ResponseEntity<Object> handleCampaignNotFound(CampaignNotFoundException ex) {
		String message = ex.getMessage();
		Timestamp timestamp = Timestamp.from(Instant.now());
		String error = "Camapign Not Found";
		ApiErrors errors = new ApiErrors(timestamp, message, HttpStatus.CONFLICT.value(), error);
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errors);
	}

	@ExceptionHandler(ProjectNotFoundException.class) // User Defined Exception
	protected ResponseEntity<Object> handleProjectNotFound(ProjectNotFoundException ex) {
		String message = ex.getMessage();
		Timestamp timestamp = Timestamp.from(Instant.now());
		String error = "Project Not Found";
		ApiErrors errors = new ApiErrors(timestamp, message, HttpStatus.CONFLICT.value(), error);
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errors);
	}

	@ExceptionHandler(TaskNotFoundException.class) // User Defined Exception
	protected ResponseEntity<Object> handleTaskNotFound(TaskNotFoundException ex) {
		String message = ex.getMessage();
		Timestamp timestamp = Timestamp.from(Instant.now());
		String error = "Task Not Found";
		ApiErrors errors = new ApiErrors(timestamp, message, HttpStatus.CONFLICT.value(), error);
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errors);
	}

	@ExceptionHandler(Exception.class) // Other than all exceptions
	protected ResponseEntity<Object> handleOtherException(Exception ex) {
		String message = ex.getMessage();
		Timestamp timestamp = Timestamp.from(Instant.now());
		String error = "Other Exceptions";
		ApiErrors errors = new ApiErrors(timestamp, message, HttpStatus.BAD_GATEWAY.value(), error);
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(errors);

	}

}
