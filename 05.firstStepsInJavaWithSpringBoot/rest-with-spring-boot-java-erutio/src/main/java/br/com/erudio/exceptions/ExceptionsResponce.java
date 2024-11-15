package br.com.erudio.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionsResponce implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private Date Timestamp;
	private String message;
	private String details;
	
	public ExceptionsResponce(Date timestamp, String message, String details) {
		Timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return Timestamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	
	
}
