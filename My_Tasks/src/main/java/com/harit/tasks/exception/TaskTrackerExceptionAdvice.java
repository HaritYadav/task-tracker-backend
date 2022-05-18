package com.harit.tasks.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TaskTrackerExceptionAdvice {

	@ResponseBody
	@ExceptionHandler(TaskTrackerException.class)
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	public String TaskTrackerExceptionHandler(TaskTrackerException e) {
		return e.getMessage();
	}
	
}
