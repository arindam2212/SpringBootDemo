package com.sa.gps.tracker.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sa.gps.tracker.exception.TrackerException;
import com.sa.gps.tracker.model.ErrorResponse;

@ControllerAdvice
public class ExceptionResolver {

	@ExceptionHandler(value = { JsonProcessingException.class, Exception.class })
	@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
	@ResponseBody
	public ErrorResponse formatJsonServerError(Exception ex, HttpServletRequest req) {
		ErrorResponse response = new ErrorResponse();
		response.setDetails("Unexpected error.");
		response.setType("fatal");
		return response;
	}

	@ExceptionHandler(TrackerException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse formatNotFoundError(TrackerException ex, HttpServletRequest req) {
		ErrorResponse response = new ErrorResponse();
		response.setDetails(ex.getMessage());
		response.setType("error");
		return response;
	}

}
