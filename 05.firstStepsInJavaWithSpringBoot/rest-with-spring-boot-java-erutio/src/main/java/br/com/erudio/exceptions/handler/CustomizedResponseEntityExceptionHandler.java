package br.com.erudio.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.erudio.exceptions.ExceptionsResponce;
import br.com.erudio.exceptions.UnsupportedMathOperationException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionsResponce> handleAllExceptions(Exception ex, WebRequest request) {
		
		
		ExceptionsResponce exceptionsResponce = new ExceptionsResponce(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(exceptionsResponce, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UnsupportedMathOperationException.class)
	public final ResponseEntity<ExceptionsResponce> handleBadRequestExceptions(Exception ex, WebRequest request) {
		
		
		ExceptionsResponce exceptionsResponce = new ExceptionsResponce(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(exceptionsResponce, HttpStatus.BAD_REQUEST);
	}

}
