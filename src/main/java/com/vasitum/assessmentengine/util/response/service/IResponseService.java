package com.vasitum.assessmentengine.util.response.service;

import com.vasitum.assessmentengine.util.response.model.Response;
import org.springframework.http.HttpStatus;

/**
 * @author Sagar Maharana
 *  
 * @apiNote This Service is for centralize Response to the n
 * {@code}success() is used for in successful case and failure() for negative case
 * 
 * */

public interface IResponseService {
	 Response success(HttpStatus httpStatusCode);
	 Response success(String message, HttpStatus httpStatusCode);
	 Response success(String message, HttpStatus httpStatusCode, Object data);
	 Response failure(HttpStatus httpStatusCode);
	 Response failure(String message, HttpStatus httpStatusCode);
	 Response failure(String message, HttpStatus httpStatusCode, Object data);
}
